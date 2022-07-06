package dz.ecole.eliteSchools.gestionEcole.dto;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Detailpaiement;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;


@Data
public class PaiementDto {
    private String idpaiement;
    private String moispaiement;
    private Integer total;
    private Integer verser;
    private Integer reste;
    private Inscription2Dto inscription;
   /* private Integer ideleve;
    private String nomeleve;
    private String prenomeleve;
    private String cycleleve;
    private String matricule;*/
  //  private List<DetailpaiementDto> detailpaiementList;

}
