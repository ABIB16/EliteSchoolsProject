package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.*;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ListePresenceService {

    @Autowired
    private ListePresenceRepository listePresenceRepository;

    private List<ListePresence> listePresence, listePresenceAnc;
    private Anneescolaire annee = new Anneescolaire();
    private HistoriqueSuppression historiqueSuppression = new HistoriqueSuppression();
    private Inscription inscription = new Inscription();
    private Paiement paiement = new Paiement();
    private Paiement testPaiement = new Paiement();
    private Eleve eleve = new Eleve();
    private PaiementParMatiere paiementParMatiere;
    private PaiementParMatiere testMat = new PaiementParMatiere();
    private HistoriqueModification historiqueModification = new HistoriqueModification();
    private ListePresence presence;
    private String currentmois;
    private Date currentDate;
    private List<InscriptionMatiere> listeInscriptionMatiere = new ArrayList<>();
    private Inscription inscriptionTest = new Inscription();
    private List<Paiement> listePaiement;
    private List<Inscription> listeEleveParAnnee;
    private List<Detailpaiement> detailpaiementList;
    private Detailpaiement detailpaiement = new Detailpaiement();
    private List<HistoriqueModification> listeHistoriqueMatiere;
    private List<PaiementParMatiere> listePaiementByMois, listePaiementGenererByMois, listePaiementByMoisAnnee;
    private int addition, totalEdit, totalEditLangue, restEdit, restEditLangue, verserP1, verserP2,
            remise, payerEdit, payerEditLangue, resteEvent, totalPasse, payerPasse, restPasse,
            verserP3, remiseP1, remiseP2, remiseP3, nbr_pres = 4;


    public ListePresenceService() {
    }


    public List<ListePresence> listePresence(Integer matiere,String groupe,String prof,String mois) {
        return listePresenceRepository.listElevePresent(matiere,groupe,prof,mois);
    }

    public void updateSeance(ListePresence presence) {
        listePresenceRepository.save(presence);

    }


}
