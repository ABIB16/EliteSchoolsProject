package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.CycleDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Ecole;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.CycleService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class EcoleController {

    @Autowired
    private EcoleService ecoleService;

    public EcoleController() {

    }


    // return list of niveaux
    @GetMapping("/ecoles")
    public List<Ecole> findAll() {
        return ecoleService.findAll();
    }

}
