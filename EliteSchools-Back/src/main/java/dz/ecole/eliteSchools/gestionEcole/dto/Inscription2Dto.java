package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

@Data
public class Inscription2Dto {
    private String idInscription;
    private String matricule;
    private IdEleveDto eleve;
    private CycleDto cycleleve;
    private AnneeScolaireDto idanne;
}
