package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.ListePresenceDto;
import dz.ecole.eliteSchools.gestionEcole.dto.PaiementDto;
import dz.ecole.eliteSchools.gestionEcole.dto.PaiementParMatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.ListePresence;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Paiement;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.PaiementParMatiere;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper
@Mapper(componentModel = "spring")
public interface ListePresenceMapper {

    ListePresenceMapper INSTANCE = Mappers.getMapper(ListePresenceMapper.class);


    List<ListePresenceDto> listPresenceDto(List<ListePresence> presence);
    ListePresenceDto presenceToPresenceDto (ListePresence presence);


}
