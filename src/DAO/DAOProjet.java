/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Client;
import beans.Etudiant;
import beans.Projet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class DAOProjet {

    private DAOFactory factory;

    public DAOProjet(DAOFactory factory) {
        this.factory = factory;
    }

    /**
     * Insertion d'un nouveau projet dans la bdd
     *
     * @param projet
     * @param client
     */
    public void addProjet(Projet projet, Client client) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `Projet` (`idClient`, `nomProjet`, `dureeProjet`, `dateFinProjet`,`prixJournee`) VALUES\n"
                    + "(" + client.getId_client() + ", '" + projet.getNom_projet() + "', " + projet.getDuree_projet() + ", '" + projet.getDate_fin_projet() + "'," + projet.getPrix_journee() + ");");
            /* Fermeture des ressources */

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
    }

    /**
     * recherche d'un projet l'aide de son id(sans la liste d'etudiant concerné)
     *
     * @param projet
     */
    public void getProjetParId(Projet projet) {
        try {
            Client client = new Client();
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            int idClient = 0;
            ResultSet result = statement.executeQuery("SELECT * FROM Projet where idProjet= " + projet.getId_projet());
            while (result.next()) {
                projet.setDuree_projet(result.getInt("dureeProjet"));
                projet.setDate_fin_projet(result.getString("dateFinProjet"));
                projet.setNom_projet(result.getString("nomProjet"));
                projet.setPrix_journee(result.getInt("prixJournee"));
                idClient = result.getInt("idClient");
            }
            client.setId_client(idClient);
            projet.setClient(client);
        } catch (Exception e) {
        }
    }

    /**
     * recherche des informations complete sur un projet(y compris la liste
     * d'etudiant affecté)
     *
     * @param projet
     */
    public void getProjetCompletPourConv(Projet projet) {
        Vector listeEtudiant = new Vector<>();
        try {
            Client client = new Client();
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            int idClient = 0;
            ResultSet result = statement.executeQuery("SELECT * FROM Projet where idProjet= " + projet.getId_projet());
            while (result.next()) {
                projet.setDuree_projet(result.getInt("dureeProjet"));
                projet.setDate_fin_projet(result.getString("dateFinProjet"));
                projet.setIdEtudiantResponsable(result.getInt("idEtudiantResponsable"));
                projet.setId_convention(result.getInt("idConvention"));
                projet.setNom_projet(result.getString("nomProjet"));
                projet.setPrix_journee(result.getInt("prixJournee"));
                idClient = result.getInt("idClient");
            }
            result = statement.executeQuery("SELECT * FROM Participe p join Etudiant e on p.idEtudiant=e.idEtudiant where idProjet=" + projet.getId_projet());
            while (result.next()) {
                listeEtudiant.addElement(result.getString("nomEtudiant"));
                listeEtudiant.addElement(result.getInt("nombreJour"));
            }
            projet.setListeEtudiantIdNom(listeEtudiant);
            result = statement.executeQuery("SELECT *  FROM Client where idClient=" + idClient);
            while (result.next()) {
                client.setId_client(idClient);
                client.setNom_client(result.getString("nomClient"));
                client.setAdresse_client(result.getString("adresseClient"));
                client.setTelephone_client(result.getInt("telClient"));
                client.setNom_contact(result.getString("contactClient"));
            }
            projet.setClient(client);

        } catch (Exception e) {
        }

    }

    /**
     * retourne le nom des projets qui conerne le client passé en paramètre.
     *
     * @param idClient
     * @return Vector
     */
    public Vector getProjetParClient(int idClient) {
        Vector vector = new Vector<>();
        try {

            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            String requete = "SELECT * FROM Projet where idClient=" + idClient + ";";
            System.out.println(requete);
            ResultSet result = statement.executeQuery(requete);
            while (result.next()) {
                vector.add(result.getString("nomProjet"));
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vector;
    }

    /**
     * retourne les informations complete pour la convention, des projets d'un
     * client passé en paramètre.
     *
     * @param client
     * @return Vector<Vector>
     *
     *
     *
     */
    public Vector getProjetClientConsultation(Client client) {
        Vector vector2D = new Vector<>();
        try {

            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            String requete = "SELECT * FROM Projet where idClient=" + client.getId_client() + ";";
            System.out.println(requete);
            ResultSet result = statement.executeQuery(requete);
            int coutTotal;
            int nombre_de_semaine;
            int cout_jounrnee;
            while (result.next()) {
                Vector vector1D = new Vector<>();
                vector1D.add(result.getInt("idProjet"));
                vector1D.add(result.getInt("idClient"));
                vector1D.add(result.getInt("idEtudiantResponsable"));
                vector1D.add(result.getInt("idConvention"));
                vector1D.add(result.getString("nomProjet"));

                nombre_de_semaine = result.getInt("dureeProjet");
                vector1D.add(nombre_de_semaine);

                vector1D.add(result.getString("dateFinProjet"));

                cout_jounrnee = result.getInt("prixJournee");
                vector1D.add(cout_jounrnee);

                coutTotal = 5 * nombre_de_semaine * cout_jounrnee;
                vector1D.add(coutTotal);

                vector2D.add(vector1D);
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vector2D;
    }

    /**
     * retourne les informations complete des projets d'un client passé en
     * paramètre.
     *
     * @param idClient
     * @return
     *
     *
     */
    public Vector getProjetParClient(String idClient) {
        Vector vector2D = new Vector<>();
        try {

            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            String requete = "SELECT * FROM Projet where idClient=" + idClient + ";";
            System.out.println(requete);
            ResultSet result = statement.executeQuery(requete);
            while (result.next()) {
                Vector vector1D = new Vector<>();
                vector1D.add(result.getInt("idProjet"));
                vector1D.add(result.getInt("idConvention"));
                vector1D.add(result.getString("nomProjet"));
                vector1D.add(result.getString("dateFinProjet"));
                vector1D.add(result.getInt("dureeProjet"));
                vector1D.add(result.getInt("prixJournee"));
                vector2D.add(vector1D);
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vector2D;
    }

    /**
     * retourne une liste de projet ayant été recherché a l'aide des caratère
     * entré par l'utilisateur
     *
     * @param projet
     * @return Vector<Vector>
     *
     *
     */
    public Vector getRechercheProjetParNom(Projet projet) {
        Vector vector2D = new Vector<>();
        try {

            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            String requete = "SELECT * FROM Projet where nomProjet like \"%" + projet.getNom_projet() + "%\"";
            System.out.println(requete);
            ResultSet result = statement.executeQuery(requete);
            while (result.next()) {
                Vector vector1D = new Vector<>();
                vector1D.add(result.getInt("idProjet"));
                vector1D.add(result.getString("nomProjet"));
                vector1D.add(result.getString("dateFinProjet"));
                vector1D.add(result.getInt("dureeProjet"));
                vector1D.add(result.getInt("prixJournee"));
                vector2D.add(vector1D);
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vector2D;
    }

    /**
     * ajoute l'id etudiant responsable dans la table projet
     *
     * @param projet
     */
    public void setResponsableProjet(Projet projet) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            int idP = projet.getId_projet();

            statement.executeUpdate("UPDATE `Projet` SET `idEtudiantResponsable`=" + projet.getIdEtudiantResponsable() + " WHERE `idProjet`=" + projet.getId_projet() + ";");
            /* Fermeture des ressources */

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
    }

    /**
     * ajoute le numero de convention dans la bdd pour le projet passé en
     * paramètre
     *
     * @param projet
     */
    public void setConvention(Projet projet) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();

            String idClient = String.valueOf(projet.getClient().getId_client());
            String idProjet = String.valueOf(projet.getId_projet());
            System.out.println(idProjet);
            System.out.println(idClient);
            String numConv = idClient + idProjet;
            Integer conv = (Integer.parseInt(numConv));

            statement.executeUpdate("UPDATE `Projet` set `idConvention`= " + conv + " where idProjet=" + projet.getId_projet() + ";");
            System.out.println(conv);

            projet.setId_convention(conv);
        } catch (Exception e) {
        }
    }

    /**
     * Recherche les informations d'un projet
     *
     * @param projet
     */
    public void infoProjet(Projet projet) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `Projet` where idProjet=" + projet.getId_projet() + ";");
            while (resultSet.next()) {
                projet.setDate_fin_projet(resultSet.getString("dateFinProjet"));
                projet.setDuree_projet(resultSet.getInt("dureeProjet"));
                projet.setNom_projet(resultSet.getString("nomProjet"));
                projet.setPrix_journee(resultSet.getInt("prixJournee"));
                projet.setIdEtudiantResponsable(resultSet.getInt("idEtudiantResponsable"));
            }
        } catch (Exception e) {
        }
    }

    /**
     * Recherche la liste de projet concernant l'etudiant passé en paramètre
     *
     * @param etudiant
     * @return Vector<Vector>
     */
    public Vector getProjetParEtudiant(Etudiant etudiant) {

        Vector vector2D = new Vector();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            String requete = "SELECT * FROM Participe pa join Projet po on pa.idProjet=po.idProjet join Etudiant et on pa.idEtudiant=et.idEtudiant where nomEtudiant ='" + etudiant.getNomEtudiant() + "' and idConvention!=0;";
            ResultSet resultSet = statement.executeQuery(requete);
            while (resultSet.next()) {
                Vector vector1D = new Vector();
                vector1D.add(String.valueOf(resultSet.getInt("idProjet")));
                vector1D.add(String.valueOf(resultSet.getString("nomProjet")));
                vector1D.add(String.valueOf(resultSet.getInt("idConvention")));
                vector2D.add(vector1D);
            }
        } catch (Exception e) {
        }
        return vector2D;
    }
}
