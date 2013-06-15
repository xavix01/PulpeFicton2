/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Projet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author xavix
 */
public class DAOParticipe {

    private DAOFactory factory;

    public DAOParticipe(DAOFactory factory) {
        this.factory = factory;
    }
/**
 * Insert les étudiants qui participe à ce projet
 * @param projet 
 * 
 */
    public void addParticipe(Projet projet) {
        try {

            int idP = projet.getId_projet();
            int idE = 0;
            int nbreJour = 0;
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            Vector v = new Vector();
            Iterator it2;
            Iterator it1 = projet.getListeEtudiantIdNom().iterator();

            while (it1.hasNext()) {

                v = (Vector) it1.next();
                idE = (int) v.get(0);
                nbreJour = (int) v.get(2);

                String requete = "INSERT INTO `Participe` (`idProjet`, `idEtudiant`,`nombreJour`) VALUES (" + idP + ", " + idE + "," + nbreJour + ");";
                statement.executeUpdate(requete);

            }

            /* Fermeture des ressources */

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
    }
/**
 * Retourne une liste d'etudiant qui participe à un projet passé en paramètre
 * @param projet
 *  @return Vector<Vector>
 */
    public Vector equipeProjet(Projet projet) {
        Vector vector2D = new Vector();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Participe where idProjet=" + projet.getId_projet() + ";");

            while (resultSet.next()) {
                Vector vector1D = new Vector();
                vector1D.add(resultSet.getInt("idEtudiant"));
                vector1D.add(resultSet.getInt("idProjet"));
                vector1D.add(resultSet.getInt("nombreJour"));
                vector2D.add(vector1D);
            }
        } catch (Exception e) {
        }
        return vector2D;
    }
/**
 * Met à jour pour le projet passé en paramètre, le nombre de jour affecté à un Etudiant
 * @param nombre
 * @param idetu
 * @param projet 
 */
    public void setNombreHeureEtudiantParProjet(int nombre, int idetu, Projet projet) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Etudiant set `nombreJour`=" + nombre + ", where idEtudiant=" + idetu + ", and idProjet=" + projet.getId_projet() + ";");
        } catch (Exception e) {
        }
    }
}
