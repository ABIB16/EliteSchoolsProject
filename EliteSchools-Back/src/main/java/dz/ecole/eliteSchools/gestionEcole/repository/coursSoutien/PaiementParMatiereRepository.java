package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.InscriptionMatiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Matiere;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.PaiementParMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementParMatiereRepository extends JpaRepository<PaiementParMatiere,String> {

    @Query("SELECT i FROM PaiementParMatiere i WHERE i.numpaiement.inscription.eleve.ideleve =?1 AND i.numpaiement.inscription.idanne.anneecourante=true AND i.numpaiement.moispaiement=?2 order by i.niveauscolaire.idmatiere.matiere, i.niveauscolaire.cycleniv.cycleSclr")
    public List<PaiementParMatiere> findPaiementByMois(int ideleve, String mois);

    @Query("SELECT i FROM PaiementParMatiere i WHERE i.numpaiement.inscription.eleve.ideleve =?1 AND i.niveauscolaire.idnivscolaire =?2 AND i.numpaiement.moispaiement =?3 AND i.numpaiement.inscription.idanne.anneecourante= true")
    public PaiementParMatiere findMatiereExiste(int elv, int niv, String mois);



}
