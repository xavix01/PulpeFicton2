/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOEtudiant;
import DAO.DAOFactory;
import DAO.DAOProjet;
import DAO.DAOParticipe;
import beans.Client;
import beans.Projet;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class RechercherProjet {

    DAOFactory dAOFactory;
    Projet projet;

    public RechercherProjet() {
        dAOFactory = new DAOFactory();
        projet = new Projet();
    }

    public boolean aUneEquipe(String idProjetSelectionne) {
        DAOParticipe dAOParticipe = dAOFactory.getDAOParticipe();
        projet.setId_projet(Integer.parseInt(idProjetSelectionne));
        if (dAOParticipe.equipeProjet(projet).isEmpty()) {
            return false;
        }
        return true;
    }

    public int nbreJourTravailleProjet(String idProjet) {
        DAOProjet dAOProjet = dAOFactory.getDAOProjet();
        projet.setId_projet(Integer.parseInt(idProjet));
        dAOProjet.infoProjet(projet);
        return projet.getDuree_projet() * 5;

    }

    public Vector projetClient(String idClient) {
        DAOProjet dAOProjet = dAOFactory.getDAOProjet();
        Client client = new Client();
        client.setId_client(Integer.parseInt(idClient));
        Vector vector = new Vector();
        vector = dAOProjet.getProjetClientConsultation(client);
        return vector;
    }

    public Vector etudiantDuProjet(int idprojet) {
        DAOEtudiant daoEtudiant = dAOFactory.getDAOEtudiant();
        projet.setId_projet(idprojet);
        return daoEtudiant.getEtudiantProjet(projet);
    }
}
