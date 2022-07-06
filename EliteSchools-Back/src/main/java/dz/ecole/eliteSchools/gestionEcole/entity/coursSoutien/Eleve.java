/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dz.ecole.eliteSchools.gestionEcole.entity.langues.Document;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Billel
 */
@Entity
@Table(name = "eleve")
//@Proxy(lazy = false)
public class Eleve {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleve", unique = true, nullable = false)
    private Integer ideleve;
    @Column(name = "nomeleve")
    private String nomeleve;
    @Column(name = "nomarabe")
    private String nomarabe;
    @Column(name = "prenomeleve")
    private String prenomeleve;
    @Column(name = "prenomarabe")
    private String prenomarabe;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Column(name = "modifierpar")
    private String modifierpar;
    @Column(name = "modifierle")
    @Temporal(TemporalType.DATE)
    private Date modifierle;
    @Column(name = "creerpar")
    private String creerpar;
    @Column(name = "creerle")
    @Temporal(TemporalType.DATE)
    private Date creerle;
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tel1")
    private String tel1;
    @Column(name = "de1")
    private String de1;
    @Column(name = "tel2")
    private String tel2;
    @Column(name = "de2")
    private String de2;
    @Column(name = "tel3")
    private String tel3;
    @Column(name = "de3")
    private String de3;
    @Column(name = "remarques")
    private String remarques;
    @Column(name = "photo")
    private String photo;
    @Column(name = "seriebac")
    private String seriebac;
    @Column(name = "seriebem")
    private String seriebem;
    @Column(name = "motif")
    private String motif;
    @Column(name = "etat")
    private String etat;
    @Column(name = "mail")
    private String mail;
    @Column(name = "statut")
    private String statut;

    @JoinColumn(name = "wilaya", referencedColumnName = "code_wilaya")
    @ManyToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    private Wilaya wilaya;

    @JoinColumn(name = "commune", referencedColumnName = "code_commune")
    @ManyToOne(fetch = FetchType.LAZY)
    //  @JsonIgnore
    private Commune commune;

    @Column(name = "ecole")
    private String ecole;

    @OneToMany(mappedBy = "elvDoc", fetch = FetchType.LAZY)
    // @JsonIgnore
    private List<Document> documentList;

//    @OneToMany(mappedBy = "ideleve", fetch = FetchType.LAZY)
//    private List<InscriptionMatiere> inscriptionMatiereList;


    public Eleve() {
    }

    public Eleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public String getNomeleve() {
        return nomeleve;
    }

    public void setNomeleve(String nomeleve) {
        this.nomeleve = nomeleve.toUpperCase();
    }

    public String getNomarabe() {
        return nomarabe;
    }

    public void setNomarabe(String nomarabe) {
        this.nomarabe = nomarabe;
    }

    public String getPrenomeleve() {
        return prenomeleve;
    }

    public void setPrenomeleve(String prenomeleve) {
        this.prenomeleve = prenomeleve.substring(0, 1).toUpperCase() + prenomeleve.substring(1).toLowerCase();
    }

    public String getPrenomarabe() {
        return prenomarabe;
    }

    public void setPrenomarabe(String prenomarabe) {
        this.prenomarabe = prenomarabe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getModifierpar() {
        return modifierpar;
    }

    public void setModifierpar(String modifierpar) {
        this.modifierpar = modifierpar;
    }

    public Date getModifierle() {
        return modifierle;
    }

    public void setModifierle(Date modifierle) {
        this.modifierle = modifierle;
    }

    public String getCreerpar() {
        return creerpar;
    }

    public void setCreerpar(String creerpar) {
        this.creerpar = creerpar;
    }

    public Date getCreerle() {
        return creerle;
    }

    public void setCreerle(Date creerle) {
        this.creerle = creerle;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSeriebac() {
        return seriebac;
    }

    public void setSeriebac(String seriebac) {
        this.seriebac = seriebac;
    }

    public String getSeriebem() {
        return seriebem;
    }

    public void setSeriebem(String seriebem) {
        this.seriebem = seriebem;
    }

    public Wilaya getWilaya() {
        if (wilaya == null) {
            wilaya = new Wilaya();
        }
        return wilaya;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    public Commune getCommune() {
        if (commune == null) {
            commune = new Commune();
        }
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getDe1() {
        return de1;
    }

    public void setDe1(String de1) {
        this.de1 = de1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getDe2() {
        return de2;
    }

    public void setDe2(String de2) {
        this.de2 = de2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getDe3() {
        return de3;
    }

    public void setDe3(String de3) {
        this.de3 = de3;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public String getSerieBac() {
        return seriebac;
    }

    public void setSerieBac(String seriebac) {
        this.seriebac = seriebac;
    }

    public String getSerieBem() {
        return seriebem;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail.toLowerCase();
    }

    public void setSerieBem(String serieBem) {
        this.seriebem = serieBem;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

//    public List<InscriptionMatiere> getInscriptionMatiereList() {
//        return inscriptionMatiereList;
//    }
//
//    public void setInscriptionMatiereList(List<InscriptionMatiere> inscriptionMatiereList) {
//        this.inscriptionMatiereList = inscriptionMatiereList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideleve != null ? ideleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.ideleve == null && other.ideleve != null) || (this.ideleve != null && !this.ideleve.equals(other.ideleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Eleve[ ideleve=" + ideleve + " ]";
    }

}
