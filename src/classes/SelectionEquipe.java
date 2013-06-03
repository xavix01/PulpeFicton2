/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOEtudiant;
import DAO.DAOFactory;
import DAO.DAOParticipe;
import DAO.DAOProjet;
import beans.Projet;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class SelectionEquipe {

    DAOFactory dAOFactory;
    Projet projet;

    public SelectionEquipe() {
        dAOFactory = new DAOFactory();
        projet = new Projet();
    }

    public Vector rechercheEtudiant() {

        DAOEtudiant daoEtudiant = dAOFactory.getDAOEtudiant();
        Vector vector2D = new Vector();
        vector2D = daoEtudiant.getVectorEtudiant();
        return vector2D;
    }

    public Vector rechercheProjet(String nomProjetRecep) {

        DAOProjet daoProjet = dAOFactory.getDAOProjet();
        Vector vector2D = new Vector();
        projet.setNom_projet(nomProjetRecep);
        vector2D = daoProjet.getRechercheProjetParNom(projet);
        return vector2D;
    }
}
