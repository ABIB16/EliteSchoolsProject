package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "jour")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Jour.findAll", query = "SELECT j FROM Jour j order by j.idJr"),
        @NamedQuery(name = "Jour.findByIdJr", query = "SELECT j FROM Jour j WHERE j.idJr = :idJr"),
        @NamedQuery(name = "Jour.findTypee", query = "SELECT j.jour FROM Jour j WHERE j.typee = :typee"),
        @NamedQuery(name = "Jour.findByTypee", query = "SELECT j FROM Jour j WHERE j.typee = :typee"),
        @NamedQuery(name = "Jour.findByJour", query = "SELECT j FROM Jour j WHERE j.jour <> :jour AND j.typee <> :typee order by j.idJr")})
public class Jour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jr")
    private Integer idJr;
    @Size(max = 10)
    @Column(name = "jour")
    private String jour;
    @Column(name = "typee")
    private Integer typee;

    public Jour() {
    }

    public Jour(Integer idJr) {
        this.idJr = idJr;
    }

    public Integer getIdJr() {
        return idJr;
    }

    public void setIdJr(Integer idJr) {
        this.idJr = idJr;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Integer getTypee() {
        return typee;
    }

    public void setTypee(Integer typee) {
        this.typee = typee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJr != null ? idJr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jour)) {
            return false;
        }
        Jour other = (Jour) object;
        if ((this.idJr == null && other.idJr != null) || (this.idJr != null && !this.idJr.equals(other.idJr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.entity.Jour[ idJr=" + idJr + " ]";
    }

}
