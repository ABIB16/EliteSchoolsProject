package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionDto;
import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMatiereMapper {

    InscriptionMatiereMapper INSTANCE = Mappers.getMapper(InscriptionMatiereMapper.class);

  //  @Mapping(source = "ideleve.ideleve", target = "ideleve")
    List<InscriptionMatiereDto> inscriptionMatiereToInscriptionMatiereDto(List<InscriptionMatiere> elv);


}
