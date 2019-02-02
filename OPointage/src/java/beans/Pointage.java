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
public class Pointage {
    @Id
    @GeneratedValue
    private int id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private String etat;
    @ManyToOne
    private Employe employe;
    private int nbrHeure;
    private int nbrMinute;

    public Pointage() {
    }

    public Pointage(Date date, String etat, Employe employe) {
        this.date = date;
        this.etat = etat;
        this.employe = employe;
    }

    public Pointage(Date date, String etat, Employe employe, int nbrHeure, int nbrMinute) {
        this.date = date;
        this.etat = etat;
        this.employe = employe;
        this.nbrHeure = nbrHeure;
        this.nbrMinute = nbrMinute;
    }

    public int getNbrHeure() {
        return nbrHeure;
    }

    public void setNbrHeure(int nbrHeure) {
        this.nbrHeure = nbrHeure;
    }

    public int getNbrMinute() {
        return nbrMinute;
    }

    public void setNbrMinute(int nbrMinute) {
        this.nbrMinute = nbrMinute;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    
}
