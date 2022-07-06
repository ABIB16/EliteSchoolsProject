package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.istack.NotNull;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "ecole")
public class Ecole {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idecole")
    private int idecole;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomecole")
    private String nomecole;

    public Ecole() {
    }

    public Ecole(Integer idEcole) {
        this.idecole = idEcole;
    }

    public Integer getIdEcole() {
        return idecole;
    }

    public void setIdEcole(Integer idEcole) {
        this.idecole = idEcole;
    }

    public String getNomecole() {
        return nomecole;
    }

    public void setNomecole(String nomecole) {
        this.nomecole = nomecole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomecole != null ? nomecole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecole)) {
            return false;
        }
        Ecole other = (Ecole) object;
        if ((this.nomecole == null && other.nomecole != null) || (this.nomecole != null && !this.nomecole.equals(other.nomecole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ecole[ nomecole=" + nomecole + " ]";
    }


}
