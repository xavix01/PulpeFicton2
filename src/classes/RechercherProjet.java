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

    /**
     * Enregistre les informations passé en paramètre dans un bean projet. puis
     * envoi les informations à la DAOParticipe
     *
     * @param idProjetSelectionne
     * @return boolean
     */
    public boolean aUneEquipe(String idProjetSelectionne) {
        DAOParticipe dAOParticipe = dAOFactory.getDAOParticipe();
        projet.setId_projet(Integer.parseInt(idProjetSelectionne));
        if (dAOParticipe.equipeProjet(projet).isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Enregistre les informations passé en paramètre dans un bean projet, puis
     * les envois à la DAOProjet le nombre de jour de ce projet est calculé.
     *
     * @param idProjet
     * @return int
     */
    public int nbreJourTravailleProjet(String idProjet) {
        DAOProjet dAOProjet = dAOFactory.getDAOProjet();
        projet.setId_projet(Integer.parseInt(idProjet));
        dAOProjet.infoProjet(projet);
        return projet.getDuree_projet() * 5;

    }

    /**
     * Enregistre les informations passé en paramètre dans un bean Client, puis
     * l'envoi à la DAOProjet
     *
     * @param idClient
     * @return Vector<Vector>
     */
    public Vector projetClient(String idClient) {
        DAOProjet dAOProjet = dAOFactory.getDAOProjet();
        Client client = new Client();
        client.setId_client(Integer.parseInt(idClient));
        Vector vector = new Vector();
        vector = dAOProjet.getProjetClientConsultation(client);
        return vector;
    }

    /**
     * Enregistre les informations passé en paramètre dans un bean Projet, puis
     * l'envoi à la DAOEtudiant
     *
     * @param idprojet
     * @return Vector<Vector>
     */
    public Vector etudiantDuProjet(int idprojet) {
        DAOEtudiant daoEtudiant = dAOFactory.getDAOEtudiant();
        projet.setId_projet(idprojet);
        return daoEtudiant.getEtudiantProjet(projet);
    }
}
