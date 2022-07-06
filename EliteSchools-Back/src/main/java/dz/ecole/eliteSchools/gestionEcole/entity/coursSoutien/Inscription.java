package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Billel
 */
@Entity
@Table(name = "inscription")
public class Inscription {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_inscription")
    private String idInscription;
    @Size(max = 254)
    @Column(name = "matricule")
    private String matricule;
    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve"/*, insertable = false, updatable = false*/)
    @ManyToOne(fetch = FetchType.LAZY)
    private Eleve eleve;
    @JoinColumn(name = "idanne", referencedColumnName = "idanne"/*, insertable = false, updatable = false*/)
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanne;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "inscription")
    private List<Paiement> paiementList;*/
    @JoinColumn(name = "cycleleve", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private CycleScolaire cycleleve;
    @OneToMany(mappedBy = "inscription", fetch = FetchType.LAZY)
    private List<InscriptionMatiere> inscriptionMatiereList;


    public Inscription() {

    }

    public String getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(String idInscription) {
        this.idInscription = idInscription;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Eleve getEleve() {
        if (eleve == null) {
            eleve = new Eleve();
        }
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Anneescolaire getIdanne() {
        return idanne;
    }

    public void setIdanne(Anneescolaire idanne) {
        this.idanne = idanne;
    }

    public CycleScolaire getCycleleve() {
        if (cycleleve == null) {
            cycleleve = new CycleScolaire();
        }
        return cycleleve;
    }

    public void setCycleleve(CycleScolaire cycleleve) {
        this.cycleleve = cycleleve;
    }

 /*  @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }*/

    public List<InscriptionMatiere> getInscriptionMatiereList() {
        if (inscriptionMatiereList == null) {
            inscriptionMatiereList = new ArrayList<>();
        }
        return inscriptionMatiereList;
    }

    public void setInscriptionMatiereList(List<InscriptionMatiere> inscriptionMatiereList) {
        this.inscriptionMatiereList = inscriptionMatiereList;
    }


}

