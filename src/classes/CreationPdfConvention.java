/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOFactory;
import DAO.DAOProjet;
import beans.Projet;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class CreationPdfConvention {
    
    private static String FILE = "/home/xavix/Documents/test1.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private DAOFactory dAOFactory;
    DAOProjet daoProjet;
    Projet projet;
    /**
     * Permet de créer un pdf de la convention avec toutes les informations necessaires 
     * @param idProjet 
     */
    public CreationPdfConvention(int idProjet) {
        
        projet = new Projet();
        dAOFactory = new DAOFactory();
        daoProjet = dAOFactory.getDAOProjet();
        projet.setId_projet(idProjet);
        daoProjet.getProjetCompletPourConv(projet);
        try {
            Projet pro = new Projet();
            pro = projet;
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document, pro);
            ajouterTableau(document, projet);
            //addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     * Ajoute les meta données au pdf
     * @param document 
     */
    private static void addMetaData(Document document) {
        document.addTitle("Convention");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }
    
    /**
     * Ajoute le tableau avec le nom du responsable du projet, les etudiants de ce projet
     * et le nombre de jour qu'il travaille
     * @param document
     * @param projet
     * @throws DocumentException 
     */
    private static void ajouterTableau(Document document, Projet projet) throws DocumentException {
        Vector v = new Vector<>();
        v = projet.getListeEtudiantIdNom();
        
        List liste1 = new List();
        List liste2 = new List();
        
        int i = 1;
        Iterator it = v.iterator();
        while (it.hasNext()) {
            if (i % 2 != 0) {
                liste1.add(new ListItem((String) it.next()));
            } else {
                
                liste2.add(new ListItem(String.valueOf((int) it.next())));
            }
            i++;
        }
        
        
        PdfPTable table = new PdfPTable(3); // 3 columns.

        PdfPCell cell1 = new PdfPCell(new Paragraph("Nom étudiant responsable"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Noms étudiants réalisateurs"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("nombre de jours d'étude"));
        
        
        
        PdfPCell responsable = new PdfPCell(new Paragraph(String.valueOf(projet.getIdEtudiantResponsable())));
        
        PdfPCell listeEtudiant = new PdfPCell();
        listeEtudiant.addElement(liste1);
        
        PdfPCell listeNombreHeures = new PdfPCell();
        listeNombreHeures.addElement(liste2);
        
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        responsable.setHorizontalAlignment(Element.ALIGN_CENTER);
        listeEtudiant.setHorizontalAlignment(Element.ALIGN_CENTER);
        listeNombreHeures.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(responsable);
        table.addCell(listeEtudiant);
        table.addCell(listeNombreHeures);
        
        
        
        document.add(table);
    }
    /**
     * Ajoute au pdf, le titre , la date, le projet concerné, le numero de convention
     * @param document
     * @param pro
     * @throws DocumentException 
     */
    private static void addTitlePage(Document document, Projet pro)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header

        Paragraph titre = new Paragraph("FICHE CONVENTION", catFont);
        titre.setAlignment(Element.ALIGN_CENTER);
        preface.add(titre);
        
        addEmptyLine(preface, 4);
        
        
        Phrase l1 = new Phrase();
        l1.add("Date : " + new Date());
        addTabulation(l1, 22);
        l1.add("Numéro de convention : " + pro.getId_convention());
        preface.add(new Paragraph(l1));
        
        Phrase l = new Phrase();
        addTabulation(l, 54);
        l.add("Nom de l'étude : " + pro.getNom_projet());
        
        Paragraph p1 = new Paragraph(l);
        
        preface.add(p1);
        addEmptyLine(preface, 2);
        
        preface.add(new Paragraph("Nom de l'entreprise :             " + pro.getClient().getNom_client(), smallBold));
        preface.add(new Paragraph("Adresse de l'entreprise :        " + pro.getClient().getAdresse_client(), smallBold));
        preface.add(new Paragraph("Tél l'entreprise :                     " + pro.getClient().getTelephone_client(), smallBold));
        
        addEmptyLine(preface, 2);
        
        Phrase l2 = new Phrase();
        l2.add("Durée de l'étude");
        addTabulation(l2, 18);
        l2.add("Date fin prévue");
        addTabulation(l2, 18);
        l2.add("Durée Prix/journée");
        
        
        Paragraph p2 = new Paragraph(l2);
        
        Phrase l3 = new Phrase();
        addTabulation(l3, 5);
        l3.add(String.valueOf(pro.getDuree_projet()));
        addTabulation(l3, 27);
        l3.add(String.valueOf(pro.getDate_fin_projet()));
        addTabulation(l3, 25);
        l3.add(String.valueOf(pro.getPrix_journee()));
        
        Paragraph p3 = new Paragraph(l3);
        
        preface.add(p2);
        
        preface.add(p3);
        
        addEmptyLine(preface, 4);
        
        document.add(preface);
        
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    private static void addTabulation(Phrase phrase, int number) {
        for (int i = 0; i < number; i++) {
            phrase.add(new Phrase("  "));
        }
    }
}