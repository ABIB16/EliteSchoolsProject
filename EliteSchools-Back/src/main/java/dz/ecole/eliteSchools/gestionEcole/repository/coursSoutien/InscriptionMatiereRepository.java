package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionMatiereRepository extends JpaRepository<InscriptionMatiere,Integer> {

    @Query("SELECT i FROM InscriptionMatiere i WHERE i.inscription.eleve.ideleve =?1  AND i.inscription.idanne.anneecourante=true And i.inscription.eleve.etat ='Confirmé'")
    public List<InscriptionMatiere> findMatieresByEleve(int ideleve);




}
