package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Eleve;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    @Query(nativeQuery = true,
            value = "select *  from eleve LIMIT 1")
    public List<Eleve> eleveList();

}
