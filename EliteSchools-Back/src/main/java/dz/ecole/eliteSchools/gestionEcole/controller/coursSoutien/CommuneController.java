package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.CommuneDto;
import dz.ecole.eliteSchools.gestionEcole.dto.CycleDto;
import dz.ecole.eliteSchools.gestionEcole.dto.NiveauDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.CommuneService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class CommuneController {

    @Autowired
private CommuneService communeService;

    public CommuneController() {
    }

    private CommuneDto convertEntityToDto(Commune com){
        CommuneDto comDto = new CommuneDto();
        comDto.setCodeCommune(com.getCodeCommune());
        comDto.setNomCommune(com.getNomCommune());
        return comDto;
    }




    // return list of niveaux by Id Matiere
    @GetMapping("/wilayas/commune")
    public List<CommuneDto> findCommuneByCodeWilaya(@RequestParam(name = "code") String code) {
        return communeService.findAll(code).stream().map(this::convertEntityToDto).collect(Collectors.toList());

    }







}
