package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

@Data
public class ListePresenceDto {
    private String idPresence;
    private Boolean seance1;
    private Boolean seance2;
    private Boolean seance3;
    private Boolean seance4;
    private Boolean seance5;
    private Integer jour1;
    private Integer jour2;
    private Integer jour3;
    private Integer jour4;
    private Integer jour5;
    private Integer nbrPresence;
    private Number payeProf;
    private PaiementParMatiereDto idPayeParMat;

}
