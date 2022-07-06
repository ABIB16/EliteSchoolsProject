package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Niveauscolaire;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface NiveauRepository extends JpaRepository<Niveauscolaire,Integer> {

    @Query("SELECT u FROM Niveauscolaire u WHERE u.idmatiere.idmatiere = ?1")
    public List<Niveauscolaire> findNiveauscolaireByIdmatiere(int idmatiere);

}
