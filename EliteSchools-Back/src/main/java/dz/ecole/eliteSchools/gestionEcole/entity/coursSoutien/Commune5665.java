/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.sun.istack.NotNull;

import javax.persistence.*;


/**
 *
 * @author Billel
 */
@Entity
@Table(name = "commune")
//@Proxy(lazy = false)
public class Commune5665 {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_commune")
    private String codeCommune;
    @Column(name = "nom_commune")
    private String nomCommune;
    @Column(name = "code_postal_commune")
    private String codePostalCommune;
    @JoinColumn(name = "code_wil", referencedColumnName = "code_wilaya")
    @ManyToOne(fetch = FetchType.LAZY)
   // @JsonIgnore
    private Wilaya codeWil;


    public Commune5665() {
    }

    public Commune5665(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getCodePostalCommune() {
        return codePostalCommune;
    }

    public void setCodePostalCommune(String codePostalCommune) {
        this.codePostalCommune = codePostalCommune;
    }

    public Wilaya getCodeWil() {
        if(codeWil==null)
            codeWil = new Wilaya();
        return codeWil;
    }

    public void setCodeWil(Wilaya codeWil) {
        this.codeWil = codeWil;
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
        hash += (codeCommune != null ? codeCommune.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commune5665)) {
            return false;
        }
        Commune5665 other = (Commune5665) object;
        if ((this.codeCommune == null && other.codeCommune != null) || (this.codeCommune != null && !this.codeCommune.equals(other.codeCommune))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commune[ codeCommune=" + codeCommune + " ]";
    }

}
