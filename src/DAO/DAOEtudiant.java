/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
public class DAOEtudiant {

    private DAOFactory factory;

    public DAOEtudiant(DAOFactory factory) {
        this.factory = factory;
    }

    public Vector getEtudiant() {
        Vector listeEtudiant = new Vector<>();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant");
            while (result.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setIdEtudiant(result.getInt("idEtudiant"));
                etudiant.setNomEtudiant(result.getString("nomEtudiant"));
                etudiant.setPrenomEtudiant(result.getString("prenomEtudiant"));
                etudiant.setDateNaissanceEtudiant(result.getString("dateNaissanceEtudiant"));
                etudiant.setAdresseEtudiant(result.getString("adresseEtudiant"));
                listeEtudiant.add(etudiant);
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return listeEtudiant;
    }
    public Etudiant getUnEtudiant(int idEtu){
        Etudiant etudiant=new Etudiant();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant where idEtudiant="+idEtu+";");
            while (result.next()) {
                etudiant.setIdEtudiant(result.getInt("idEtudiant"));
                etudiant.setNomEtudiant(result.getString("nomEtudiant"));
                etudiant.setPrenomEtudiant(result.getString("prenomEtudiant"));
                etudiant.setDateNaissanceEtudiant(result.getString("dateNaissanceEtudiant"));
                etudiant.setAdresseEtudiant(result.getString("adresseEtudiant"));
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return etudiant;
    }
    
    
    public Vector getVectorEtudiant() {
        Vector listeEtudiant2D = new Vector<>();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant");
            while (result.next()) {
                Vector listeEtudiant1D=new Vector();
                listeEtudiant1D.add(result.getInt("idEtudiant"));
                listeEtudiant1D.add(result.getString("nomEtudiant"));
                listeEtudiant2D.add(listeEtudiant1D);
            }
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return listeEtudiant2D;
    }
    
    public Vector getEtudiantProjet(Projet projet)
    {
        Vector vector2D=new Vector();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant e join Participe p on e.idEtudiant=p.idEtudiant where idProjet="+projet.getId_projet()+";");
            while (result.next()) {
                Vector vector1D = new Vector<>();
                vector1D.add(result.getInt("idEtudiant"));
                vector1D.add(result.getString("nomEtudiant"));
                vector1D.add(result.getString("prenomEtudiant"));
                vector1D.add(result.getString("dateNaissanceEtudiant"));
                vector1D.add(result.getString("adresseEtudiant"));
                
                vector2D.add(vector1D);
            }
            
        } catch (Exception e) {
        }
        return vector2D;
        
    }
    
}
