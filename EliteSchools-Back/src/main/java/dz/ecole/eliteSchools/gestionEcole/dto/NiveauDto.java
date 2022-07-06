package dz.ecole.eliteSchools.gestionEcole.dto;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import lombok.Data;

@Data
public class NiveauDto {
    private Number idnivscolaire;
    private Number prix;
    private MatiereDto idmatiere;
    private CycleDto cycleniv;

}
