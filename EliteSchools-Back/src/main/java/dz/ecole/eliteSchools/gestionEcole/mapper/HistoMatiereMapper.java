package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.dto.HistoriqueMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Eleve;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.HistoriqueModification;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper
@Mapper(componentModel = "spring")
public interface HistoMatiereMapper {

    HistoMatiereMapper INSTANCE = Mappers.getMapper(HistoMatiereMapper.class);

    @Mapping(source = "dateModif", target = "dateModif")
    @Mapping(source = "montantModif", target = "montantModif")
    @Mapping(source = "modifierPar", target = "modifierPar")
    @Mapping(source = "matiereModif.idPayeParMat", target = "idPayeParMat")
    HistoriqueMatiereDto modelToDto(HistoriqueModification historique);
    List<HistoriqueMatiereDto> listmodelToDto(List<HistoriqueModification> historique);

}
