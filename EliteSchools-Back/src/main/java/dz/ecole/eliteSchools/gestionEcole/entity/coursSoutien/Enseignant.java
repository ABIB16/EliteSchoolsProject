package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenseignant")
    private Integer idenseignant;
    @Column(name = "nomenseignant")
    private String nomenseignant;
    @Column(name = "prenomensingant")
    private String prenomensingant;
    @Column(name = "tel")
    private String tel;
    @Column(name = "tel2")
    private String tel2;
    @Column(name = "profession")
    private String profession;
    @Column(name = "datenaissprof")
    @Temporal(TemporalType.DATE)
    private Date datenaissprof;
    @Column(name = "matricule_prof")
    private String matriculeProf;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignant")
//    private List<ProfMatGrp> profMatGrpList;
    @Column(name = "mail")
    private String mail;
    @Column(name = "photo")
    private String photo;
    @Column(name = "etat")
    private String etat;
    @Column(name = "type_prof")
    private String typeProf;

    public Enseignant() {
    }

    public Enseignant(Integer idenseignant, String nomenseignant, String prenomensingant, String profession,
                      String mail, String etat, String tel, String tel2) {
        this.idenseignant = idenseignant;
        this.nomenseignant = nomenseignant;
        this.prenomensingant = prenomensingant;
        this.profession = profession;
        this.mail = mail;
        this.etat = etat;
        this.tel = tel;
        this.tel2 = tel2;
    }

    public Enseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Integer getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
    }

    public String getNomenseignant() {
        return nomenseignant;
    }

    public void setNomenseignant(String nomenseignant) {
        this.nomenseignant = nomenseignant.toUpperCase();
    }

    public String getPrenomensingant() {
        return prenomensingant;
    }

    public void setPrenomensingant(String prenomensingant) {
        this.prenomensingant = prenomensingant.substring(0, 1).toUpperCase() + prenomensingant.substring(1).toLowerCase();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail.toLowerCase();
    }

    public Date getDatenaissprof() {
        return datenaissprof;
    }

    public void setDatenaissprof(Date datenaissprof) {
        this.datenaissprof = datenaissprof;
    }

//    public List<ProfMatGrp> getProfMatGrpList() {
//        if (profMatGrpList == null) {
//            profMatGrpList = new ArrayList<>();
//        }
//        return profMatGrpList;
//    }
//
//    public void setProfMatGrpList(List<ProfMatGrp> profMatGrpList) {
//        this.profMatGrpList = profMatGrpList;
//    }

    public String getMatriculeProf() {
        return matriculeProf;
    }

    public void setMatriculeProf(String matriculeProf) {
        this.matriculeProf = matriculeProf;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTypeProf() {
        return typeProf;
    }

    public void setTypeProf(String typeProf) {
        this.typeProf = typeProf;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenseignant != null ? idenseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idenseignant == null && other.idenseignant != null) || (this.idenseignant != null && !this.idenseignant.equals(other.idenseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.entity.Enseignant[ idenseignant=" + idenseignant + " ]";
    }
}
