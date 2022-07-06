package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Repository
public interface WilayaRepository extends JpaRepository<Wilaya,String> {

}
