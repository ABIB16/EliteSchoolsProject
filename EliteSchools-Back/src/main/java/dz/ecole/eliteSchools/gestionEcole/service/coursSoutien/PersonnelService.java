package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Personnel;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CommuneRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;


    public PersonnelService() {

    }


    public List<Personnel> findAll( ) {
        return personnelRepository.findAll();
    }



}
