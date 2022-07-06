package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "niveauscolaire")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Niveauscolaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivscolaire")
    private Integer idnivscolaire;
    @Column(name = "prix")
    private Integer prix;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "niveauscolaire")
    private List<InscriptionMatiere> inscriptionPaimentList;*/
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveauscolaire")
    private List<PaiementParMatiere> paiementParMatiereList;*/
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Matiere idmatiere;
   /* @OneToMany(mappedBy = "nivsclr")
    private List<Detailpaiement> detailpaiementList;*/
  /*  @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveauscolaire")
    private List<ProfMatGrp> profMatGrpList;*/
    @JoinColumn(name = "cycleniv", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private CycleScolaire cycleniv;
    @Column(name = "type_niv")
    private String typeNiv;

    public Niveauscolaire() {
    }

    public Niveauscolaire(Integer idnivscolaire) {
        this.idnivscolaire = idnivscolaire;
    }

    public Integer getIdnivscolaire() {
        return idnivscolaire;
    }

    public void setIdnivscolaire(Integer idnivscolaire) {
        this.idnivscolaire = idnivscolaire;
    }

    public String getTypeNiv() {
        return typeNiv;
    }

    public void setTypeNiv(String typeNiv) {
        this.typeNiv = typeNiv;
    }

    public CycleScolaire getCycleniv() {
        if (cycleniv == null) {
            cycleniv = new CycleScolaire();
        }
        return cycleniv;
    }

    public void setCycleniv(CycleScolaire cycleniv) {
        this.cycleniv = cycleniv;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Matiere getIdmatiere() {
        if (idmatiere == null) {
            idmatiere = new Matiere();
        }
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

   /* public List<InscriptionMatiere> getInscriptionPaimentList() {
        return inscriptionPaimentList;
    }

    public void setInscriptionPaimentList(List<InscriptionMatiere> inscriptionPaimentList) {
        this.inscriptionPaimentList = inscriptionPaimentList;
    }

    public List<PaiementParMatiere> getPaiementParMatiereList() {
        return paiementParMatiereList;
    }

    public void setPaiementParMatiereList(List<PaiementParMatiere> paiementParMatiereList) {
        this.paiementParMatiereList = paiementParMatiereList;
    }

    public List<Detailpaiement> getDetailpaiementList() {
        return detailpaiementList;
    }

    public void setDetailpaiementList(List<Detailpaiement> detailpaiementList) {
        this.detailpaiementList = detailpaiementList;
    }

    public List<ProfMatGrp> getProfMatGrpList() {
        return profMatGrpList;
    }

    public void setProfMatGrpList(List<ProfMatGrp> profMatGrpList) {
        this.profMatGrpList = profMatGrpList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivscolaire != null ? idnivscolaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveauscolaire)) {
            return false;
        }
        Niveauscolaire other = (Niveauscolaire) object;
        if ((this.idnivscolaire == null && other.idnivscolaire != null) || (this.idnivscolaire != null && !this.idnivscolaire.equals(other.idnivscolaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.entity.Niveauscolaire[ idnivscolaire=" + idnivscolaire + " ]";
    }

}
