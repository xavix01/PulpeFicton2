/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOEtudiant;
import DAO.DAOFactory;
import DAO.DAOProjet;
import beans.Etudiant;
import beans.Frais;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author xavix
 */
public class ClasseFraisEtudiant {

    public DefaultComboBoxModel recupereListeEtu() {
        DefaultComboBoxModel modelEtu = new DefaultComboBoxModel();
        Vector vectorEtu = new Vector();
        DAOFactory daoFactory = new DAOFactory();
        DAOEtudiant daoEtudiant = daoFactory.getDAOEtudiant();
        vectorEtu = daoEtudiant.getEtudiant();
        Iterator it = vectorEtu.iterator();
        Etudiant etu = new Etudiant();
        while (it.hasNext()) {
            etu = (Etudiant) it.next();
            modelEtu.addElement(etu.getNomEtudiant());
        }
        return modelEtu;
    }

    /**
     * la liste de projet concernant l'etudiant passé en paramètre
     *
     * @param nomEtu
     * @return Vector<Vector>
     */
    public Vector recupereListeProjet(String nomEtu) {
        DAOFactory dAOFactory = new DAOFactory();
        Etudiant etudiant = new Etudiant();
        etudiant.setNomEtudiant(nomEtu);
        DAOProjet daoProjet = dAOFactory.getDAOProjet();
        return daoProjet.getProjetParEtudiant(etudiant);
    }

    /**
     * Enregistre dans un bean frais les paramètres; transmission de ce bean à
     * la DAO
     *
     * @param idProjet
     * @param nomEtu
     * @param jour
     * @param mois
     * @param annee
     * @param deplacement
     * @param sejour
     * @param autres
     */
    public void ajoutFrais(String idProjet, String nomEtu, String jour,
            String mois, String annee, String deplacement, String sejour, String autres) {
        Frais frais = new Frais();
        if (!deplacement.isEmpty()) {
            frais.setMontantDeplacement(Integer.parseInt(deplacement));
        }
        if (!sejour.isEmpty()) {
            frais.setMontantSejour(Integer.parseInt(sejour));
        }
        if (!autres.isEmpty()) {
            frais.setMontantAutres(Integer.parseInt(autres));
        }
        ;
        frais.setIdProjet(Integer.parseInt(idProjet));
        frais.setNomEtudiant(nomEtu);
        frais.setAnnee(Integer.parseInt(annee));
        frais.setMois(mois);
        frais.setJour(Integer.parseInt(jour));
        DAOFactory daoFactory = new DAOFactory();
        DAOEtudiant daoEtudiant = daoFactory.getDAOEtudiant();
        daoEtudiant.addFees(frais);
    }
}
