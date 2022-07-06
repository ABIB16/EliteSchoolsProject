package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Billel
 */
@Entity
@Table(name = "cycle_scolaire")
@Proxy(lazy = false)
public class CycleScolaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "cycle_sclr")
    private String cycleSclr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code")
    private String code;
    @Column(name = "ordre")
    private Integer ordre;
    @Column(name = "typee")
    private String typee;
    @Column(name = "prix")
    private Integer prix;
    @OneToMany(mappedBy = "cycleniv", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Niveauscolaire> niveauscolaireList;
   /* @JoinColumn(name = "frais", referencedColumnName = "id_frais")
    @ManyToOne(fetch = FetchType.LAZY)
    private FraisInscriptionPrive frais;*/

    public CycleScolaire() {
    }

    public CycleScolaire(String code) {
        this.code = code;
    }

    public String getCycleSclr() {
        return cycleSclr;
    }

    public void setCycleSclr(String cycleSclr) {
        this.cycleSclr = cycleSclr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public String getTypee() {
        return typee;
    }

    public void setTypee(String typee) {
        this.typee = typee;
    }

    public List<Niveauscolaire> getNiveauscolaireList() {
        return niveauscolaireList;
    }

    public void setNiveauscolaireList(List<Niveauscolaire> niveauscolaireList) {
        this.niveauscolaireList = niveauscolaireList;
    }

   /* public FraisInscriptionPrive getFrais() {
        if (frais == null) {
            frais = new FraisInscriptionPrive();
        }
        return frais;
    }

    public void setFrais(FraisInscriptionPrive frais) {
        this.frais = frais;
    }*/

    public Integer getPrix() {
        if (prix == null) {
            prix = 0;
        }
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CycleScolaire)) {
            return false;
        }
        CycleScolaire other = (CycleScolaire) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CycleScolaire[ code=" + code + " ]";
    }

}
