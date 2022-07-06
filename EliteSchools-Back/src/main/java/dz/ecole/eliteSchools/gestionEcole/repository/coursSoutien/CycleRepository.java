package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@CrossOrigin("http://localhost:4200")
@Repository
public interface CycleRepository extends JpaRepository<CycleScolaire,String> {


}
