package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.*;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Detailpaiement;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.ListePresence;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Paiement;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.PaiementParMatiere;
import dz.ecole.eliteSchools.gestionEcole.mapper.*;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.ListePresenceService;
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
public class ListPresenceController {

    @Autowired
    private ListePresenceService listPresenceService;
    @Autowired
    private ListePresenceMapper presenceMapper;


    public ListPresenceController() {
    }

    @GetMapping("/listPresence")
    public List<ListePresenceDto> findAll(@RequestParam(name = "mat") int mat, @RequestParam(name = "grp") String grp,
                                     @RequestParam(name = "prof") String prof, @RequestParam(name = "mois") String mois) {
        return  presenceMapper.listPresenceDto(listPresenceService.listePresence(mat,grp,prof,mois));
    }

    @PutMapping("/majPresence")
    public ListePresence majListePresence(@RequestBody ListePresence presence) {
        listPresenceService.updateSeance(presence);
        return presence;
    }


}
