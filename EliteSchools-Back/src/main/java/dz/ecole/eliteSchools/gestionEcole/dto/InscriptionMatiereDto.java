package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

@Data
public class InscriptionMatiereDto {
    private String idInscriptionMatiere;
    private Number remise;
    private String nomProf;
    private String groupe;
    private NiveauDto niveauscolaire;
//    private AnneeScolaireDto idanne;
//    private IdEleveDto ideleve;
    private Inscription2Dto inscription;
    private String remisePersonnel;
    private String remiseProf;
}
