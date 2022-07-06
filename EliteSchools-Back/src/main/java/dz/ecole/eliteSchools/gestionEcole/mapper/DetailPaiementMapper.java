package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.DetailPaiementDto;
import dz.ecole.eliteSchools.gestionEcole.dto.PaiementDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Detailpaiement;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Paiement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

//@Mapper
@Mapper(componentModel = "spring")
public interface DetailPaiementMapper {

    DetailPaiementMapper INSTANCE = Mappers.getMapper(DetailPaiementMapper.class);

   // @Mapping(source = "idpaiement.idpaiement", target = "idPaiement")
    //@Mapping(source = "nivsclr.idmatiere.matiere", target = "matiere")
   // @Mapping(source = "nivsclr.cycleniv.code", target = "nivsclr")
    DetailPaiementDto convert(Detailpaiement paiement);




}
