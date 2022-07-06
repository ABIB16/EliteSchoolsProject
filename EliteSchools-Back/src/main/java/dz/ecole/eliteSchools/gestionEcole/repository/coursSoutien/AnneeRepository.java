package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Anneescolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Repository
public interface AnneeRepository extends JpaRepository<Anneescolaire,Integer> {

    @Query("SELECT a FROM Anneescolaire a WHERE a.anneecourante =?1 ")
    public Anneescolaire findByAnneeCourante(boolean anneecourante);






}
