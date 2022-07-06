package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.MatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Personnel;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.MatiereService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    public PersonnelController() {
    }

    // return list of personnels
    @GetMapping("/personnels")
    public List<Personnel> findAll() {
        return personnelService.findAll();
    }

}
