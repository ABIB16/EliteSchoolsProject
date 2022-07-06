/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.ecole.eliteSchools.gestionEcole.entity.langues;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Eleve;
import org.hibernate.annotations.Proxy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Billel
 */
@Entity
@Table(name = "document")
@Proxy(lazy = false)
public class Document  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_doc")
    private String idDoc;
    @Column(name = "nom_doc")
    private String nomDoc;
    @JoinColumn(name = "elv_doc", referencedColumnName = "ideleve")
    @ManyToOne(fetch = FetchType.LAZY)
    private Eleve elvDoc;
    @Column(name = "docum")
    private String docum;

    public Document() {
    }

    public Document(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getNomDoc() {
        return nomDoc;
    }

    public void setNomDoc(String nomDoc) {
        this.nomDoc = nomDoc;
    }

   /* public Etudiant getEtudDoc() {
        return etudDoc;
    }

    public void setEtudDoc(Etudiant etudDoc) {
        this.etudDoc = etudDoc;
    }

    public ElevePrive getElvPriveDoc() {
        return elvPriveDoc;
    }

    public void setElvPriveDoc(ElevePrive elvPriveDoc) {
        this.elvPriveDoc = elvPriveDoc;
    }*/

    public Eleve getElvDoc() {
        return elvDoc;
    }

    public void setElvDoc(Eleve elvDoc) {
        this.elvDoc = elvDoc;
    }

    public String getDocum() {
        return docum;
    }

    public void setDocum(String docum) {
        this.docum = docum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.ecole.eliteSchools.gestionEcole.entity.langues.Document[ idDoc=" + idDoc + " ]";
    }

}
