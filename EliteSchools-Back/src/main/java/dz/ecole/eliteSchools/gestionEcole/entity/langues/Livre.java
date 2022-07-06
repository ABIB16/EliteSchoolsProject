package dz.ecole.eliteSchools.gestionEcole.entity.langues;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "livre")
public class Livre  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_livre")
    private Integer idLivre;
    @Column(name = "nom_livre")
    private String nomLivre;
    @Column(name = "type_livre")
    private String typeLivre;
    @Column(name = "prix_livre")
    private Integer prixLivre;

    public Livre() {
    }

    public Livre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public Integer getPrixLivre() {
        return prixLivre;
    }

    public void setPrixLivre(Integer prixLivre) {
        this.prixLivre = prixLivre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivre != null ? idLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.idLivre == null && other.idLivre != null) || (this.idLivre != null && !this.idLivre.equals(other.idLivre))) {
            return false;
        }
        return true;
    }

    public String getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(String typeLivre) {
        this.typeLivre = typeLivre;
    }

    @Override
    public String toString() {
        return "entity.Livre[ idLivre=" + idLivre + " ]";
    }

}

