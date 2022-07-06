package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.HistoriqueMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.dto.Inscription2Dto;
import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.HistoriqueModification;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    InscriptionMapper INSTANCE = Mappers.getMapper(InscriptionMapper.class);

  Inscription2Dto modelToDto(Inscription inscription);

}
