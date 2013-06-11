/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xavix
 */
public class SelectionEquipeTest {
    
    public SelectionEquipeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * Test of rechercheProjet method, of class SelectionEquipe.
     */
    @Test
    public void testRechercheProjet() {
        System.out.println("rechercheProjet");
        String nomProjetRecep = "Lampion";
        SelectionEquipe instance = new SelectionEquipe();
        Vector expResult = new Vector();
        Vector v = new Vector();
        v.add(2);
        v.add("Lampion");
        v.add("12/12/03");
        v.add(78);
        v.add(78);
        expResult.add(v);
        
        Vector result = instance.rechercheProjet(nomProjetRecep);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}