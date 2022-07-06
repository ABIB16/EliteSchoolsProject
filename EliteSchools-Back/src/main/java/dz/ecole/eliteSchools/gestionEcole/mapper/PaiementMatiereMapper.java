package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.dto.PaiementParMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.PaiementParMatiere;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaiementMatiereMapper {

    PaiementMatiereMapper INSTANCE = Mappers.getMapper(PaiementMatiereMapper.class);

    List<PaiementParMatiereDto> paiementMatiereToPaiementMatiereDto(List<PaiementParMatiere> paie);
    PaiementParMatiereDto paiementMatiereToPaiementMatiereDto (PaiementParMatiere paie);
}
