package dz.ecole.eliteSchools.gestionEcole.mapper;

import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Eleve;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

//@Mapper
@Mapper(componentModel = "spring")
public interface EleveMapper {

    EleveMapper INSTANCE = Mappers.getMapper(EleveMapper.class);

//    @Mapping(source = "cycleleve", target = "cycleleve")
//List<InscriptionDto> modelToDto(Page<Inscription> elv);




    @Mapping(source = "eleve.ideleve", target = "ideleve")
    @Mapping(source = "cycleleve.code", target = "cycleleve")
    @Mapping(source = "eleve.statut", target = "statut")
    @Mapping(source = "eleve.nomeleve", target = "nomeleve")
    @Mapping(source = "eleve.nomarabe", target = "nomarabe")
    @Mapping(source = "eleve.prenomeleve", target = "prenomeleve")
    @Mapping(source = "eleve.prenomarabe", target = "prenomarabe")
    @Mapping(source = "eleve.sexe", target = "sexe")
    @Mapping(source = "eleve.datenaissance", target = "datenaissance")
    @Mapping(source = "eleve.lieunaiss", target = "lieunaiss")
    @Mapping(source = "eleve.adresse", target = "adresse")
    @Mapping(source = "eleve.tel1", target = "tel1")
    @Mapping(source = "eleve.de1", target = "de1")
    @Mapping(source = "eleve.tel2", target = "tel2")
    @Mapping(source = "eleve.de2", target = "de2")
    @Mapping(source = "eleve.tel3", target = "tel3")
    @Mapping(source = "eleve.de3", target = "de3")
    @Mapping(source = "eleve.remarques", target = "remarques")
    @Mapping(source = "eleve.photo", target = "photo")
    @Mapping(source = "eleve.seriebac", target = "seriebac")
    @Mapping(source = "eleve.seriebem", target = "seriebem")
    @Mapping(source = "eleve.motif", target = "motif")
    @Mapping(source = "eleve.mail", target = "mail")
    @Mapping(source = "eleve.wilaya.codeWilaya", target = "wilaya")
    @Mapping(source = "eleve.commune.codeCommune", target = "commune")
    @Mapping(source = "eleve.ecole", target = "ecole")
    @Mapping(source = "eleve.etat", target = "etat")
    @Mapping(source = "eleve.creerpar", target = "creerpar")
    @Mapping(source = "eleve.creerle", target = "creerle")
    @Mapping(source = "eleve.modifierpar", target = "modifierpar")
    @Mapping(source = "eleve.modifierle", target = "modifierle")
    EleveDto modelToDto(Inscription inscription);

    @Mapping(source = "eleve.wilaya.codeWilaya", target = "wilaya")
    @Mapping(source = "eleve.commune.codeCommune", target = "commune")
    EleveDto eleveToEleveDto(Eleve eleve);
}
