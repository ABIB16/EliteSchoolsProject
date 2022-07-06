package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepository communeRepository;


    public CommuneService() {

    }


    public List<Commune> findAll( String codeWil) {
        return communeRepository.findCommuneByCodeWil(codeWil);
    }



}
