package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.NiveauDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NiveauScolaireMapper {

    NiveauScolaireMapper INSTANCE = Mappers.getMapper(NiveauScolaireMapper.class);

     List<NiveauDto> modelToDto(List<Niveauscolaire> niveau);


}
