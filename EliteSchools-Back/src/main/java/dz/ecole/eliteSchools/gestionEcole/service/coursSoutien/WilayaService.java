package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CycleRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.WilayaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WilayaService {

    @Autowired
    private WilayaRepository wilayaRepository;


    public WilayaService() {

    }


    public List<Wilaya> findAll() {
        return wilayaRepository.findAll();
    }



}
