package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.InscriptionMatiereRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionMatiereService {

    @Autowired
    private InscriptionMatiereRepository InscriptionMatiereRepository;

    public InscriptionMatiereService(){
    }

    public List<InscriptionMatiere> findAllMatiereByeleve(int idEleve) {
        return InscriptionMatiereRepository.findMatieresByEleve(idEleve);
    }

}
