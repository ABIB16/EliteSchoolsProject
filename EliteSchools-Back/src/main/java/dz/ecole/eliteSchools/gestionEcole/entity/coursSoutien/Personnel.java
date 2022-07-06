package dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personnel")
public class Personnel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonnel")
    private Integer idpersonnel;
    @Column(name = "nompersn")
    private String nompersn;
    @Column(name = "prenompersn")
    private String prenompersn;
    @Column(name = "tel")
    private String tel;
    @Column(name = "profession")
    private String profession;
    @Column(name = "datenaissper")
    @Temporal(TemporalType.DATE)
    private Date datenaissper;
    @Column(name = "matricule_personnel")
    private String matriculePersonnel;
//    @Lob
//    @Column(name = "photo_personnel")
//    private byte[] photoPersonnel;

    public Personnel() {
    }

    public Personnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public Integer getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public String getNompersn() {
        return nompersn;
    }

    public void setNompersn(String nompersn) {
        this.nompersn = nompersn.toUpperCase();
    }

    public String getPrenompersn() {
        return prenompersn;
    }

    public void setPrenompersn(String prenompersn) {
        this.prenompersn = prenompersn.substring(0, 1).toUpperCase() + prenompersn.substring(1).toLowerCase();;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getDatenaissper() {
        return datenaissper;
    }

    public void setDatenaissper(Date datenaissper) {
        this.datenaissper = datenaissper;
    }

//    public byte[] getPhotoPersonnel() {
//        return photoPersonnel;
//    }
//
//    public void setPhotoPersonnel(byte[] photoPersonnel) {
//        this.photoPersonnel = photoPersonnel;
//    }

    public String getMatriculePersonnel() {
        return matriculePersonnel;
    }

    public void setMatriculePersonnel(String matriculePersonnel) {
        this.matriculePersonnel = matriculePersonnel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonnel != null ? idpersonnel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idpersonnel == null && other.idpersonnel != null) || (this.idpersonnel != null && !this.idpersonnel.equals(other.idpersonnel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Personnel[ idpersonnel=" + idpersonnel + " ]";
    }

}
