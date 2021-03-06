/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOClient;
import DAO.DAOFactory;
import beans.Client;

/**
 *
 * @author xavix
 */
public class CreationClient {

    Client client;
    DAOFactory daoFactory;

    /**
     * enregistre dans un bean client , les informations passé en paramètre,
     * puis les transmet à la DAO
     *
     * @param nomClient
     * @param adresseClient
     * @param telephoneClient
     * @param contactClient
     */
    public CreationClient(String nomClient, String adresseClient, String telephoneClient, String contactClient) {
        daoFactory = new DAOFactory();// Préparation de la connexion à la
        DAOClient daoClient = daoFactory.getDAOClient();// base de donnée
        daoClient = daoFactory.getDAOClient();

        client = new Client();    // Creation bean Client de stockage


        daoClient = daoFactory.getDAOClient(); // base de donnée

        client.setNom_client(nomClient);                    // Enregistrement des
        client.setAdresse_client(adresseClient);            // informations dans le
        String tel = telephoneClient;                       // bean Client
        client.setTelephone_client(Integer.parseInt(tel));  //
        client.setNom_contact(contactClient);               //

        daoClient.addClient(client); // transmission du bean client a la DAO
    }
}
