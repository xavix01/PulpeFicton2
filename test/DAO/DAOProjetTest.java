/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Client;
import beans.Etudiant;
import beans.Projet;
import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xavix
 */
public class DAOProjetTest {

    public DAOProjetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UtilsJUnit4test : @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UtilsJUnit4test : @AfterClass method");
    }

   /* 
     @Test
     public void testAddProjet() {
     System.out.println("addProjet");
        
     Client client = new Client();
     client.setId_client(4);
        
     Projet projet = new Projet();
     projet.setId_projet(7);
     projet.setClient(client);
     projet.setDate_fin_projet("27/12/2000");
     projet.setDuree_projet(25);
     projet.setPrix_journee(20);
     projet.setNom_projet("CAAAAA");
        
     DAOFactory dAOFactory=new DAOFactory();
     DAOProjet instance = dAOFactory.getDAOProjet();
     instance.addProjet(projet, client);
        
     Projet projectVerifierDansBase=new Projet();
     projectVerifierDansBase.setId_projet(7);
     instance.getProjetParId(projectVerifierDansBase);
        
        
        
     assertEquals(projectVerifierDansBase, projet);
     // TODO review the generated test code and remove the default call to fail.
     //fail("The test case is a prototype.");
     }
     
    @Test
    public void testGetProjetCompletPourConv() {
        System.out.println("getProjetCompletPourConv");
        Client client = new Client();
        client.setId_client(4);

        client.setAdresse_client("priay");
        client.setNom_client("dada");
        client.setNom_contact("jean");
        client.setTelephone_client(437415852);

        Projet projet = new Projet();
        projet.setClient(client);
        projet.setId_projet(7);
        projet.setDate_fin_projet("27/12/2000");
        projet.setDuree_projet(25);
        projet.setNom_projet("CAAAAA");
        projet.setIdEtudiantResponsable(2);
        projet.setPrix_journee(20);
        projet.setId_convention(47);

        Etudiant etudiant = new Etudiant();
        Etudiant etudiant2 = new Etudiant();
        
        etudiant.setIdEtudiant(1);
        etudiant.setNomEtudiant("MOMO");
        etudiant.setPrenomEtudiant("roro");
        etudiant.setAdresseEtudiant(null);
        etudiant.setDateNaissanceEtudiant("25/12/2000");
        
        etudiant2.setIdEtudiant(2);
        etudiant2.setNomEtudiant("MAMA");
        etudiant2.setPrenomEtudiant("riri");
        etudiant2.setAdresseEtudiant(null);
        etudiant.setDateNaissanceEtudiant("25/12/2000");
        
        Vector listeEtu= new Vector();
        listeEtu.add(etudiant);
        listeEtu.add(etudiant2);
        
        projet.setListeEtudiantIdNom(listeEtu);
        
        Projet projet1 = new Projet();
        projet1.setId_projet(7);

        DAOFactory dAOFactory = new DAOFactory();
        DAOProjet instance = dAOFactory.getDAOProjet();
        instance.getProjetCompletPourConv(projet1);

        assertEquals(projet1, projet);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    @Test
    public void testGetProjetParClient_int() {
        System.out.println("getProjetParClient");
        int idClient = 3;
        DAOFactory dAOFactory = new DAOFactory();
        DAOProjet instance = dAOFactory.getDAOProjet();

        Vector expResult = new Vector();
        expResult.add("ioezjdoiezjd");
        expResult.add("coco");

        Vector result = instance.getProjetParClient(idClient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetProjetParClient_String() {
        System.out.println("getProjetParClient");
        String idClient = "8";
        DAOFactory dAOFactory = new DAOFactory();
        DAOProjet instance = dAOFactory.getDAOProjet();
        Vector v = new Vector();
        Vector expResult = new Vector();
        expResult.add(3);
        expResult.add(0);
        expResult.add("JAJAJ");
        expResult.add("02/12/2222");
        expResult.add(60);
        expResult.add(10);
        v.add(expResult);

        Vector result = instance.getProjetParClient(idClient);
        assertEquals(v, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRechercheProjetParNom() {
        System.out.println("getRechercheProjetParNom");
        Projet projet = new Projet();
        projet.setNom_projet("ioezjdoiezjd");

        DAOFactory dAOFactory = new DAOFactory();
        DAOProjet instance = dAOFactory.getDAOProjet();
        Vector v = new Vector();
        Vector expResult = new Vector();
        expResult.add(1);
        expResult.add("ioezjdoiezjd");
        expResult.add("8484");
        expResult.add(85);
        expResult.add(252);
        v.add(expResult);
        Vector result = instance.getRechercheProjetParNom(projet);
        assertEquals(v, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}