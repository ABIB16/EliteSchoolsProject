package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetailPaiementDto {
    private String idDetail;
    private Date datepaimnt;
    private Integer mntverser;
    private String ecolesaisie;
    private String code;
    private String typePaiement;
    private NiveauDto nivsclr;
    private String matiere;
    private PaiementDto idpaiement;

}
