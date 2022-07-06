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
@Table(name = "historique_modification")
public class HistoriqueModification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_modif")
    private String idModif;
    @Column(name = "date_modif")
    @Temporal(TemporalType.DATE)
    private Date dateModif;
    @Column(name = "montant_modif")
    private Integer montantModif;
    @Size(max = 214)
    @Column(name = "modifier_par")
    private String modifierPar;
    @JoinColumn(name = "matiere_modif", referencedColumnName = "id_paye_par_mat")
    @ManyToOne(fetch = FetchType.LAZY)
    private PaiementParMatiere matiereModif;

    public HistoriqueModification() {
    }

    public HistoriqueModification(String idModif) {
        this.idModif = idModif;
    }

    public String getIdModif() {
        return idModif;
    }

    public void setIdModif(String idModif) {
        this.idModif = idModif;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public Integer getMontantModif() {
        return montantModif;
    }

    public void setMontantModif(Integer montantModif) {
        this.montantModif = montantModif;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public PaiementParMatiere getMatiereModif() {
        return matiereModif;
    }

    public void setMatiereModif(PaiementParMatiere matiereModif) {
        this.matiereModif = matiereModif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModif != null ? idModif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriqueModification)) {
            return false;
        }
        HistoriqueModification other = (HistoriqueModification) object;
        if ((this.idModif == null && other.idModif != null) || (this.idModif != null && !this.idModif.equals(other.idModif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "s.HistoriqueModification[ idModif=" + idModif + " ]";
    }
}

