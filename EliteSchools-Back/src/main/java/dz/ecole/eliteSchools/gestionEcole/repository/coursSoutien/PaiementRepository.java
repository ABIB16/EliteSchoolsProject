package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Ecole;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Inscription;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaiementRepository extends JpaRepository<Paiement,String> {

    @Query("SELECT p FROM Paiement p WHERE p.inscription.eleve.ideleve =?1 AND p.inscription.idanne.anneecourante= true AND p.moispaiement=?2")
    public Paiement findByEleveAndAnneeMois(Integer ideleve, String mois);

    @Query("SELECT p FROM Paiement p WHERE  p.moispaiement =?1 AND p.total <>0 AND p.inscription.idanne.anneecourante=true and p.inscription.eleve.statut ='Actif' order by p.inscription.matricule DESC")
    public Page<Paiement> findPaiement(String mois, Pageable pageable);

    @Query("SELECT p FROM Paiement p WHERE  p.reste <> 0  AND p.inscription.eleve.ideleve =?1")
    public List<Paiement> listeRestePayerAll(Integer ideleve);

    @Query("SELECT p FROM Paiement p WHERE p.inscription.idanne.anneecourante= true AND p.moispaiement=?1 AND p.inscription.eleve.ideleve=?2")
    public Paiement findByAnneeMois(String mois, Integer elv) ;


}

