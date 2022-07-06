package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;/*


/**
 *
 * @author Billel
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatiere")
    private Integer idmatiere;
    @Column(name = "matiere")
    private String matiere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmatiere")
  //  @JsonManagedReference
    private List<Niveauscolaire> niveauscolaireList;

    public Matiere() {
    }

    public Matiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Integer getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    @XmlTransient
    public List<Niveauscolaire> getNiveauscolaireList() {
        if(niveauscolaireList==null){
            niveauscolaireList = new ArrayList<>();
        }
        return niveauscolaireList;
    }

    public void setNiveauscolaireList(List<Niveauscolaire> niveauscolaireList) {
        this.niveauscolaireList = niveauscolaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatiere != null ? idmatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idmatiere == null && other.idmatiere != null) || (this.idmatiere != null && !this.idmatiere.equals(other.idmatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.entity.Matiere[ idmatiere=" + idmatiere + " ]";
    }

    public void ajouterMat(Niveauscolaire niv) {
        niv.setIdmatiere(this);
        this.getNiveauscolaireList().add(niv);

    }

    public void ajouterNiveaux(List<Niveauscolaire> niveaux) {
        for (Niveauscolaire niv : niveaux) {
            this.ajouterMat(niv);
        }
    }
}
