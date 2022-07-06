package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paiement_par_matiere")
public class PaiementParMatiere {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paye_par_mat")
    private String idPayeParMat;
    @Column(name = "remise")
    private Integer remise;
    @Column(name = "netpayer")
    private Integer netpayer;
    @Column(name = "verser")
    private Integer verser;
    @Column(name = "reste")
    private Integer reste;
    @Column(name = "taux")
    private Integer taux;
    @Column(name = "nbr_seance")
    private Integer nbrSeance;
    @JoinColumn(name = "numpaiement", referencedColumnName = "idpaiement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paiement numpaiement;
    @JoinColumn(name = "idnivscolaire", referencedColumnName = "idnivscolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Niveauscolaire niveauscolaire;
    @OneToMany(mappedBy = "matiereModif", fetch = FetchType.LAZY)
    private List<HistoriqueModification> historiqueModificationList;

    public PaiementParMatiere() {
    }

    public PaiementParMatiere(String idPayeParMat) {
        this.idPayeParMat = idPayeParMat;
    }

    public Integer getRemise() {
        return remise;
    }

    public void setRemise(Integer remise) {
        this.remise = remise;
    }

    public Integer getNetpayer() {
        return netpayer;
    }

    public void setNetpayer(Integer netpayer) {
        this.netpayer = netpayer;
    }

    public Integer getVerser() {
        return verser;
    }

    public void setVerser(Integer verser) {
        this.verser = verser;
    }

    public Integer getReste() {
        return reste;
    }

    public void setReste(Integer reste) {
        this.reste = reste;
    }

    public Integer getNbrSeance() {
        return nbrSeance;
    }

    public void setNbrSeance(Integer nbrSeance) {
        this.nbrSeance = nbrSeance;
    }

    public Integer getTaux() {
        return taux;
    }

    public void setTaux(Integer taux) {
        this.taux = taux;
    }

    public String getIdPayeParMat() {
        return idPayeParMat;
    }

    public void setIdPayeParMat(String idPayeParMat) {
        this.idPayeParMat = idPayeParMat;
    }

    public Paiement getNumpaiement() {
        if (numpaiement == null) {
            numpaiement = new Paiement();
        }
        return numpaiement;
    }

    public void setNumpaiement(Paiement numpaiement) {
        this.numpaiement = numpaiement;
    }

    public Niveauscolaire getNiveauscolaire() {
        return niveauscolaire;
    }

    public void setNiveauscolaire(Niveauscolaire niveauscolaire) {
        this.niveauscolaire = niveauscolaire;
    }

    public List<HistoriqueModification> getHistoriqueModificationList() {
        return historiqueModificationList;
    }

    public void setHistoriqueModificationList(List<HistoriqueModification> historiqueModificationList) {
        this.historiqueModificationList = historiqueModificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayeParMat != null ? idPayeParMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiementParMatiere)) {
            return false;
        }
        PaiementParMatiere other = (PaiementParMatiere) object;
        if ((this.idPayeParMat == null && other.idPayeParMat != null) || (this.idPayeParMat != null && !this.idPayeParMat.equals(other.idPayeParMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaiementParMatiere[ idPayeParMat=" + idPayeParMat + " ]";
    }
}
