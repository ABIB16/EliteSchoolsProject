package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.MatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.MatiereRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.MatiereService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    public MatiereController() {
    }

    private MatiereDto convertEntityToDto(Matiere m) {
        MatiereDto mat = new MatiereDto();
        mat.setIdmatiere(m.getIdmatiere());
        mat.setMatiere(m.getMatiere());
        return mat;
    }

    // return list of employe
    @GetMapping("/matieres")
    public List<MatiereDto> findAll() {
        return matiereService.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

    }

    //add mapping for Get / employe/{id}
    @GetMapping("/matieres/{id}")
    public Matiere getMatiere(@PathVariable int id) {
        Matiere matiere = matiereService.findById(id);
        if (matiere == null) {
            throw new RuntimeException("matiere not found -" + id);
        }
        return matiere;
    }

    // add maping fo post / add new employe
    @PostMapping("/matieres")
    public Matiere addMatiere(@RequestBody Matiere matiere) {
        matiereService.save(matiere);

        return matiere;
    }

    // update employe
    @PutMapping("/matieres/{id}")
    public Matiere updateMatiere(@RequestBody Matiere matiere) {
        matiereService.save(matiere);
        return matiere;
    }

    //  delete employe
    @DeleteMapping("/matieres/{id}")
    public void deleteLivre(@PathVariable int id) {
        matiereService.deleteById(id);
    }

}
