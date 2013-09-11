/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Etudiant;
import beans.Frais;
import beans.Projet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
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

    /**
     * Recherche de tous les Etudiants (Infos détaillé sur cet étudiant) sur la
     * Bdd.
     *
     * @return Vector<Etudiant>
     *
     */
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
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return listeEtudiant;
    }

    /**
     * L'étudiant passé en paramètre contient uniquement l'idEtudiant. Recherche
     * dans la base des informations sur cet etudiant.
     *
     * @param etudiant
     *
     *
     */
    public void getUnEtudiant(Etudiant etudiant) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant where idEtudiant=" + etudiant.getIdEtudiant() + ";");
            while (result.next()) {
                etudiant.setIdEtudiant(result.getInt("idEtudiant"));
                etudiant.setNomEtudiant(result.getString("nomEtudiant"));
                etudiant.setPrenomEtudiant(result.getString("prenomEtudiant"));
                etudiant.setDateNaissanceEtudiant(result.getString("dateNaissanceEtudiant"));
                etudiant.setAdresseEtudiant(result.getString("adresseEtudiant"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
    }

    /**
     * Recupère seulement le nom et l'id de tout les étudiants.
     *
     * @return Vector<Vetor>
     *
     */
    public Vector getVectorEtudiant() {
        Vector listeEtudiant2D = new Vector<>();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant");
            while (result.next()) {
                Vector listeEtudiant1D = new Vector();
                listeEtudiant1D.add(result.getInt("idEtudiant"));
                listeEtudiant1D.add(result.getString("nomEtudiant"));
                listeEtudiant2D.add(listeEtudiant1D);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return listeEtudiant2D;
    }

    /**
     * Informations détaillées de tous les Etudiants d'un projet donné
     *
     * @param projet
     * @return Vector <Vector>
     *
     *
     */
    public Vector getEtudiantProjet(Projet projet) {
        Vector vector2D = new Vector();
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant e join Participe p on e.idEtudiant=p.idEtudiant where idProjet=" + projet.getId_projet() + ";");
            while (result.next()) {
                Vector vector1D = new Vector<>();
                vector1D.add(result.getInt("idEtudiant"));
                vector1D.add(result.getString("nomEtudiant"));
                vector1D.add(result.getString("prenomEtudiant"));
                vector1D.add(result.getString("dateNaissanceEtudiant"));
                vector1D.add(result.getString("adresseEtudiant"));

                vector2D.add(vector1D);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vector2D;

    }

    /**
     * Insertion de nouveau frais dans la table frais.
     *
     * @param frais
     */
    public void addFees(Frais frais) {
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Etudiant where nomEtudiant='" + frais.getNomEtudiant() + "'");
            result.next();
            int idEtu = result.getInt("idEtudiant");
            String insert = "INSERT INTO Frais (`idProjet`,`idEtudiant`,`jourFrais`,`moisFrais`,`anneeFrais`,`montantSejour`,`MontantDeplacement`,`montantAutres`)"
                    + "VALUES (" + frais.getIdProjet() + "," + idEtu + "," + frais.getJour() + ",'" + frais.getMois() + "'," + frais.getAnnee() + "," + frais.getMontantSejour()
                    + "," + frais.getMontantDeplacement() + "," + frais.getMontantAutres() + ")";
            statement.executeUpdate(insert);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }

    }

    /**
     *
     * La classe frais passé en paramètre contient uniquement le mois, l'année
     * et l'id de l'étudiant; Une liste de tous les frais pour cet etudiant
     * ayant ces date; une nouvelle fiche de remboursement est inséré.
     *
     * @param frais
     * @return Vector<Vector>
     *
     *
     */
    public Vector searchExpenses(Frais frais) {
        Vector vectorEtu = new Vector();
        Date udate = new Date();
        Locale locale = Locale.getDefault();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        try {
            Connection connection = factory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result;
            String insertFR = "INSERT INTO Remboursement (dateRemboursement2) values ('" + dateFormat.format(udate) + "')";
            statement.executeUpdate(insertFR, Statement.RETURN_GENERATED_KEYS);
            result = statement.getGeneratedKeys();
            result.next();
            int idFR = result.getInt(1);
            frais.setIdFrais(idFR);
            result = statement.executeQuery("SELECT * FROM Etudiant where nomEtudiant='" + frais.getNomEtudiant() + "'");
            result.next();
            int idEtu = result.getInt("idEtudiant");
            frais.setIdEtudiant(idEtu);

            String updateFrais = "UPDATE Frais set idRF= " + idFR + " where "
                    + "idEtudiant = " + idEtu + " and anneeFrais = " + frais.getAnnee() + " and "
                    + " moisFrais = '" + frais.getMois() + "'";
            statement.executeUpdate(updateFrais);

            String search = "Select * from Frais where idEtudiant = " + idEtu + " and "
                    + "anneeFrais = " + frais.getAnnee() + " and moisFrais = '" + frais.getMois() + "'";
            result = statement.executeQuery(search);
            while (result.next()) {
                Vector vector1D = new Vector();
                vector1D.add(result.getInt("idFrais"));
                vector1D.add(result.getInt("idRf"));
                vector1D.add(result.getInt("idProjet"));
                vector1D.add(result.getInt("idEtudiant"));
                vector1D.add(result.getInt("jourFrais"));
                vector1D.add(result.getString("moisFrais"));
                vector1D.add(result.getInt("anneeFrais"));
                vector1D.add(result.getInt("montantDeplacement"));
                vector1D.add(result.getInt("montantSejour"));
                vector1D.add(result.getInt("montantAutres"));
                vectorEtu.add(vector1D);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAO.DAOException(e.getSQLState());
        }
        return vectorEtu;
    }
}
