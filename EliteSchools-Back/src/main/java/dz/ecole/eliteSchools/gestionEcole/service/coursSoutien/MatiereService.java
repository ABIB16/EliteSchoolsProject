package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.dto.MatiereDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class MatiereService /*implements MatiereService*/ {

    @Autowired
    private MatiereRepository matiereRepository;

    /*@Autowired
    public MatiereServiceImpl(MatiereRepository matiereRepository
                      ) {
        this.matiereRepository = matiereRepository;

    }*/

    private MatiereDto convert(Matiere matiere) {
        MatiereDto matDto = new MatiereDto();
        matDto.setIdmatiere(matiere.getIdmatiere());
        matDto.setMatiere(matiere.getMatiere());
       // matDto.setNiveauscolaireList(matiere.getNiveauscolaireList());
        return matDto;
    }

  //  @Override
    public void save(Matiere matiere) {
        System.out.println("eeeeeeeeeeeeeeeee "+matiere);
         matiere.getNiveauscolaireList().stream().forEach( s -> s.setIdmatiere(matiere));
         matiereRepository.save(matiere);
    }

   // @Override
    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    public Matiere findById(int idf) {
        Optional <Matiere> result = matiereRepository.findById(idf);
        Matiere matiere =null;
        if(result.isPresent()){
            matiere = result.get();
        }else{
            throw  new RuntimeException("Aucune matiere trouvé");
        }
        return matiere;
    }



  //  @Override
    public void deleteById(int id) {
        matiereRepository.deleteById(id);
    }

}
