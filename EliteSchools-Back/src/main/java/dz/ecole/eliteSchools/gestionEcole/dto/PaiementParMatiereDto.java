package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

@Data
public class PaiementParMatiereDto {
    private String idPayeParMat;
    private Integer remise;
    private Integer netpayer;
    private Integer verser;
    private Integer reste;
    private Integer taux;
    private Integer nbrSeance;
   // private String mois;
    private NiveauDto niveauscolaire;
    private PaiementDto numpaiement;

}
