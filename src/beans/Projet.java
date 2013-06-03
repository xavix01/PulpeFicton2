/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Vector;

/**
 *
 * @author xavix
 */
public class Projet {

    private int id_projet;
    private int id_convention;
    private String nom_projet;
    private int duree_projet;
    private String date_fin_projet;
    private int prix_journee;
    private Etudiant responsable;
    private int idEtudiantResponsable;
    private Client client;
    private boolean equipe;
    Vector listeEtudiantIdNom;

    public Vector getListeEtudiantIdNom() {
        return listeEtudiantIdNom;
    }

    public void setListeEtudiantIdNom(Vector listeEtudiantIdNom) {
        this.listeEtudiantIdNom = listeEtudiantIdNom;
    }

    public int getIdEtudiantResponsable() {
        return idEtudiantResponsable;
    }

    public void setIdEtudiantResponsable(int idEtudiantResponsable) {
        this.idEtudiantResponsable = idEtudiantResponsable;
    }

    
    
    public Projet(){
        equipe=false;
    }
    
    public boolean getEquipe() {
        return equipe;
    }

    public void setEquipe(boolean equipe) {
        this.equipe = equipe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Etudiant getResponsable() {
        return responsable;
    }

    public void setResponsable(Etudiant responsable) {
        this.responsable = responsable;
    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public int getId_convention() {
        return id_convention;
    }

    public void setId_convention(int id_convention) {
        this.id_convention = id_convention;
    }

    public String getNom_projet() {
        return nom_projet;
    }

    public void setNom_projet(String nom_projet) {
        this.nom_projet = nom_projet;
    }

    public int getDuree_projet() {
        return duree_projet;
    }

    public void setDuree_projet(int duree_projet) {
        this.duree_projet = duree_projet;
    }

    public String getDate_fin_projet() {
        return date_fin_projet;
    }

    public void setDate_fin_projet(String date_fin_projet) {
        this.date_fin_projet = date_fin_projet;
    }

    public int getPrix_journee() {
        return prix_journee;
    }

    public void setPrix_journee(int prix_journee) {
        this.prix_journee = prix_journee;
    }
}
