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
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PaiementService {

    @Autowired
    private DetailPaiementRepository detailPaiementRepository;
    @Autowired
    private AnneeRepository anneeRepository;
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private ListePresenceRepository listPresenceRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private PaiementParMatiereRepository paiementParMatiereRepository;
    @Autowired
    private HistoriqueModificationRepository historiqueModificationRepository;
    @Autowired
    private HistoriqueSuppressionRepository historiqueSuppressionRepository;
    @Autowired
    private InscriptionMatiereService inscriptionMatiereService;



    private Anneescolaire annee = new Anneescolaire();
    private HistoriqueSuppression historiqueSuppression = new HistoriqueSuppression();
    private Inscription inscription = new Inscription();
    private ListePresence listePresence = new ListePresence();
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


    public PaiementService() {
    }

    public Paiement findById(String idf) {
        Optional<Paiement> result = paiementRepository.findById(idf);
        Paiement paiement = null;
        if (result.isPresent()) {
            paiement = result.get();
        } else {
            throw new RuntimeException("Aucun Paiement trouvé");
        }
        return paiement;
    }

    public PaiementParMatiere findByIdMatiere(String idf) {
        Optional<PaiementParMatiere> result = paiementParMatiereRepository.findById(idf);
        PaiementParMatiere mat = null;
        if (result.isPresent()) {
            mat = result.get();
        } else {
            throw new RuntimeException("Aucune matiere trouvé");
        }
        return mat;
    }

    public void deleteById(String id) {
        paiementParMatiereRepository.deleteById(id);
    }


    public Page<Paiement> findAll(Pageable pageable) {
        return paiementRepository.findPaiement(getCurrentmois(), pageable);
    }

    public List<Paiement> findAllAntecedent(Integer ideleve) {
        return paiementRepository.listeRestePayerAll(ideleve);
    }

    public void genererPaye() {
        if (/*!getCurrentmois().equals("Juin") &&*/!getCurrentmois().equals("Juillet") && !getCurrentmois().equals("Août")) {

            annee = anneeRepository.findByAnneeCourante(true);
            //  if (test == null) {
            try {
                for (Inscription inscrit : getListeEleveParAnnee()) {
                    testPaiement = paiementRepository.findByAnneeMois(getCurrentmois(), inscrit.getEleve().getIdeleve());

                    if (testPaiement == null) {
                        inscription = inscriptionRepository.findByEleveAndAnneeAndEtat(inscrit.getEleve().getIdeleve());
                        paiement.setIdpaiement(inscrit.getEleve().getIdeleve() + "/" + annee.getIdanne() + "/" + getCurrentmois());
                        paiement.setInscription(inscrit);
                        paiement.setMoispaiement(getCurrentmois());
                        paiementRepository.save(paiement);

                        for (InscriptionMatiere nv : inscriptionMatiereService.findAllMatiereByeleve((inscrit.getEleve().getIdeleve()))) {
                            paiementParMatiere = new PaiementParMatiere();
                            listePresence = new ListePresence();
                            paiementParMatiere.setIdPayeParMat(nv.getInscription().getEleve().getIdeleve() + "/"
                                    + nv.getInscription().getIdanne().getIdanne()
                                    + "/" + paiement.getMoispaiement() + "/"
                                    + nv.getNiveauscolaire().getIdnivscolaire());

                            if (!nv.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                                paiementParMatiere.setReste(nv.getNiveauscolaire().getPrix() - (nv.getNiveauscolaire().getPrix() * nv.getRemise() / 100));
                                paiementParMatiere.setNetpayer(nv.getNiveauscolaire().getPrix() - (nv.getNiveauscolaire().getPrix() * nv.getRemise() / 100));
                                paiementParMatiere.setRemise((nv.getNiveauscolaire().getPrix() * nv.getRemise()) / 100);
                                paiementParMatiere.setTaux(nv.getRemise());
                                paiementParMatiere.setVerser(0);
                            }
                            //   }

                            if (!nv.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                                paiementParMatiere.setNumpaiement(paiement);
                                paiementParMatiere.setNiveauscolaire(nv.getNiveauscolaire());
                                paiementParMatiereRepository.save(paiementParMatiere);
                            }

                            if (!nv.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                                listePresence.setIdPresence(nv.getInscription().getEleve().getIdeleve() + "/"
                                        + nv.getNiveauscolaire().getIdnivscolaire()
                                        + "/" + nv.getInscription().getIdanne().getIdanne() + "/" + getCurrentmois());
                                listePresence.setNbrPresence(0);
                                listePresence.setSeance1(Boolean.FALSE);
                                listePresence.setSeance2(Boolean.FALSE);
                                listePresence.setSeance3(Boolean.FALSE);
                                listePresence.setSeance4(Boolean.FALSE);
                                listePresence.setPayeProf(BigDecimal.ZERO);
                                listePresence.setIdPayeParMat(paiementParMatiere);
                                listPresenceRepository.save(listePresence);
                            }
                        }
                        paiement.setTotal(getAddition(inscrit.getEleve(), paiement));
                        paiement.setVerser(0);
                        paiement.setReste(getAddition(inscrit.getEleve(), paiement));
                        paiementRepository.save(paiement);
                    }
                }
                //  listePaiement = paiementRepository.findPaiement(getCurrentmois());
                //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Les paiements ont été générés pour ce mois avec succès", ""));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("erreur " + e.getMessage());
                //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreurrrrr", e.getMessage()));
            }
        }
    }

    public String getCurrentmois() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM");
        currentmois = formatter.format(new Date());
        return currentmois.substring(0, 1).toUpperCase() + currentmois.substring(1).toLowerCase();
    }

    public void setCurrentmois(String currentmois) {
        this.currentmois = currentmois;
    }

    public List<Inscription> getListeEleveParAnnee() {
        listeEleveParAnnee = inscriptionRepository.listByEleveAnnee();
        return listeEleveParAnnee;
    }

    public void setListeEleveParAnnee(List<Inscription> listeEleveParAnnee) {
        this.listeEleveParAnnee = listeEleveParAnnee;
    }

    public int total(Eleve eleve, Paiement paiement) {
        int somme = 0;
        for (PaiementParMatiere niveau : getListePaiementGenererByMois(eleve, paiement)) {
            somme += niveau.getNiveauscolaire().getPrix() - (niveau.getNiveauscolaire().getPrix() * niveau.getTaux() / 100);
        }
        return somme;
    }

    public int getAddition(Eleve eleve, Paiement paiement) {
        addition = total(eleve, paiement);
        return addition;
    }

    public List<PaiementParMatiere> getListePaiementGenererByMois(Eleve eleve, Paiement paiement) {
        listePaiementGenererByMois = paiementParMatiereRepository.findPaiementByMois(eleve.getIdeleve(), paiement.getMoispaiement());
        return listePaiementGenererByMois;
    }

    public List<HistoriqueModification> getListeHistoriqueMatiere(String histo) {
        listeHistoriqueMatiere = historiqueModificationRepository.findHistoriqueByMatiere(histo);
        return listeHistoriqueMatiere;
    }

    public List<PaiementParMatiere> findPaiementByMois(int idEleve, String mois) {
        listePaiementByMois = paiementParMatiereRepository.findPaiementByMois(idEleve, mois);
        return listePaiementByMois;
    }

    public void editerRestePaiment(PaiementParMatiere paieParMatiere, int mntverser, String typePaiement) {
        paiementParMatiereRepository.save(paieParMatiere);
        paiement = findById(paieParMatiere.getNumpaiement().getIdpaiement());
        detailpaiement = new Detailpaiement();
        detailpaiement.setIdDetail(paiement.getInscription().getEleve().getIdeleve() + "/" + getCurrentDate().getHours() + ":"
                + getCurrentDate().getMinutes() + ":" + getCurrentDate().getSeconds() + "/" + paiement.getInscription().getIdanne().getIdanne() + "/"
                + paieParMatiere.getNiveauscolaire().getIdnivscolaire());
        detailpaiement.setDatepaimnt(getCurrentDate());
        detailpaiement.setIdpaiement(paiement);
        detailpaiement.setMntverser(mntverser);
        // detailpaiement.setEcolesaisie(getUser().getNiveauSaisie());
        //   detailpaiement.setCode(getUser().getCodeUser());
        detailpaiement.setNivsclr(paieParMatiere.getNiveauscolaire());
        detailpaiement.setTypePaiement(typePaiement);
        detailPaiementRepository.save(detailpaiement);
        paiement.getDetailpaiementList().add(detailpaiement);
        paiement.setTotal(getTotalEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiement.setVerser(getPayerEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiement.setReste(getRestEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiementRepository.save(paiement);
        detailpaiement = new Detailpaiement();
    }

    public void modifParMat(PaiementParMatiere paieParMatiere) {
        if (paieParMatiere.getVerser() <= paieParMatiere.getNetpayer()) {
            paiementParMatiereRepository.save(paieParMatiere);
            paiement = findById(paieParMatiere.getNumpaiement().getIdpaiement());
            paiement.setTotal(getTotalEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
            paiement.setVerser(getPayerEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
            paiement.setReste(getRestEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
            paiementRepository.save(paiement);
            historiqueModification.setDateModif(getCurrentDate());
            historiqueModification.setMatiereModif(paieParMatiere);
            // historiqueModification.setModifierPar(getUser().getCodeUser());
            historiqueModification.setMontantModif(paieParMatiere.getVerser());
            create(historiqueModification);
            // paiementParMatiere.getHistoriqueModificationList().add(historiqueModification);
            // paiementParMatiereRepository.save(paiementParMatiere);
            historiqueModification = new HistoriqueModification();
        }
    }

    public void modifHistorique(Detailpaiement detailpaiement) {
            detailPaiementRepository.save(detailpaiement);
    }

    public void suppMat(PaiementParMatiere paieParMatiere) {
        annee = anneeRepository.findByAnneeCourante(true);
        paiement = findById(paieParMatiere.getNumpaiement().getIdpaiement());
        historiqueSuppression = new HistoriqueSuppression();
        historiqueSuppression.setAnnee(annee.getIdanne());
        historiqueSuppression.setEleve(paiement.getInscription().getEleve().getNomeleve()
                + " " + paiement.getInscription().getEleve().getPrenomeleve());
        historiqueSuppression.setMatiere(paieParMatiere.getNiveauscolaire().getIdmatiere().getMatiere() + " "
                + paieParMatiere.getNiveauscolaire().getCycleniv().getCycleSclr());
        paiementParMatiereRepository.delete(paieParMatiere);
        listePaiementByMois = paiementParMatiereRepository.findPaiementByMois(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement());
        paiement.setTotal(getTotalEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiement.setVerser(getPayerEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiement.setReste(getRestEdit(paiement.getInscription().getEleve().getIdeleve(), paiement.getMoispaiement()));
        paiementRepository.save(paiement);
        historiqueSuppression.setDateSupp(new Date());
        historiqueSuppression.setMois(getCurrentmois());
      //  historiqueSuppression.setUserr(getUser().getCodeUser());
        historiqueSuppressionRepository.save(historiqueSuppression);
    }

    public int totalModif(int idEleve, String mois) {
        int somme = 0;
        for (PaiementParMatiere totalModif : findPaiementByMois(idEleve, mois)) {
            if (totalModif.getNetpayer() != null) {
                somme += totalModif.getNetpayer();
            }
        }
        return somme;
    }

    public int verserEdit(int idEleve, String mois) {
        int somme = 0;
        for (PaiementParMatiere totalModif : findPaiementByMois(idEleve, mois)) {
            if (totalModif.getVerser() != null) {
                somme += totalModif.getVerser();
            }
        }
        return somme;
    }

    public int resteEdit(int idEleve, String mois) {
        int somme = 0;
        for (PaiementParMatiere totalModif : findPaiementByMois(idEleve, mois)) {
            if (totalModif.getReste() != null) {
                somme += totalModif.getReste();
            }
        }
        return somme;
    }

    public Date getCurrentDate() {
        currentDate = new Date();
        return currentDate;
    }

    public int getTotalEdit(int idEleve, String mois) {
        totalEdit = totalModif(idEleve, mois);
        return totalEdit;
    }

    public int getPayerEdit(int idEleve, String mois) {
        payerEdit = verserEdit(idEleve, mois);
        return payerEdit;
    }

    public int getRestEdit(int idEleve, String mois) {
        restEdit = resteEdit(idEleve, mois);
        return restEdit;
    }

    public List<Detailpaiement> findListDetail(String idPaiement) {
        return detailPaiementRepository.listDetailPaiementByIdPaiement(idPaiement);
    }

    public static String getSuivant(String value, int longeur) {
        String ch = "";
        int i = 0;
        try {
            if (value != null) {

                i = Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        ch = "" + (i + 1);
        while (ch.length() < longeur) {
            ch = "" + "0" + ch;
        }
        return ch;
    }

    public String suivantIdMax(String matricule) {
        String id = historiqueModificationRepository.findIdMax(matricule);
        return matricule + "" + getSuivant(id, 4);
    }

    public void create(HistoriqueModification entity) {
        Anneescolaire annee = new Anneescolaire();
        annee = anneeRepository.findByAnneeCourante(true);
        String mat = annee.getConcatenation();
        entity.setIdModif(suivantIdMax(mat));
        historiqueModificationRepository.save(entity);
    }


}
