package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.MatiereRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauService {

    @Autowired
    private NiveauRepository niveauRepository;


    public NiveauService(){
    }


    public List<Niveauscolaire> findAll() {
        return niveauRepository.findAll(Sort.by("idmatiere.matiere"));
    }


    public List<Niveauscolaire> findAllByIdMatiere(int id) {
        return niveauRepository.findNiveauscolaireByIdmatiere(id);
    }

    public Niveauscolaire findById(int idf) {
        Optional <Niveauscolaire> result = niveauRepository.findById(idf);
        Niveauscolaire niv =null;
        if(result.isPresent()){
            niv = result.get();
        }else{
            throw  new RuntimeException("Aucun niveau trouvé");
        }
        return niv;
    }


    public Niveauscolaire getOne(int pjtId) {
        return null;
    }


}
