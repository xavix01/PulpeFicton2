/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author xavix
 */
public class Frais {
    
    private int idFrais;
    private int idRF;
    private int idProjet;
    private int idEtudiant;
    private String nomEtudiant;
    private int jour;
    private String Mois;
    private int Annee;
    private int montantDeplacement;
    private int montantSejour;
    private int montantAutres;

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public String getMois() {
        return Mois;
    }

    public void setMois(String Mois) {
        this.Mois = Mois;
    }

  
    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int Annee) {
        this.Annee = Annee;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }
    
    public int getIdFrais() {
        return idFrais;
    }

    public void setIdFrais(int idFrais) {
        this.idFrais = idFrais;
    }

    public int getIdRF() {
        return idRF;
    }

    public void setIdRF(int idRF) {
        this.idRF = idRF;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getMontantDeplacement() {
        return montantDeplacement;
    }

    public void setMontantDeplacement(int montantDeplacement) {
        this.montantDeplacement = montantDeplacement;
    }

    public int getMontantSejour() {
        return montantSejour;
    }

    public void setMontantSejour(int montantSejour) {
        this.montantSejour = montantSejour;
    }

    public int getMontantAutres() {
        return montantAutres;
    }

    public void setMontantAutres(int montantAutres) {
        this.montantAutres = montantAutres;
    }
    
    
}
