/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOClient;
import DAO.DAOFactory;
import beans.Client;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class RechercherClient {

    Client client;
    Vector vector2D;

    public RechercherClient() {
    }

    /**
     * Enregistre dans un bean CLient, les informations passé en paramètre, puis
     * les envoie à la dao.
     *
     * @param idClient
     * @param nomClient
     * @return Vector<Vector>
     */
    public Vector listeClientRecherhe(String idClient, String nomClient) {
        DAOFactory daoFactory = new DAOFactory();
        DAOClient daoClient = daoFactory.getDAOClient();
        if (!idClient.isEmpty() || !nomClient.isEmpty()) {
            client = new Client();
            vector2D = new Vector();
            daoFactory = new DAOFactory();
            daoClient = daoFactory.getDAOClient();
            if (!idClient.isEmpty()) {
                client.setId_client(Integer.parseInt(idClient));
            }

            client.setNom_client(nomClient);
            vector2D = daoClient.getClientRecherche(client);
        }
        return vector2D;
    }
}
