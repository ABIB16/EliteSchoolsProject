package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inscription_matiere")
public class InscriptionMatiere {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_inscription_matiere")
    private String idInscriptionMatiere;
    @Size(max = 20)
    @Column(name = "adm")
    private String adm;
    @JoinColumn(name = "idnivscolaire", referencedColumnName = "idnivscolaire"/*, insertable = false, updatable = false*/)
    @ManyToOne(fetch = FetchType.LAZY)
  //  @JsonBackReference
    private Niveauscolaire niveauscolaire;
    @Column(name = "nom_prof")
    private String nomProf;
    @Column(name = "groupe")
    private String groupe;
    @Column(name = "remise")
    private Integer remise;
    @Column(name = "remise_personnel")
    private String remisePersonnel;
    @Column(name = "remise_prof")
    private String remiseProf;
//    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Eleve ideleve;
//    @JoinColumn(name = "idanne", referencedColumnName = "idanne")
//    @ManyToOne(fetch = FetchType.LAZY)
//   // @JsonBackReference
//    private Anneescolaire idanne;
    @JoinColumn(name = "inscription", referencedColumnName = "id_inscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription inscription;

    public InscriptionMatiere() {
    }

    public String getIdInscriptionMatiere() {
        return idInscriptionMatiere;
    }

    public void setIdInscriptionMatiere(String idInscriptionMatiere) {
        this.idInscriptionMatiere = idInscriptionMatiere;
    }

    public Niveauscolaire getNiveauscolaire() {
        if (niveauscolaire == null) {
            niveauscolaire = new Niveauscolaire();
        }
        return niveauscolaire;
    }

    public void setNiveauscolaire(Niveauscolaire niveauscolaire) {
        this.niveauscolaire = niveauscolaire;
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

    //    public Eleve getIdeleve() {
//        return ideleve;
//    }
//
//    public void setIdeleve(Eleve ideleve) {
//        this.ideleve = ideleve;
//    }
//
//    public Anneescolaire getIdanne() {
//        return idanne;
//    }
//
//    public void setIdanne(Anneescolaire idanne) {
//        this.idanne = idanne;
//    }


    public String getAdm() {
        if (adm == null) {
            adm = "";
        }
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public Integer getRemise() {
        return remise;
    }

    public void setRemise(Integer remise) {
        this.remise = remise;
    }

    public String getRemisePersonnel() {
        return remisePersonnel;
    }

    public void setRemisePersonnel(String remisePersonnel) {
        this.remisePersonnel = remisePersonnel;
    }

    public String getRemiseProf() {
        return remiseProf;
    }

    public void setRemiseProf(String remiseProf) {
        this.remiseProf = remiseProf;
    }
}
