package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.PaiementDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Paiement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper
@Mapper(componentModel = "spring")
public interface PaiementMapper {

    PaiementMapper INSTANCE = Mappers.getMapper(PaiementMapper.class);

//    @Mapping(source = "inscription.eleve.ideleve", target = "ideleve")
//    @Mapping(source = "inscription.eleve.nomeleve", target = "nomeleve")
//    @Mapping(source = "inscription.eleve.prenomeleve", target = "prenomeleve")
//    @Mapping(source = "inscription.cycleleve.code", target = "cycleleve")
//    @Mapping(source = "inscription.matricule", target = "matricule")
    PaiementDto convert(Paiement paiement);


}
