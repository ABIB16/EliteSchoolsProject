package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Anneescolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.AnneeRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.CycleRepository;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private AnneeRepository anneeRepository;

    public Inscription findByEleveAndannee(int ideleve) {
        return inscriptionRepository.findByEleveAndAnnee(ideleve);
    }


    public Page<Inscription> findByEleveannee(boolean annee, Pageable pageable) {
        return inscriptionRepository.findByEleveannee(annee,pageable);
    }

    public Page<Inscription> findByElvPreselectionne(boolean annee, Pageable pageable) {
        return inscriptionRepository.findByElvPreselectionne(annee,pageable);
    }

    public Page<EleveDto> listAncienEleve(boolean annee,Pageable pageable) {
        return inscriptionRepository.listAncienEleve(annee,pageable);
    }

    public static String getSuivant(String value, int longeur) {
        String ch = "";
        int i = 0;
        try {
            if (value != null) {

                i = Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        ch = "" + (i + 1);
        while (ch.length() < longeur) {
            ch = "" + "0" + ch;
        }
        return ch;
    }

    public String suivantIdMax(String matricule) {
        String id = inscriptionRepository.findIdMax(matricule);
        return matricule + "" + getSuivant(id, 4);
    }

    public void create(Inscription entity) {
        Anneescolaire annee = new Anneescolaire();
        annee = anneeRepository.findByAnneeCourante(true);
        String mat = annee.getConcatenation();
        entity.setMatricule(suivantIdMax(mat));
        inscriptionRepository.save(entity);
    }

    public void createMAJ(Inscription entity) {
        Anneescolaire annee = new Anneescolaire();
        annee = anneeRepository.findByAnneeCourante(true);
        String mat = annee.getConcatenation();
        entity.setIdanne(annee);
        entity.setMatricule(suivantIdMax(mat));
        inscriptionRepository.save(entity);
    }


}
