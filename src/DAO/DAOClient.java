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
/**
 * 
 * @param client 
 * 
 * Permet l'insertion du client, passé en paramètre, dans la base de données
 */
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
/**
 * 
 * @param client
 * @return Vector<Vector>
 * 
 * le client contient obligatoirement un id ou un nom ou les 2.
 * retourne un vecteur contenant d'autre vecteur qui lui même 
 * contient les attributs d'un bean client
 * 
 */
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
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `idClient`=" 
                        + recepNUCLI + " AND `nomClient`like '%" + client.getNom_client() + "%';");
            }
            
            //requete executé si uniquement le champ numéro client est entré
            else if (client.getNom_client().isEmpty() && client.getId_client()!=0) {
                recepNUCLI = Integer.parseInt(String.valueOf(client.getId_client()));
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `idClient`=" 
                        + recepNUCLI + ";");
            }
            //requete executé si uniquement le champ nom client est entré
            else if (!client.getNom_client().isEmpty() && client.getId_client()==0) {
                resultSet = statement.executeQuery("SELECT * FROM Client WHERE `nomClient`like '%" 
                        + client.getNom_client() + "%';");
            }

            while (resultSet.next()) {
                    Vector line = new Vector();
                    
                    // ici insertion des éléments retournée par la requete
                    line.add(resultSet.getString("idClient"));
                    line.add(resultSet.getString("nomClient"));
                    line.add(resultSet.getString("adresseClient"));
                    line.add(resultSet.getString("telClient"));
                    line.add(resultSet.getString("contactClient"));

                    //insertion du Vector line dans le Vector2D
                    myVector2D.add(line);
                
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }

        return myVector2D;
    }
    
    /**
     * 
     * @param idCli
     * @return Client
     * 
     * Recherche des informations détaillé d'un client sur la base de données.
     * un client à un id unique. Il va donc nous permettre de le retrouver facilement
     */
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
