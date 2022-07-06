package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Ecole;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CommuneRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.EcoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoleService {

    @Autowired
    private EcoleRepository ecoleRepository;


    public EcoleService() {

    }


    public List<Ecole> findAll() {
        return ecoleRepository.findAll();
    }



}
