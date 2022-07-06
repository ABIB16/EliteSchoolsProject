package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.dto.InscriptionDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.*;

import dz.ecole.eliteSchools.gestionEcole.mapper.EleveMapper;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.InscriptionRepository;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.EleveService;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/cours-de-soutien")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private InscriptionRepository inscriptionRepo;

    @Autowired
    private EleveMapper eleveMapper;

    public EleveController() {
    }

    private EleveDto convertEntityToDto(Inscription inscription) {
        EleveDto eleve = new EleveDto();
        eleve.setIdeleve(inscription.getEleve().getIdeleve());
        eleve.setMatricule(inscription.getMatricule());
        eleve.setCycleleve(inscription.getCycleleve().getCode());
        eleve.setStatut(inscription.getEleve().getStatut());
        eleve.setNomeleve(inscription.getEleve().getNomeleve());
        eleve.setPrenomeleve(inscription.getEleve().getPrenomeleve());
        eleve.setNomarabe(inscription.getEleve().getNomarabe());
        eleve.setPrenomarabe(inscription.getEleve().getPrenomarabe());
        eleve.setDatenaissance(inscription.getEleve().getDatenaissance());
        eleve.setLieunaiss(inscription.getEleve().getLieunaiss());
        eleve.setPhoto(inscription.getEleve().getPhoto());
        return eleve;
    }


    @GetMapping("/listEleves")
    public Page<EleveDto> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return inscriptionService.findByEleveannee(true, paging).map(this::convertEntityToDto);
    }

    @GetMapping("/listElevesPreinscrit")
    public Page<EleveDto> findAllElevePreinscrit(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return inscriptionService.findByElvPreselectionne(true, paging).map(this::convertEntityToDto);
    }

    @GetMapping("/listAncienEleves")
    public Page<EleveDto> findAncienEleve(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return inscriptionService.listAncienEleve(false,paging);
    }


   /* @GetMapping("/listEleves")
    public List<InscriptionDto> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable paging = PageRequest.of(page, size);
        return eleveMapper.modelToDto(inscriptionService.findByEleveannee(true,paging));
    }*/

    @PostMapping("/addEleve")
    public Eleve createEleve(@RequestBody Eleve eleve,  @RequestParam CycleScolaire cycle) {
        eleveService.addEleve(eleve, cycle);
        return eleve;
    }

    @PutMapping("/updateEleve/{cycle}")
    public Eleve updateEleve(@RequestBody Eleve eleve, @PathVariable CycleScolaire cycle) {
        eleveService.updateEleve(eleve, cycle);
        return eleve;
    }

    @PutMapping("/updateEleveMaj/{cycle}")
    public Eleve updateEleveMaj(@RequestBody Eleve eleve, @PathVariable CycleScolaire cycle) {
        eleveService.editEleveMAJ(eleve, cycle);
        return eleve;
    }

    @PutMapping("/updateCell")
    public InscriptionMatiere updateMatiereInscription(@RequestBody InscriptionMatiere inscriptionMatiere) {
        eleveService.onCellEdit(inscriptionMatiere);
        return inscriptionMatiere;
    }

    @PostMapping("/addListMatiere")
    public List<InscriptionMatiere> addListMatiere( @RequestBody List<InscriptionMatiere> listMatiere) {
        eleveService.addNiveauScolaireCreation(listMatiere);
        return null;
    }

    @PutMapping("/editNiveau")
    public List<InscriptionMatiere> updateListMatiere(@RequestBody List<InscriptionMatiere> listMatiere,
                                                @RequestParam Eleve eleve) {
        eleveService.editNiveauScolaire(eleve,listMatiere);
        return null;
    }

    //add mapping for Get / employe/{id}
    @GetMapping("/editEleve")
    public EleveDto editEleve(@RequestParam int id) {
        Inscription eleve = inscriptionRepo.findByEleveAndAnnee(id);

        if (eleve == null) {
            throw new RuntimeException("eleve not found -" + id);
        }
        return eleveMapper.modelToDto(eleve);
    }

    @GetMapping("/editEleveMaj")
    public EleveDto editEleveMaj(@RequestParam int id) {
        Eleve eleve = eleveService.findById(id);

        if (eleve == null) {
            throw new RuntimeException("eleve not found -" + id);
        }
        return eleveMapper.eleveToEleveDto(eleve);
    }

    // add maping fo post / add new employe
    @PostMapping("/livres")
    public Eleve addLivre(@RequestBody Eleve livre) {
        eleveService.addEleve(livre, null);
        return livre;
    }

    // add mapping for put / update employe
    @PutMapping("/livres")
    public Eleve updateLivre(@RequestBody Eleve eleve) {
        eleveService.addEleve(eleve, null);
        return eleve;
    }

    // add mapping for delete employe
    @DeleteMapping("/livres/{id}")
    public String DeleteLivre(@PathVariable int id) {
        Eleve eleve = eleveService.findById(id);
        if (eleve == null) {
            throw new RuntimeException("livre not found " + id);
        }
        eleveService.deleteById(id);
        return "Delete livre " + id;
    }


}
