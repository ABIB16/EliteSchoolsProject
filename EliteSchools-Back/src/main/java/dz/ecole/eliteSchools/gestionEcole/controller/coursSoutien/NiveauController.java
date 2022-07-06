package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.CycleDto;
import dz.ecole.eliteSchools.gestionEcole.dto.MatiereDto;
import dz.ecole.eliteSchools.gestionEcole.dto.NiveauDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.mapper.EleveMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.NiveauScolaireMapper;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class NiveauController {

    @Autowired
private NiveauService niveauService;

    @Autowired
    private NiveauScolaireMapper niveauScolaireMapper;



    public NiveauController() {

    }

    // return list of niveaux
    @GetMapping("/niveaux")
    public List<NiveauDto> findAll() {
       // return niveauService.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return niveauScolaireMapper.modelToDto(niveauService.findAll());

    }

    // return list of niveaux by Id Matiere
    @GetMapping("/niveaux/matiere")
    public List<NiveauDto> findAllByIdMatiere(@RequestParam(name = "id") int id) {
      //  return niveauService.findAllByIdMatiere(id).stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return niveauScolaireMapper.modelToDto(niveauService.findAllByIdMatiere(id));
    }

    //add mapping for Get / niveaux/{id}
    @GetMapping("/niveaux/{id}")
    public Niveauscolaire getNiveau(@PathVariable int id){
        Niveauscolaire niv = niveauService.findById(id);
        if(niv == null){
            throw new RuntimeException("niveau not found -"+id);
        }
        return niv;
    }





}
