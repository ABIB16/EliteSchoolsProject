package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Anneescolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

    @Query("SELECT a FROM Inscription a WHERE a.eleve.etat='Confirmé' AND a.idanne.anneecourante =?1 ORDER BY a.matricule DESC ")
    public Page<Inscription> findByEleveannee(boolean annee, Pageable pageable);

    @Query("SELECT MAX(SUBSTRING(i.matricule,5)) From Inscription i WHERE i.matricule like CONCAT(:matricule,'%')")
    public String findIdMax(String matricule);

    @Query("SELECT i FROM Inscription i WHERE i.eleve.ideleve =?1 AND i.idanne.anneecourante=true")
    public Inscription findByEleveAndAnnee(int ideleve);

    @Query("SELECT a FROM Inscription a WHERE a.eleve.etat='Non confirmé' AND a.idanne.anneecourante =?1 ORDER BY a.eleve.creerle desc,a.eleve.nomeleve,a.eleve.prenomeleve ")
    public Page<Inscription> findByElvPreselectionne(boolean annee, Pageable pageable);

    @Query("SELECT DISTINCT NEW dz.ecole.eliteSchools.gestionEcole.dto.EleveDto( e.ideleve, e.nomeleve,e.prenomeleve,e.nomarabe,e.prenomarabe,e.datenaissance,e.lieunaiss)  FROM Inscription  a , Eleve e WHERE a.eleve.ideleve=e.ideleve and a.idanne.anneecourante =?1 order by e.nomeleve")
    public Page<EleveDto> listAncienEleve(boolean annee, Pageable pageable);

    @Query("SELECT i FROM Inscription i WHERE i.idanne.anneecourante= true and i.eleve.statut ='Actif'")
    public List<Inscription> listByEleveAnnee();

    @Query("SELECT i FROM Inscription i WHERE i.eleve.ideleve = :ideleve AND i.idanne.anneecourante=true and i.eleve.etat ='Confirmé'")
    public Inscription findByEleveAndAnneeAndEtat(int ideleve);




















}
