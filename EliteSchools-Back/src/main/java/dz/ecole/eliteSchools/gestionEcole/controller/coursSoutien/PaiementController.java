package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.*;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.*;
import dz.ecole.eliteSchools.gestionEcole.mapper.DetailPaiementMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.HistoMatiereMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.PaiementMapper;
import dz.ecole.eliteSchools.gestionEcole.mapper.PaiementMatiereMapper;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/cours-de-soutien")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;
    @Autowired
    private PaiementMatiereMapper paiementParMatiereMapper;
    @Autowired
    private PaiementMapper paiementMapper;
    @Autowired
    private HistoMatiereMapper histoMatiereMapper;
    @Autowired
    private DetailPaiementMapper detailPaiementMapper;

    public PaiementController() {
    }

    private PaiementDto convertEntityToDto(Paiement paiement) {
        return paiementMapper.convert(paiement);
    }

    private DetailPaiementDto convertEntityToDto(Detailpaiement detailPaiement) {
        return detailPaiementMapper.convert(detailPaiement);
    }


    @GetMapping("/listPaiement")
    public Page<PaiementDto> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return paiementService.findAll(paging).map(this::convertEntityToDto);
    }

    @PutMapping("/listAntecedent")
    public List<PaiementDto> findAll(Integer ideleve) {
        //  return paiementService.findAllAntecedent(12169).map(this::convertEntityToDto);
        return paiementService.findAllAntecedent(12169).stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("/listImpaye")
    public List<PaiementDto> findAll(String mois) {
        return paiementService.getImpayes(mois).stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @GetMapping("/genererPaiement")
    public Page<PaiementDto> genererPaiement(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Pageable paging = PageRequest.of(page, size);
        paiementService.genererPaye();
        return paiementService.findAll(paging).map(this::convertEntityToDto);
    }

    @GetMapping("/eleve/paiementMatiere")
    public List<PaiementParMatiereDto> findAllPaiementParMatiereByIdAndMois(@RequestParam(name = "id") int id, @RequestParam(name = "mois") String mois) {
        return paiementParMatiereMapper.paiementMatiereToPaiementMatiereDto(paiementService.findPaiementByMois(id, mois));
    }

    @GetMapping("/editPaiement")
    public PaiementDto editPaiement(@RequestParam String id) {
        Paiement paiement = paiementService.findById(id);
        if (paiement == null) {
            throw new RuntimeException("paiement not found -" + id);
        }
        return convertEntityToDto(paiement);
    }

    @PutMapping("/majPaiementMatiere")
    public PaiementParMatiere majPaiemetParMatiere(@RequestBody PaiementParMatiere paiementParMatiere,
                                                      @RequestParam(name = "mnt") int mnt, @RequestParam(name = "type") String type) {
        paiementService.editerRestePaiment(paiementParMatiere, mnt, type);
        return paiementParMatiere;
    }

    @PutMapping("/editPaiementMatiere")
    public PaiementParMatiere editPaiemetParMatiere(@RequestBody PaiementParMatiere paiementParMatiere) {
        paiementService.modifParMat(paiementParMatiere);
        return paiementParMatiere;
    }

    @PutMapping("/editHistoriqueMatiere")
    public Detailpaiement editHistoParMatiere(@RequestBody Detailpaiement detailpaiement) {
        System.out.println("eeeeeeeeeeeee "+detailpaiement);
        paiementService.modifHistorique(detailpaiement);
        return detailpaiement;
    }

    @GetMapping("/listHistoPaiement")
    public List<DetailPaiementDto> listHistoriquePaiement(@RequestParam(name = "id") String id) {
        return paiementService.findListDetail(id).stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

     @PutMapping("/deletePaieMatiere")
     public PaiementParMatiere deleteLivre(@RequestBody PaiementParMatiere paiementParMatiere) {
        System.out.println("matiereeee "+paiementParMatiere);
        if (paiementParMatiere == null) {
            throw new RuntimeException("matiere not found " );
        }
         paiementService.suppMat(paiementParMatiere);
         return  paiementParMatiere;
    }

    @GetMapping("/listHistoriqueMatiere")
    public List<HistoriqueMatiereDto> findHistoriqueByMatiere(@RequestParam(name = "id") String id) {
        return histoMatiereMapper.listmodelToDto(paiementService.getListeHistoriqueMatiere(id));
    }






}
