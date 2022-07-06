package dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Detailpaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetailPaiementRepository extends JpaRepository<Detailpaiement,String> {

//    @Query("SELECT p FROM Paiement p WHERE p.inscription.eleve.ideleve =?1 AND p.inscription.anneescolaire.anneecourante= true AND p.moispaiement=?2")
//    public Paiement findByEleveAndAnneeMois(Integer ideleve, String mois);
//
//    @Query("SELECT p FROM Paiement p WHERE  p.moispaiement =?1 AND p.total <>0 AND p.inscription.anneescolaire.anneecourante=true and p.inscription.eleve.statut ='Actif' order by p.inscription.matricule DESC")
//    public Page<Paiement> findPaiement(String mois, Pageable pageable);
//
    @Query("SELECT p FROM Detailpaiement p WHERE  p.idpaiement.idpaiement=?1")
    public List<Detailpaiement> listDetailPaiementByIdPaiement(String idPaiement);
//
//    @Query("SELECT p FROM Paiement p WHERE p.inscription.anneescolaire.anneecourante= true AND p.moispaiement=?1 AND p.inscription.eleve.ideleve=?2")
//    public Paiement findByAnneeMois(String mois, Integer elv) ;


}

