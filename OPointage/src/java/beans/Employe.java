/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author dell
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String telephone;
    private String adresse;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEmbauche;
    private String email;
    private String password;
    private int nbrHeure;
    private int nbrMinute;
    private String image;
    @ManyToOne
    private Fonction fonction;
    @ManyToOne
    private Role role; 

    public Employe() {
    }

    public Employe(String nom, String prenom, String sexe, Date dateNaissance, String telephone, String adresse, Date dateEmbauche, String email, String password, Fonction fonction, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
        this.email = email;
        this.password = password;
        this.fonction = fonction;
        this.role = role;
    }

    public Employe(String nom, String prenom, String sexe, Date dateNaissance, String telephone, String adresse, Date dateEmbauche, String email, String password, String image, Fonction fonction, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
        this.email = email;
        this.password = password;
        this.image = image;
        this.fonction = fonction;
        this.role = role;
    }

    public Employe(String nom, String prenom, String sexe, Date dateNaissance, String telephone, String adresse, Date dateEmbauche, String email, String password, int nbrHeure, Fonction fonction, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
        this.email = email;
        this.password = password;
        this.nbrHeure = nbrHeure;
        this.fonction = fonction;
        this.role = role;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrMinute() {
        return nbrMinute;
    }

    public void setNbrMinute(int nbrMinute) {
        this.nbrMinute = nbrMinute;
    }
    

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getNbrHeure() {
        return nbrHeure;
    }

    public void setNbrHeure(int nbrHeure) {
        this.nbrHeure = nbrHeure;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
