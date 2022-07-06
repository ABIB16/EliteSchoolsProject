package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Ecole;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.HistoriqueModification;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.PaiementParMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoriqueModificationRepository extends JpaRepository<HistoriqueModification,String> {

    @Query("SELECT MAX(SUBSTRING(i.idModif,5)) From HistoriqueModification i WHERE i.idModif like CONCAT(:idModif,'%')")
    public String findIdMax(String idModif);

    @Query("SELECT i FROM HistoriqueModification i WHERE i.matiereModif.idPayeParMat =?1")
    public List<HistoriqueModification> findHistoriqueByMatiere(String idPayeParMat);
}

