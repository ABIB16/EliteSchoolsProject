package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Enseignant;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,String> {
}
