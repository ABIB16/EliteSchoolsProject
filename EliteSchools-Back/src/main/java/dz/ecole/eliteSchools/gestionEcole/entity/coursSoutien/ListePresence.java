package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "liste_presence")
public class ListePresence {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presence")
    private String idPresence;
    @Column(name = "seance1")
    private Boolean seance1;
    @Column(name = "jour1")
    private Integer jour1;
    @Column(name = "seance2")
    private Boolean seance2;
    @Column(name = "jour2")
    private Integer jour2;
    @Column(name = "seance3")
    private Boolean seance3;
    @Column(name = "jour3")
    private Integer jour3;
    @Column(name = "seance4")
    private Boolean seance4;
    @Column(name = "jour4")
    private Integer jour4;
    @Column(name = "seance5")
    private Boolean seance5;
    @Column(name = "jour5")
    private Integer jour5;
    @Column(name = "nbr_presence")
    private Integer nbrPresence;
    @Column(name = "paye_prof")
    private BigDecimal payeProf;
    @JoinColumn(name = "id_paye_par_mat", referencedColumnName = "id_paye_par_mat")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private PaiementParMatiere idPayeParMat;

    public ListePresence() {
    }

    public ListePresence(String idPresence) {
        this.idPresence = idPresence;
    }

    public String getIdPresence() {
        return idPresence;
    }

    public void setIdPresence(String idPresence) {
        this.idPresence = idPresence;
    }

    public Boolean getSeance1() {
        return seance1;
    }

    public void setSeance1(Boolean seance1) {
        this.seance1 = seance1;
    }

    public Integer getJour1() {
        return jour1;
    }

    public void setJour1(Integer jour1) {
        this.jour1 = jour1;
    }

    public Boolean getSeance2() {
        return seance2;
    }

    public void setSeance2(Boolean seance2) {
        this.seance2 = seance2;
    }

    public Integer getJour2() {
        return jour2;
    }

    public void setJour2(Integer jour2) {
        this.jour2 = jour2;
    }

    public Boolean getSeance3() {
        return seance3;
    }

    public void setSeance3(Boolean seance3) {
        this.seance3 = seance3;
    }

    public Integer getJour3() {
        return jour3;
    }

    public void setJour3(Integer jour3) {
        this.jour3 = jour3;
    }

    public Boolean getSeance4() {
        return seance4;
    }

    public void setSeance4(Boolean seance4) {
        this.seance4 = seance4;
    }

    public Integer getJour4() {
        return jour4;
    }

    public void setJour4(Integer jour4) {
        this.jour4 = jour4;
    }

    public Boolean getSeance5() {
        return seance5;
    }

    public void setSeance5(Boolean seance5) {
        this.seance5 = seance5;
    }

    public Integer getJour5() {
        return jour5;
    }

    public void setJour5(Integer jour5) {
        this.jour5 = jour5;
    }

    public Integer getNbrPresence() {
        return nbrPresence;
    }

    public void setNbrPresence(Integer nbrPresence) {
        this.nbrPresence = nbrPresence;
    }

    public BigDecimal getPayeProf() {
        return payeProf;
    }

    public void setPayeProf(BigDecimal payeProf) {
        this.payeProf = payeProf;
    }

    public PaiementParMatiere getIdPayeParMat() {
        return idPayeParMat;
    }

    public void setIdPayeParMat(PaiementParMatiere idPayeParMat) {
        this.idPayeParMat = idPayeParMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresence != null ? idPresence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListePresence)) {
            return false;
        }
        ListePresence other = (ListePresence) object;
        if ((this.idPresence == null && other.idPresence != null) || (this.idPresence != null && !this.idPresence.equals(other.idPresence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ListePresence[ idPresence=" + idPresence + " ]";
    }
}
