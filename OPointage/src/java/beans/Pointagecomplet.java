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

/**
 *
 * @author dell
 */
@Entity
public class Pointagecomplet {

    @Id
    @GeneratedValue
    private int id;
    private Date dateEntree;
    private Date dateSortie;
    @ManyToOne
    private Employe employe;

    public Pointagecomplet(Date dateEntree, Date dateSortie, Employe employe) {
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }


    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    
}
