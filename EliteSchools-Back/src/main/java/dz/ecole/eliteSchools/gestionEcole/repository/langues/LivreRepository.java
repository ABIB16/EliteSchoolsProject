package dz.ecole.eliteSchools.gestionEcole.repository.langues;

import dz.ecole.eliteSchools.gestionEcole.entity.langues.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Optional;

//@CrossOrigin("http://localhost:4200")
@Repository
public interface LivreRepository extends JpaRepository<Livre,Integer> {

}
