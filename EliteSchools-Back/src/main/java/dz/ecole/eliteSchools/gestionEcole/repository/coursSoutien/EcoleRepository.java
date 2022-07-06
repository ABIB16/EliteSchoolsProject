package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EcoleRepository extends JpaRepository<Ecole,String> {

   /* @Query("SELECT u FROM Commune u WHERE u.codeWil.codeWilaya = ?1")
    public List<Commune> findCommuneByCodeWil(String codeWil);*/
}

//}
