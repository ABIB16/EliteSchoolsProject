package dz.ecole.eliteSchools.gestionEcole.dto;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Data
public class EleveDto {
    private Number ideleve;
    private String matricule;
    private String nomeleve;
    private String nomarabe;
    private String prenomeleve;
    private String prenomarabe;
    private String statut;
    private String etat;
    private String sexe;
    private Date datenaissance;
    private String lieunaiss;
    private String adresse;
    private String tel1;
    private String de1;
    private String tel2;
    private String de2;
    private String de3;
    private String tel3;
    private String  remarques;
    private String  photo;
    private String  seriebac;
    private String  seriebem;
    private String  motif;
    private String  mail;
    private String  wilaya;
    private String  commune;
    private String ecole;
    private String cycleleve;
    private String creerpar;
    private Date creerle;
    private String modifierpar;
    private Date modifierle;
   // private List<InscriptionMatiereDto> inscriptionMatiereList;


    public EleveDto(Number ideleve, String nomeleve, String prenomeleve, String nomarabe, String prenomarabe, Date datenaissance, String lieunaiss) {
        this.ideleve = ideleve;
        this.nomeleve = nomeleve;
        this.prenomeleve = prenomeleve;
        this.nomarabe = nomarabe;
        this.prenomarabe = prenomarabe;
        this.datenaissance = datenaissance;
        this.lieunaiss = lieunaiss;
    }

    public EleveDto() {
    }
}
