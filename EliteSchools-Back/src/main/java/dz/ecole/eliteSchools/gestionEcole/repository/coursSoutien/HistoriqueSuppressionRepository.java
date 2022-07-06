package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.HistoriqueModification;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.HistoriqueSuppression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoriqueSuppressionRepository extends JpaRepository<HistoriqueSuppression,String> {


}

