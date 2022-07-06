package dz.ecole.eliteSchools.gestionEcole.service.coursSoutien;


import dz.ecole.eliteSchools.gestionEcole.dto.EleveDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.*;
import dz.ecole.eliteSchools.gestionEcole.repository.coursSoutien.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;
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
    private InscriptionMatiereRepository inscriptionMatiereRepository;
    @Autowired
    private InscriptionService inscriptionService;


    private Anneescolaire annee = new Anneescolaire();
    private Inscription inscription = new Inscription();
    private Paiement paiement = new Paiement();
    private Eleve eleve = new Eleve();
    private PaiementParMatiere paiementParMatiere;
    private PaiementParMatiere testMat = new PaiementParMatiere();
    private ListePresence presence;
    private String currentmois;
    private List<InscriptionMatiere> listeInscriptionMatiere = new ArrayList<>();
    private List<PaiementParMatiere> listePaiementByMois;
    private Inscription inscriptionTest = new Inscription();


    public EleveService() {
    }


    public List<Eleve> findAll() {
        return eleveRepository.findAll();
    }


    public Eleve findById(int idf) {
        Optional<Eleve> result = eleveRepository.findById(idf);
        Eleve eleve = null;
        if (result.isPresent()) {
            eleve = result.get();
        } else {
            throw new RuntimeException("Aucun eleve trouvé");
        }
        return eleve;
    }

    public List<InscriptionMatiere> addNiveauScolaireCreation(List <InscriptionMatiere> list){
        listeInscriptionMatiere.clear();
        listeInscriptionMatiere.addAll(list);
        return list;
    }

    public void addEleve(Eleve eleve, CycleScolaire cycle) {
        annee = anneeRepository.findByAnneeCourante(true);
        eleve.setEtat("Confirmé");
        eleve.setStatut("Actif");
        eleve.setCreerle(new Date());
        eleveRepository.save(eleve);

        inscription.setIdInscription(eleve.getIdeleve() + "/" + annee.getIdanne());
        inscription.setCycleleve(cycle);
        inscription.setEleve(eleve);
        inscription.setIdanne(annee);
        inscriptionService.create(inscription);

        if (!getCurrentmois().equals("Juin") && !getCurrentmois().equals("Juillet")) {
            System.out.println("ddddddddddddd " + inscription);
            paiement.setInscription(inscription);
            paiement.setVerser(0);
            paiement.setMoispaiement(getCurrentmois());
            paiement.setIdpaiement(eleve.getIdeleve() + "/" + annee.getIdanne() + "/" + getCurrentmois());
            paiementRepository.save(paiement);
        }

        AtomicInteger sommeTotale = new AtomicInteger();
        System.out.println("liiiiiiiiiiiiiiist "+listeInscriptionMatiere.size());
        listeInscriptionMatiere.forEach(s -> {
            s.setInscription(inscription);
            s.setIdInscriptionMatiere(eleve.getIdeleve() + "/" + annee.getIdanne() + "/" + s.getNiveauscolaire().getIdnivscolaire());
            inscriptionMatiereRepository.save(s);

            if (!getCurrentmois().equals("Juiin") && !getCurrentmois().equals("Juillet")) {
                paiementParMatiere = new PaiementParMatiere();
                presence = new ListePresence();
                paiementParMatiere.setIdPayeParMat(eleve.getIdeleve() + "/" + annee.getIdanne()
                        + "/" + paiement.getMoispaiement()
                        + "/" + s.getNiveauscolaire().getIdnivscolaire());
                paiementParMatiere.setNumpaiement(paiement);
                paiementParMatiere.setNiveauscolaire(s.getNiveauscolaire());
                paiementParMatiere.setReste(s.getNiveauscolaire().getPrix() - (s.getNiveauscolaire().getPrix() * s.getRemise() / 100));
                paiementParMatiere.setNetpayer(s.getNiveauscolaire().getPrix() - (s.getNiveauscolaire().getPrix() * s.getRemise() / 100));
                paiementParMatiere.setRemise((s.getNiveauscolaire().getPrix() * s.getRemise()) / 100);
                paiementParMatiere.setVerser(0);
                paiementParMatiere.setTaux(s.getRemise());
                sommeTotale.addAndGet(s.getNiveauscolaire().getPrix() - (s.getNiveauscolaire().getPrix() * s.getRemise() / 100));
                paiementParMatiereRepository.save(paiementParMatiere);

                if (!s.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                    presence.setIdPresence(eleve.getIdeleve() + "/"
                            + s.getNiveauscolaire().getIdnivscolaire() + "/"
                            + annee.getIdanne() + "/" + getCurrentmois());
                    presence.setNbrPresence(0);
                    presence.setSeance1(Boolean.FALSE);
                    presence.setSeance2(Boolean.FALSE);
                    presence.setSeance3(Boolean.FALSE);
                    presence.setSeance4(Boolean.FALSE);
                    presence.setPayeProf(BigDecimal.ZERO);
                    presence.setIdPayeParMat(paiementParMatiere);
                    listPresenceRepository.save(presence);
                }
            }
        });

        if (!getCurrentmois().equals("Juiin") && !getCurrentmois().equals("Juillet")) {
            paiement.setTotal(sommeTotale.get());
            paiement.setReste(sommeTotale.get());
            paiementRepository.save(paiement);
        }
    }


    public void editNiveauScolaire(Eleve eleve, List<InscriptionMatiere> listMatiere) {
        paiement = paiementRepository.findByEleveAndAnneeMois(eleve.getIdeleve(), getCurrentmois());
        inscription = inscriptionRepository.findByEleveAndAnnee(eleve.getIdeleve());

        listMatiere.forEach(mat -> {
            inscriptionMatiereRepository.save(mat);
            if (paiement != null) {
                paiementParMatiere = new PaiementParMatiere();
                paiementParMatiere.setNetpayer(mat.getNiveauscolaire().getPrix());
                paiementParMatiere.setRemise(0);
                paiementParMatiere.setVerser(0);
                paiementParMatiere.setReste(mat.getNiveauscolaire().getPrix());
                paiementParMatiere.setTaux(0);
                paiementParMatiere.setIdPayeParMat(eleve.getIdeleve() + "/"
                        + inscription.getIdanne().getIdanne()
                        + "/" + paiement.getMoispaiement()
                        + "/" + mat.getNiveauscolaire().getIdnivscolaire());
                paiementParMatiere.setNiveauscolaire(mat.getNiveauscolaire());
                paiementParMatiere.setNumpaiement(paiement);
                paiementParMatiereRepository.save(paiementParMatiere);

                if (!mat.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                    presence = new ListePresence();
                    presence.setIdPresence(inscription.getEleve().getIdeleve() + "/"
                            + mat.getNiveauscolaire().getIdnivscolaire() + "/"
                            + inscription.getIdanne().getIdanne() + "/" + getCurrentmois());
                    presence.setIdPayeParMat(paiementParMatiere);
                    presence.setNbrPresence(0);
                    presence.setSeance1(Boolean.FALSE);
                    presence.setSeance2(Boolean.FALSE);
                    presence.setSeance3(Boolean.FALSE);
                    presence.setSeance4(Boolean.FALSE);
                    presence.setPayeProf(BigDecimal.ZERO);
                    listPresenceRepository.save(presence);
                }
            }
        });

        if (paiement != null) {
            paiement.setReste(resteEdit(eleve, paiement));
            paiement.setTotal(TotalEdit(eleve, paiement));
            paiementRepository.save(paiement);
        }

        //  eleve.setModifierpar(getUser().getCodeUser());
        eleve.setModifierle(new Date());
        eleveRepository.save(eleve);
    }

    public void onCellEdit(InscriptionMatiere mat) {
        paiement = paiementRepository.findByEleveAndAnneeMois(mat.getInscription().getEleve().getIdeleve(), getCurrentmois());

        testMat = paiementParMatiereRepository.findMatiereExiste(mat.getInscription().getEleve().getIdeleve(),
                mat.getNiveauscolaire().getIdnivscolaire(), getCurrentmois());

        if (testMat != null) {
            paiementParMatiere = paiementParMatiereRepository.findById(testMat.getIdPayeParMat()).orElse(null);
            paiementParMatiere.setNetpayer(mat.getNiveauscolaire().getPrix() - (mat.getNiveauscolaire().getPrix() * mat.getRemise() / 100));
            paiementParMatiere.setRemise(mat.getNiveauscolaire().getPrix() * mat.getRemise() / 100);
            paiementParMatiere.setReste(paiementParMatiere.getNetpayer() - paiementParMatiere.getVerser());
            paiementParMatiere.setTaux(mat.getRemise());
            if (paiementParMatiere.getNetpayer() >= paiementParMatiere.getVerser()) {
                inscriptionMatiereRepository.save(mat);
                paiementParMatiereRepository.save(paiementParMatiere);
            } else {
                // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur : Le net à payer est inférieur au reste à payer", null));
            }
            paiement.setReste(resteEdit(mat.getInscription().getEleve(), paiement));
            paiement.setTotal(TotalEdit(mat.getInscription().getEleve(), paiement));
            paiementRepository.save(paiement);
        } else {
            inscriptionMatiereRepository.save(mat);
        }
    }

    public void updateEleve(Eleve eleve, CycleScolaire cycle) {
        // eleve.setModifierpar(getUser().getCodeUser());
        eleve.setModifierle(new Date());
        eleveRepository.save(eleve);
        annee = anneeRepository.findByAnneeCourante(true);
        inscription = inscriptionRepository.findByEleveAndAnnee(eleve.getIdeleve());
        inscription.setCycleleve(cycle);
        inscriptionRepository.save(inscription);
        paiement = paiementRepository.findByEleveAndAnneeMois(eleve.getIdeleve(), getCurrentmois());
        System.out.println("eeeeeeeeeee " + paiement);

        if (paiement == null && eleve.getStatut().equals("Actif")) {
            paiement = new Paiement();
            paiement.setInscription(inscription);
            paiement.setVerser(0);
            paiement.setMoispaiement(getCurrentmois());
            paiement.setIdpaiement(eleve.getIdeleve() + "/" + annee.getIdanne() + "/" + getCurrentmois());
            paiementRepository.save(paiement);

            AtomicInteger sommeTotale = new AtomicInteger();

            inscription.getInscriptionMatiereList().stream().forEach(mat -> {
                paiementParMatiere = new PaiementParMatiere();
                paiementParMatiere.setReste(mat.getNiveauscolaire().getPrix() - (mat.getNiveauscolaire().getPrix() * mat.getRemise() / 100));
                paiementParMatiere.setNetpayer(mat.getNiveauscolaire().getPrix() - (mat.getNiveauscolaire().getPrix() * mat.getRemise() / 100));
                paiementParMatiere.setRemise(0);
                paiementParMatiere.setVerser(0);
                paiementParMatiere.setTaux(mat.getRemise());
                paiementParMatiere.setIdPayeParMat(inscription.getMatricule() + "/"
                        + annee.getIdanne()
                        + "/" + paiement.getMoispaiement()
                        + "/" + mat.getNiveauscolaire().getIdnivscolaire());
                paiementParMatiere.setNiveauscolaire(mat.getNiveauscolaire());
                paiementParMatiere.setNumpaiement(paiement);
                paiementParMatiereRepository.save(paiementParMatiere);
                sommeTotale.addAndGet(mat.getNiveauscolaire().getPrix() - (mat.getNiveauscolaire().getPrix() * mat.getRemise() / 100));

                if (!mat.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                    presence = new ListePresence();
                    presence.setIdPresence(inscription.getEleve().getIdeleve() + "/"
                            + mat.getNiveauscolaire().getIdnivscolaire() + "/"
                            + annee.getIdanne() + "/" + getCurrentmois());
                    presence.setIdPayeParMat(paiementParMatiere);
                    presence.setNbrPresence(0);
                    presence.setSeance1(Boolean.FALSE);
                    presence.setSeance2(Boolean.FALSE);
                    presence.setSeance3(Boolean.FALSE);
                    presence.setSeance4(Boolean.FALSE);
                    presence.setPayeProf(BigDecimal.ZERO);
                    listPresenceRepository.save(presence);
                }
            });

            paiement.setTotal(sommeTotale.get());
            paiement.setReste(sommeTotale.get());
            paiementRepository.save(paiement);
        }
    }

    public void editEleveMAJ(Eleve eleve, CycleScolaire cycle) {
      /* else if (inscription.getInscriptionMatiereList().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez sélectionner au moins une matière", ""));
        } else {*/
        inscriptionTest = inscriptionRepository.findByEleveAndAnnee(eleve.getIdeleve());
        if (inscriptionTest == null) {
            try {
                annee = anneeRepository.findByAnneeCourante(true);
                //    eleve.setModifierpar(getUser().getCodeUser());
                eleve.setModifierle(new Date());
                eleve.setEtat("Confirmé");
                eleve.setStatut("Actif");
                eleveRepository.save(eleve);
                inscription = new Inscription();
                inscription.setEleve(eleve);
                inscription.setCycleleve(cycle);
                inscription.setIdanne(annee);
                inscription.setIdInscription(eleve.getIdeleve() + "/" + annee.getIdanne());
                inscriptionService.createMAJ(inscription);
                paiement.setInscription(inscription);
                paiement.setVerser(0);
                paiement.setMoispaiement(getCurrentmois());
                paiement.setIdpaiement(eleve.getIdeleve() + "/" + annee.getIdanne() + "/" + getCurrentmois());
                paiementRepository.save(paiement);

                AtomicInteger sommeTotale = new AtomicInteger();

                inscription.getInscriptionMatiereList().stream().forEach(inscriptionMat -> {
                    //  inscriptionMat.setIdeleve(eleve);
                    inscriptionMat.setInscription(inscription);
                    inscriptionMat.setIdInscriptionMatiere(eleve.getIdeleve() + "/" + annee.getIdanne() + "/" + inscriptionMat.getNiveauscolaire().getIdnivscolaire());
                    //   inscriptionMat.setIdanne(annee);
                    inscriptionMatiereRepository.save(inscriptionMat);

                    paiementParMatiere = new PaiementParMatiere();
                    presence = new ListePresence();
                    paiementParMatiere.setIdPayeParMat(eleve.getIdeleve() + "/"
                            + annee.getIdanne()
                            + "/" + paiement.getMoispaiement()
                            + "/" + inscriptionMat.getNiveauscolaire().getIdnivscolaire());
                    paiementParMatiere.setNumpaiement(paiement);
                    paiementParMatiere.setNiveauscolaire(inscriptionMat.getNiveauscolaire());
                    paiementParMatiere.setReste(inscriptionMat.getNiveauscolaire().getPrix() - (inscriptionMat.getNiveauscolaire().getPrix() * inscriptionMat.getRemise() / 100));
                    paiementParMatiere.setNetpayer(inscriptionMat.getNiveauscolaire().getPrix() - (inscriptionMat.getNiveauscolaire().getPrix() * inscriptionMat.getRemise() / 100));
                    paiementParMatiere.setRemise((inscriptionMat.getNiveauscolaire().getPrix() * inscriptionMat.getRemise()) / 100);
                    paiementParMatiere.setVerser(0);
                    paiementParMatiere.setTaux(inscriptionMat.getRemise());
                    sommeTotale.addAndGet(inscriptionMat.getNiveauscolaire().getPrix() - (inscriptionMat.getNiveauscolaire().getPrix() * inscriptionMat.getRemise() / 100));
                    paiementParMatiereRepository.save(paiementParMatiere);
                    if (!inscriptionMat.getNiveauscolaire().getIdmatiere().getMatiere().contains("Frais")) {
                        presence.setIdPresence(inscription.getEleve().getIdeleve() + "/"
                                + inscriptionMat.getNiveauscolaire().getIdnivscolaire()
                                + annee.getIdanne() + "/" + getCurrentmois());
                        presence.setNbrPresence(0);
                        presence.setSeance1(Boolean.FALSE);
                        presence.setSeance2(Boolean.FALSE);
                        presence.setSeance3(Boolean.FALSE);
                        presence.setSeance4(Boolean.FALSE);
                        presence.setPayeProf(BigDecimal.ZERO);
                        presence.setIdPayeParMat(paiementParMatiere);
                        listPresenceRepository.save(presence);
                    }
                });

                paiement.setTotal(sommeTotale.get());
                paiement.setReste(sommeTotale.get());
                paiementRepository.save(paiement);
                //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : L'élève " + eleve.getNomeleve() + " " + eleve.getPrenomeleve() + " a été mis à jour, son matricule est le " + inscription.getMatricule(), null));
            } catch (Exception e) {
                System.out.println("info " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Cet élève a déjà été mis à jour");
        }
        //  }
    }


    public void deleteById(int id) {
        eleveRepository.deleteById(id);
    }

    public String getCurrentmois() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM");
        currentmois = formatter.format(new java.util.Date());
        return currentmois.substring(0, 1).toUpperCase() + currentmois.substring(1).toLowerCase();
    }

    public void setCurrentmois(String currentmois) {
        this.currentmois = currentmois;
    }

    public int TotalEdit(Eleve eleve, Paiement paiement) {
        int somme = 0;
        for (PaiementParMatiere totalModif : getListePaiementByMois(eleve, paiement)) {
            if (totalModif.getNetpayer() != null) {
                somme += totalModif.getNetpayer();
            }
        }
        return somme;
    }

    public int resteEdit(Eleve eleve, Paiement paiement) {
        int somme = 0;
        for (PaiementParMatiere totalModif : getListePaiementByMois(eleve, paiement)) {
            if (totalModif.getReste() != null) {
                somme += totalModif.getReste();
            }
        }
        return somme;
    }

    public List<PaiementParMatiere> getListePaiementByMois(Eleve eleve, Paiement paiement) {
        listePaiementByMois = paiementParMatiereRepository.findPaiementByMois(eleve.getIdeleve(), paiement.getMoispaiement());
        return listePaiementByMois;
    }

    public void setListePaiementByMois(List<PaiementParMatiere> listePaiementByMois) {
        this.listePaiementByMois = listePaiementByMois;
    }


}
