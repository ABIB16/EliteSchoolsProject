package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "anneescolaire")
public class Anneescolairedgfdfg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idanne")
    private Integer idanne;
    @Size(max = 254)
    @Column(name = "anneescolaire")
    private String anneescolaire;
    @Size(max = 254)
    @Column(name = "concatenation")
    private String concatenation;
    @Column(name = "anneecourante")
    private Boolean anneecourante;

    public Anneescolairedgfdfg() {
    }

    public Anneescolairedgfdfg(Integer idanne) {
        this.idanne = idanne;
    }

    public Integer getIdanne() {
        return idanne;
    }

    public void setIdanne(Integer idanne) {
        this.idanne = idanne;
    }

    public String getAnneescolaire() {
        return anneescolaire;
    }

    public void setAnneescolaire(String anneescolaire) {
        this.anneescolaire = anneescolaire;
    }

    public String getConcatenation() {
        return concatenation;
    }

    public void setConcatenation(String concatenation) {
        this.concatenation = concatenation;
    }

    public Boolean getAnneecourante() {
        return anneecourante;
    }

    public void setAnneecourante(Boolean anneecourante) {
        this.anneecourante = anneecourante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanne != null ? idanne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anneescolairedgfdfg)) {
            return false;
        }
        Anneescolairedgfdfg other = (Anneescolairedgfdfg) object;
        if ((this.idanne == null && other.idanne != null) || (this.idanne != null && !this.idanne.equals(other.idanne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.entity.Anneescolaire[ idanne=" + idanne + " ]";
    }

}

