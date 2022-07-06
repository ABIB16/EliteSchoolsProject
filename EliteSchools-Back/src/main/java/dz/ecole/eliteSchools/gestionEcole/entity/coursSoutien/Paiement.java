package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paiement")
public class Paiement {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpaiement")
    private String idpaiement;
    @Column(name = "moispaiement")
    private String moispaiement;
    @Column(name = "total")
    private Integer total;
    @Column(name = "verser")
    private Integer verser;
    @Column(name = "reste")
    private Integer reste;
    @JoinColumn(name = "inscription", referencedColumnName = "id_inscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription inscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaiement")
    private List<Detailpaiement> detailpaiementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numpaiement")
    private List<PaiementParMatiere> paiementParMatiereList;

    public Paiement() {
    }

    public Paiement(String idpaiement) {
        this.idpaiement = idpaiement;
    }

    public String getMoispaiement() {
        return moispaiement;
    }

    public void setMoispaiement(String moispaiement) {
        this.moispaiement = moispaiement;
    }

    public String getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(String idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public Inscription getInscription() {
        if (inscription == null) {
            inscription = new Inscription();
        }
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public List<Detailpaiement> getDetailpaiementList() {
        return detailpaiementList;
    }

    public void setDetailpaiementList(List<Detailpaiement> detailpaiementList) {
        this.detailpaiementList = detailpaiementList;
    }

    public List<PaiementParMatiere> getPaiementParMatiereList() {
        return paiementParMatiereList;
    }

    public void setPaiementParMatiereList(List<PaiementParMatiere> paiementParMatiereList) {
        this.paiementParMatiereList = paiementParMatiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paiement[ idpaiement=" + idpaiement + " ]";
    }

}
