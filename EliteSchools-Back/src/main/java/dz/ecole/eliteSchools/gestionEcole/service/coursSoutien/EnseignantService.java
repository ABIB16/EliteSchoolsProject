package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Enseignant;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.EnseignantRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.WilayaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;


    public EnseignantService() {

    }


    public List<Enseignant> findAll() {
        return enseignantRepository.findAll();
    }



}
