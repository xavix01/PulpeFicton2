package DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

    private static final String FILE_PROPERTIES = "connection.properties";  //fichier qui contient les informations de connexion
    private static final String PROPERTY_URL = "url";           //
    private static final String PROPERTY_USERNAME = "user";     //
    private static final String PROPERTY_PASSWORD = "pwd";      //
    private static final String PROPERTY_DRIVER = "driver";     //
    private String driver;
    private String url;
    private String username;
    private String password;
    private MysqlDataSource mds;

    public DAOFactory() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(FILE_PROPERTIES)); // ouvre le fichier properties
            driver = properties.getProperty(PROPERTY_DRIVER);       //récupère le driver,
            url = properties.getProperty(PROPERTY_URL);             //l'url de la Bdd
            username = properties.getProperty(PROPERTY_USERNAME);   //l'utilisateur
            password = properties.getProperty(PROPERTY_PASSWORD);   //le mot de passe
            
            // s'il ne trouve rien une exeption est crée
        } catch (IOException e) {
            throw new DAOConfigException("Unable to load properties file " + FILE_PROPERTIES, e);
        }

        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
        }
        try {
            mds = new MysqlDataSource();
            mds.setUrl(url);
            mds.setUser(username);
            mds.setPassword(password);
        } catch (Exception e) {
        }

    }

    public Connection getConnection() throws SQLException {
        return mds.getConnection();
    }

    public DAOClient getDAOClient() {
        return new DAOClient(this);
    }
    public DAOProjet getDAOProjet() {
      return new DAOProjet(this);
    }
    
    public DAOEtudiant getDAOEtudiant() {
      return new DAOEtudiant(this);
    }
    
    public DAOParticipe getDAOParticipe() {
      return new DAOParticipe(this);
    }
}