package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.ListePresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListePresenceRepository extends JpaRepository<ListePresence, String> {
    @Query("SELECT  l from ListePresence l,InscriptionMatiere m WHERE l.idPayeParMat.numpaiement.inscription=m.inscription and m.niveauscolaire=l.idPayeParMat.niveauscolaire AND m.nomProf =?3 AND m.groupe =?2 AND l.idPayeParMat.niveauscolaire.idnivscolaire =?1 AND l.idPayeParMat.numpaiement.moispaiement =?4 AND l.idPayeParMat.numpaiement.inscription.idanne.anneecourante=true order by l.idPayeParMat.numpaiement.inscription.eleve.nomeleve")
    public List<ListePresence> listElevePresent(Integer mat, String grp, String prof, String mois);

}
