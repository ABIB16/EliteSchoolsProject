package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.MatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Groupe;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.GroupeService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.MatiereService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    public GroupeController() {
    }


    // return list of Groupe
    @GetMapping("/groupes")
    public List<Groupe> findAll() {
        return groupeService.findAll();
    }


}
