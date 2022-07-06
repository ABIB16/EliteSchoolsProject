package dz.ecole.eliteSchools.gestionEcole.service.langues;


import dz.ecole.eliteSchools.gestionEcole.entity.langues.Livre;
import dz.ecole.eliteSchools.gestionEcole.repository.langues.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService{

    @Autowired
    private LivreRepository livreRepository;


    public LivreService() {

    }


    public List<Livre> findAll() {
        return livreRepository.findAll();
    }


    public Livre findById(int idf) {
        Optional <Livre> result = livreRepository.findById(idf);
        Livre livre =null;
        if(result.isPresent()){
            livre = result.get();
        }else{
            throw  new RuntimeException("Aucun livre trouvé");
        }
        return livre;
    }

    public void save(Livre livre) {
        livreRepository.save(livre);
    }

    public void deleteById(int id) {
        livreRepository.deleteById(id);
    }

}
