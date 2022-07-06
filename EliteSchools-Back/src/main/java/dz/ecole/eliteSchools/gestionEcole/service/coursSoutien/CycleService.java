package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CycleRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CycleService {

    @Autowired
    private CycleRepository cycleRepository;


    public CycleService() {

    }


    public List<CycleScolaire> findAll() {
        return cycleRepository.findAll();
    }



}
