package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Groupe;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.GroupeRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.WilayaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;


    public GroupeService() {

    }


    public List<Groupe> findAll() {
        return groupeRepository.findAll();
    }



}
