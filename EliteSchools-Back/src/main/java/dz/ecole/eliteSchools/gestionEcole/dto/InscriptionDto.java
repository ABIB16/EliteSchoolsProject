package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

@Data
public class InscriptionDto {
    private String matricule;
    private EleveDto eleve;
    private CycleDto cycleleve;
}
