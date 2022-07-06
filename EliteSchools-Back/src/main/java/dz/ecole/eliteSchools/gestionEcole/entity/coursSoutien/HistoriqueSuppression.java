package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "historique_suppression")
public class HistoriqueSuppression implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supp")
    private Integer idSupp;
    @Column(name = "matiere")
    private String matiere;
    @Column(name = "userr")
    private String userr;
    @Column(name = "eleve")
    private String eleve;
    @Column(name = "mois")
    private String mois;
    @Column(name = "date_supp")
    @Temporal(TemporalType.DATE)
    private Date dateSupp;
    @Column(name = "annee")
    private Integer annee;

    public HistoriqueSuppression() {
    }

    public Integer getIdSupp() {
        return idSupp;
    }

    public void setIdSupp(Integer idSupp) {
        this.idSupp = idSupp;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getUserr() {
        return userr;
    }

    public void setUserr(String userr) {
        this.userr = userr;
    }

    public String getEleve() {
        return eleve;
    }

    public void setEleve(String eleve) {
        this.eleve = eleve;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Date getDateSupp() {
        return dateSupp;
    }

    public void setDateSupp(Date dateSupp) {
        this.dateSupp = dateSupp;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
}

