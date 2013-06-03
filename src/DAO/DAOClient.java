/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


/**
 *
 * @author xavix
 */
public class DAOClient {

    private DAOFactory factory;

    public DAOClient(DAOFactory factory) {
        this.factory = factory;
    }

    public void addClient(Client client) {

        try {
            Connection connection = factory.getConnection(); // création de la connexion
            Statement statement = connection.createStatement(); 

            statement.executeUpdate("INSERT INTO `Client` (`nomClient`, `adresseClient`, `telClient`, `contactClient`) VALUES\n"
                    + "('" + client.getNom_client() + "', '" + client.getAdresse_client() + "', " + client.getTelephone_client() + ", '" + client.getNom_contact() + "');");
            
            /* Fermeture des ressources */
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
    }

    @SuppressWarnings("empty-statement")
    public Vector getClientRecherche(Client client) {
        Vector myVector2D = new Vector();
        try {
            int recepNUCLI;
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            
            //requete executé si les 2 champs sont entré
            if (!client.getNom_client().isEmpty() && client.getId_client()!=0) {
                recepNUCLI = Integer.parseInt(String.valueOf(client.getId_client()));
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `idClient`=" + recepNUCLI + " AND `nomClient`like '%" + client.getNom_client() + "%';");
            }
            
            //requete executé si uniquement le champ numéro client est entré
            else if (client.getNom_client().isEmpty() && client.getId_client()!=0) {
                recepNUCLI = Integer.parseInt(String.valueOf(client.getId_client()));
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `idClient`=" + recepNUCLI + ";");
            }
            
            //requete executé si uniquement le champ nom client est entré
            else if (!client.getNom_client().isEmpty() && client.getId_client()==0) {
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `nomClient`like '%" + client.getNom_client() + "%';");
            }

            while (resultSet.next()) {
                    Vector line = new Vector();

                    line.add(resultSet.getString("idClient"));
                    line.add(resultSet.getString("nomClient"));
                    line.add(resultSet.getString("adresseClient"));
                    line.add(resultSet.getString("telClient"));
                    line.add(resultSet.getString("contactClient"));

                    myVector2D.add(line);
                
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }

        return myVector2D;
    }
    
    public Client getUnClient(int idCli){
        Client client=new Client();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM Client Where idClient="+idCli+";");
            while(result.next()){
                client.setAdresse_client(result.getString("adresseClient"));
                client.setId_client(result.getInt("idClient"));
                client.setNom_client(result.getString("nomClient"));
                client.setNom_contact(result.getString("contactClient"));
                client.setTelephone_client(result.getInt("telClient"));   
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return client;
    }
}
