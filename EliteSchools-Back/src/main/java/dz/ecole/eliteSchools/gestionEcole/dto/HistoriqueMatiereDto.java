package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

import java.util.Date;


@Data
public class HistoriqueMatiereDto {
    private Date dateModif;
    private Number montantModif;
    private String idPayeParMat;
    private String modifierPar;

}
