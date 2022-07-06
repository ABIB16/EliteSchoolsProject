package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "groupe")
public class Groupe {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomgroupe")
    private String nomgroupe;
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "ecole")
    private String ecole;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupe")
//    private List<ProfMatGrp> profMatGrpList;

    public Groupe() {
    }

    public Groupe(String nomgroupe) {
        this.nomgroupe = nomgroupe;
    }

    public String getNomgroupe() {
        return nomgroupe;
    }

    public void setNomgroupe(String nomgroupe) {
        this.nomgroupe = nomgroupe;
    }

//    public List<ProfMatGrp> getProfMatGrpList() {
//        return profMatGrpList;
//    }
//
//    public void setProfMatGrpList(List<ProfMatGrp> profMatGrpList) {
//        this.profMatGrpList = profMatGrpList;
//    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomgroupe != null ? nomgroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.nomgroupe == null && other.nomgroupe != null) || (this.nomgroupe != null && !this.nomgroupe.equals(other.nomgroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Groupe[ nomgroupe=" + nomgroupe + " ]";
    }
}
