package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "detailpaiement")
public class Detailpaiement {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull

    @Column(name = "id_detail")
    private String idDetail;
    @Column(name = "datepaimnt")
    @Temporal(TemporalType.DATE)
    private Date datepaimnt;
    @Column(name = "mntverser")
    private Integer mntverser;
    @Column(name = "ecolesaisie")
    private String ecolesaisie;
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "idpaiement", referencedColumnName = "idpaiement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paiement idpaiement;
    @JoinColumn(name = "nivsclr", referencedColumnName = "idnivscolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Niveauscolaire nivsclr;
    @Column(name = "type_paiement")
    private String typePaiement;

    public Detailpaiement() {
    }

    public Detailpaiement(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public Date getDatepaimnt() {
        return datepaimnt;
    }

    public void setDatepaimnt(Date datepaimnt) {
        this.datepaimnt = datepaimnt;
    }

    public Integer getMntverser() {
        return mntverser;
    }

    public void setMntverser(Integer mntverser) {
        this.mntverser = mntverser;
    }

    public String getEcolesaisie() {
        return ecolesaisie;
    }

    public void setEcolesaisie(String ecolesaisie) {
        this.ecolesaisie = ecolesaisie;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Paiement getIdpaiement() {
        if (idpaiement == null) {
            idpaiement = new Paiement();
        }
        return idpaiement;
    }

    public void setIdpaiement(Paiement idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Niveauscolaire getNivsclr() {
        if (nivsclr == null) {
            nivsclr = new Niveauscolaire();
        }
        return nivsclr;
    }

    public void setNivsclr(Niveauscolaire nivsclr) {
        this.nivsclr = nivsclr;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetail != null ? idDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailpaiement)) {
            return false;
        }
        Detailpaiement other = (Detailpaiement) object;
        if ((this.idDetail == null && other.idDetail != null) || (this.idDetail != null && !this.idDetail.equals(other.idDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Detailpaiement[ idDetail=" + idDetail + " ]";
    }
}
