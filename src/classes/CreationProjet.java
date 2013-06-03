/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOFactory;
import DAO.DAOParticipe;
import DAO.DAOProjet;
import beans.Client;
import beans.Projet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author xavix
 */
public class CreationProjet {

    private Client client;
    private Projet projet;
    DAOFactory daoFactory;

    public CreationProjet() {
        client = new Client();
        projet = new Projet();
        daoFactory = new DAOFactory();

    }

    public void addProjet(String idClient, String nomProjet, String dureeProjet, String dateFinPrevue, String prixJournee) {
        DAOProjet daoProjet = daoFactory.getDAOProjet();
        client.setId_client(Integer.parseInt(idClient));
        projet.setNom_projet(nomProjet);
        projet.setDuree_projet(Integer.parseInt(dureeProjet));
        projet.setDate_fin_projet(dateFinPrevue);
        projet.setPrix_journee(Integer.parseInt(prixJournee));
        daoProjet.addProjet(projet, client);
    }

    public boolean ajoutEquipe(TableModel model, String idResponsable, String idProjet) {
        DAOParticipe daoPraticipe = daoFactory.getDAOParticipe();
        DAOProjet daoProjet = daoFactory.getDAOProjet();
        DefaultTableModel model1 = (DefaultTableModel) model;
        Vector listeEtudiantSelectionne = new Vector();
        listeEtudiantSelectionne = model1.getDataVector();

        if (!listeEtudiantSelectionne.isEmpty() && !idResponsable.isEmpty()) {
            projet.setListeEtudiantIdNom(listeEtudiantSelectionne);
            projet.setId_projet(Integer.parseInt(idProjet));
            projet.setIdEtudiantResponsable(Integer.parseInt(idResponsable));
            daoPraticipe.addParticipe(projet);

            daoProjet.setResponsableProjet(projet);
            return true;
        }
        return false;
    }

    public int ajoutConvention(int idProjet, Client client) {
        DAOProjet daoProjet = daoFactory.getDAOProjet();
        projet.setClient(client);
        projet.setId_projet(idProjet);
        daoProjet.setConvention(projet);
        return projet.getId_convention();
    }
}
