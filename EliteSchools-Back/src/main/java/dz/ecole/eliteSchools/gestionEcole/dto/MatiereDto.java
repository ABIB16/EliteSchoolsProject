package dz.ecole.eliteSchools.gestionEcole.dto;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import lombok.Data;

import java.util.List;

@Data
public class MatiereDto {
    private Number idmatiere;
    private String matiere;
  //  private List<Niveauscolaire> niveauscolaireList;
}
