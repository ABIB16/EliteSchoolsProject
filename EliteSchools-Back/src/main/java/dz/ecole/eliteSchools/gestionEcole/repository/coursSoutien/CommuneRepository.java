package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Commune;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune,String> {

    @Query("SELECT u FROM Commune u WHERE u.codeWil.codeWilaya = ?1")
    public List<Commune> findCommuneByCodeWil(String wil);
}

//}
