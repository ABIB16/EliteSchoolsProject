package dz.ecole.eliteSchools.gestionEcole.controller.langues;

import dz.ecole.eliteSchools.gestionEcole.entity.langues.Livre;
import dz.ecole.eliteSchools.gestionEcole.repository.langues.LivreRepository;
import dz.ecole.eliteSchools.gestionEcole.service.langues.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class LivreController {

    @Autowired
    private LivreService livreService;


    @Autowired
    public LivreController() {

    }

    // return list of employe
    @GetMapping("/livres")
    public List<Livre> findAll() {
        return livreService.findAll();
    }

//    @GetMapping("/livres")
//    public ResponseEntity<Livre> finAll(){
//        return ResponseEntity<Livre>(livreService.findAll());
//    }

    //add mapping for Get / employe/{id}
    @GetMapping("/livres/{id}")
    public Livre getLivre(@PathVariable int id){
        Livre livre = livreService.findById(id);
        if(livre == null){
            throw new RuntimeException("livre not found -"+id);
        }
        return livre;
    }

    // add maping fo post / add new employe
    @PostMapping("/livres")
    public Livre addLivre(@RequestBody Livre livre){
        livreService.save(livre);
        return livre;
    }

    // add mapping for put / update employe
    @PutMapping("/livres/{id}")
    public  Livre updateLivre (@RequestBody Livre livre){
        livreService.save(livre);
        return livre;
    }

    //  delete employe
    @DeleteMapping("/livres/{id}")
    public void deleteLivre(@PathVariable int id){
        livreService.deleteById(id);
    }


}
