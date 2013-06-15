/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author xavix
 */
public class Client {

    private int idClient;
    private String nomClient;
    private String adresseClient;
    private int telephoneClient;
    private String nomContact;

    public int getId_client() {
        return idClient;
    }

    public void setId_client(int idClient) {
        this.idClient = idClient;
    }

    public String getNom_client() {
        return nomClient;
    }

    public void setNom_client(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresse_client() {
        return adresseClient;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresseClient = adresse_client;
    }

    public int getTelephone_client() {
        return telephoneClient;
    }

    public void setTelephone_client(int telephone_client) {
        this.telephoneClient = telephone_client;
    }

    public String getNom_contact() {
        return nomContact;
    }

    public void setNom_contact(String nom_contact) {
        this.nomContact = nom_contact;
    }
}
