package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "wilaya")
//@Proxy(lazy = false)
public class Wilaya  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_wilaya")
    private String codeWilaya;
    @Column(name = "nom_wilaya")
    private String nomWilaya;
    @OneToMany( mappedBy = "codeWil")
   // @JsonIgnore
    private List<Commune> communeList;


    public Wilaya() {
    }

    public Wilaya(String codeWilaya) {
        this.codeWilaya = codeWilaya;
    }

    public String getCodeWilaya() {
        // System.out.println("(entity wil "+codeWilaya);
        return codeWilaya;
    }

    public void setCodeWilaya(String codeWilaya) {
        this.codeWilaya = codeWilaya;
    }

    public String getNomWilaya() {
        return nomWilaya;
    }

    public void setNomWilaya(String nomWilaya) {
        this.nomWilaya = nomWilaya;
    }

    @XmlTransient
    public List<Commune> getCommuneList() {
        if (communeList == null) {
            communeList = new ArrayList<>();
        }
        return communeList;
    }

    public void setCommuneList(List<Commune> communeList) {
        this.communeList = communeList;
    }

//    public List<Eleve> getEleveList() {
//        return eleveList;
//    }
//
//    public void setEleveList(List<Eleve> eleveList) {
//        this.eleveList = eleveList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeWilaya != null ? codeWilaya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wilaya)) {
            return false;
        }
        Wilaya other = (Wilaya) object;
        if ((this.codeWilaya == null && other.codeWilaya != null) || (this.codeWilaya != null && !this.codeWilaya.equals(other.codeWilaya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Wilaya[ codeWilaya=" + codeWilaya + " ]";
    }

}
