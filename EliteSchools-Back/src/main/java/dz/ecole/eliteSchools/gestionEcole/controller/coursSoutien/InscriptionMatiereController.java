package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.*;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.*;
import dz.ecole.eliteSchools.gestionEcole.mapper.EleveMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.InscriptionMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.InscriptionMatiereMapper;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.InscriptionMatiereService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.InscriptionService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/cours-de-soutien")

public class InscriptionMatiereController {

    @Autowired
    private InscriptionMatiereService inscriptionMatiereService;
    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private InscriptionMatiereMapper inscriptionMatiereMapper;
    @Autowired
    private InscriptionMapper inscriptionMapper;

    public InscriptionMatiereController() {
    }

    // return list of matieres by Id eleve
    @GetMapping("/eleve/matieres")
    public List<InscriptionMatiereDto> findAllByIdMatiere(@RequestParam(name = "id") int id) {
        return inscriptionMatiereMapper.inscriptionMatiereToInscriptionMatiereDto(inscriptionMatiereService.findAllMatiereByeleve((id)));
    }

    @GetMapping("/eleve/inscription")
    public Inscription2Dto findInscriptionByEleve(@RequestParam(name = "id") int id) {
        return  inscriptionMapper.modelToDto(inscriptionService.findByEleveAndannee(id));
    }





}
