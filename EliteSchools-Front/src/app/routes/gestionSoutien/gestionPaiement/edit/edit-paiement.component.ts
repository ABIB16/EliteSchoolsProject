import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {ConfirmationService, MessageService} from "primeng/api";
import {ActivatedRoute} from "@angular/router";
import {Eleve} from "../../gestionEleve/Entity/Eleve";
import {EleveService} from "../../gestionEleve/Service/EleveService";
import {PaiementService} from "../Service/PaiementService";
import {PaiementParMatiere} from "../Entity/PaiementParMatiere";
import {Detailpaiement} from "../Entity/Detailpaiement";
import {HistoriqueModification} from "../Entity/HistoriqueModification";


@Component({
  selector: 'modifier-eleve',
  templateUrl: './edit-paiement.component.html',
  styleUrls: ['./edit-paiement.component.scss']
})
export class EditPaiementComponent implements OnInit {
  matiereDialog!: boolean;
  editMatiereDialog!: boolean;
  historiqueMatiereDialog!: boolean;
  editHistoPaieDialog!:boolean;
  submitted!: boolean;
  listMatiereParMois: PaiementParMatiere[] = [];
  listHistoMatiere: HistoriqueModification[] = [];
  listHistoP: Detailpaiement[] = [];
  paiementParMatiere!: PaiementParMatiere
  detailpaiement!: Detailpaiement
  nbr_pres = 4;
  resteEvent = 0;
  typePaiement: any;
  verser: any;
  reste: any;
  total: any;
  matricule: any;
  nomEleve: any;
  prenomEleve: any;
  moispaiement: any;
  remise: any;
  desactivNbrP!: boolean;


  constructor(private fb: FormBuilder,
              private paiementService: PaiementService,
              private messageService: MessageService,
              private eleveService: EleveService,
              private confirmationService: ConfirmationService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.checkEditMode();
  }


  private checkEditMode() {
    this.route.queryParams.subscribe((params) => {
      if (params.id) {
        this.paiementService.getDetailPaiement(params.id).subscribe((paiement) => {
          // this.paiementForm.patchValue(paiement);
          this.verser = paiement.verser;
          this.reste = paiement.reste;
          this.total = paiement.total;
          this.matricule = paiement.inscription.matricule;
          this.nomEleve = paiement.inscription.eleve.nomeleve;
          this.prenomEleve = paiement.inscription.eleve.prenomeleve;
          this.moispaiement = paiement.moispaiement;
        });

        this.paiementService.listPaiementParMois(params.elv, params.mois).subscribe((data) => {
          this.listMatiereParMois = data;
        })

        this.paiementService.listHistoPaiement(params.id).subscribe((data) => {
          this.listHistoP = data;
        })
      }
    });
  }

  onSubmit() {
    //  this.isSubmitted = true;
  }


  closeDialog() {
    this.matiereDialog = false;
  }

  closeDialog2() {
    this.editHistoPaieDialog = false;
  }

  closeDialog3() {
    this.editMatiereDialog = false;
  }

  retour() {
    window.history.back();
  }

  showMatiere(paiementParMatiere: PaiementParMatiere) {
    this.paiementParMatiere = {...paiementParMatiere};

    if (paiementParMatiere.nbrSeance != null) {
      this.nbr_pres = paiementParMatiere.nbrSeance;
      this.desactivNbrP = true;
    } else {
      this.nbr_pres = 4;
      this.desactivNbrP = false;
    }
    this.resteEvent = paiementParMatiere.reste;
    this.matiereDialog = true;
  }

  showEditMatiere(paiementParMatiere: PaiementParMatiere) {
    this.submitted = false;
    this.paiementParMatiere = {...paiementParMatiere};

    if (paiementParMatiere.nbrSeance != null) {
      this.nbr_pres = paiementParMatiere.nbrSeance;
    } else {
      this.nbr_pres = 4;
    }
    this.resteEvent = paiementParMatiere.reste;
    this.editMatiereDialog = true;
  }

  showEditHistoPaie(detailpaiement: Detailpaiement) {
    this.submitted = false;
    this.detailpaiement = {...detailpaiement};
    this.editHistoPaieDialog = true;
  }

  editerRestePaiment() {
    if (this.resteEvent > this.paiementParMatiere.reste) {
      this.messageService.add({
        severity: 'success',
        summary: 'Successful',
        detail: 'Vous avez dépassé le montant restant !',
        life: 3000
      });
    } else if (this.resteEvent == 0) {
      this.messageService.add({
        severity: 'success',
        summary: 'Successful',
        detail: 'Le montant versé doit être supérieur à 0 ',
        life: 3000
      });
    } else {

      if (this.paiementParMatiere.nbrSeance == null) {
        this.paiementParMatiere.nbrSeance = this.nbr_pres;
        this.paiementParMatiere.netpayer = (((this.paiementParMatiere.niveauscolaire.prix! - this.paiementParMatiere.remise) * this.nbr_pres) / 4);
      }

      this.paiementParMatiere.verser = (+this.paiementParMatiere.verser) + (+this.resteEvent);
      this.paiementParMatiere.reste = this.paiementParMatiere.netpayer - this.paiementParMatiere.verser
      this.listMatiereParMois[this.findIndexById(this.paiementParMatiere.idPayeParMat)] = this.paiementParMatiere;
      this.paiementService.majPaiementMatiere(this.paiementParMatiere, this.resteEvent, this.typePaiement).subscribe((res: any) => {
      });

      this.messageService.add({
        severity: 'success',
        summary: 'Information',
        detail: 'Paiement ajouté avec succès',
        life: 3000
      });

      let histoPaie: Detailpaiement = new Detailpaiement();
      const now = new Date()
      histoPaie.nivsclr = this.paiementParMatiere.niveauscolaire;
      histoPaie.mntverser = this.resteEvent;
      histoPaie.typePaiement = this.typePaiement;
      histoPaie.datepaimnt = this.format(now);
      this.listHistoP.push(histoPaie);
      this.matiereDialog = false;
      this.verser = (+this.verser) + (+this.resteEvent);
      this.reste = (+this.total) + (-this.verser);
    }
    this.matiereDialog = false;
  }

  modifParMat() {
   // this.submitted = true;
    if (this.paiementParMatiere.nbrSeance == null) {
      this.messageService.add({
        severity: 'success',
        summary: 'Successful',
        detail: 'Veuillez saisir le nombre de présence',
        life: 3000
      });
    } else {
      this.paiementParMatiere.netpayer = (((this.paiementParMatiere.niveauscolaire.prix! - this.paiementParMatiere.remise) * this.paiementParMatiere.nbrSeance) / 4);
      if (this.paiementParMatiere.verser > this.paiementParMatiere.netpayer) {
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Vous avez dépassé le montant restant !',
          life: 3000
        });
      } else {
        this.paiementParMatiere.reste = this.paiementParMatiere.netpayer - this.paiementParMatiere.verser
        this.listMatiereParMois[this.findIndexById(this.paiementParMatiere.idPayeParMat)] = this.paiementParMatiere;
        this.paiementService.updatePaiementMatiere(this.paiementParMatiere).subscribe((res: any) => {
        });
        this.editMatiereDialog = false;

        this.verser = null;
        this.reste = null;
        this.total = null;

        for (let item of this.listMatiereParMois) {
          this.verser = this.verser + item.verser;
          this.reste = this.reste + item.reste;
          this.total = this.total + item.netpayer
        }

        this.messageService.add({
          severity: 'success',
          summary: 'Information',
          detail: 'Paiement modifié avec succès',
          life: 3000
        });
      }
      this.matiereDialog = false;
    }
  }


  findIndexById(id: string): number {
    let index = -1;
    for (let i = 0; i < this.listMatiereParMois.length; i++) {
      if (this.listMatiereParMois[i].idPayeParMat === id) {
        index = i;
        break;
      }
    }
    return index;
  }

  findIndexByIdDetail(id: string): number {
    let index = -1;
    for (let i = 0; i < this.listHistoP.length; i++) {
      if (this.listHistoP[i].idDetail === id) {
        index = i;
        break;
      }
    }
    return index;
  }

  format(date: Date) {
    date = new Date(date);
    var day = ('0' + date.getDate()).slice(-2);
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var year = date.getFullYear();
    return year + '-' + month + '-' + day;
  }

  onKeyPress(event: any) {
    if (event.keyCode == 13) {
      return false;
    } else {
      return true;
    }
  }

  onKeyUp(event: any) {
    this.resteEvent = this.paiementParMatiere.reste;
    this.resteEvent = (this.resteEvent * this.nbr_pres) / 4;
  }

  deleteMatiere(paiementParMatiere: PaiementParMatiere) {
    this.confirmationService.confirm({
      message: 'Voulez vous vraiment supprimer la matière ' + paiementParMatiere.niveauscolaire.idmatiere?.matiere + ' ?',
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.paiementService.deleteMatiere(paiementParMatiere).subscribe((res: any) => {
        });
        const id = this.listMatiereParMois.indexOf(paiementParMatiere);
        this.listMatiereParMois.splice(id, 1)
        this.verser = (+this.verser) + (-paiementParMatiere.verser);
        this.reste = (+this.reste) + (-paiementParMatiere.reste);
        this.total = (+this.total) + (-paiementParMatiere.netpayer);
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Matière supprimée avec succès',
          life: 3000
        });
      }
    });
  }

  openHistorique(paiementParMatiere: PaiementParMatiere) {
    this.historiqueMatiereDialog = true;
    this.paiementService.listHistoMatiere(paiementParMatiere.idPayeParMat).subscribe((data) => {
      this.listHistoMatiere = data;
    })
  }

  modifHistorique(){
    this.listHistoP[this.findIndexByIdDetail(this.detailpaiement.idDetail)] = this.detailpaiement;
    this.paiementService.updateHistoriqueMatiere(this.detailpaiement).subscribe((res: any) => {
    });
    this.messageService.add({
      severity: 'success',
      summary: 'Successful',
      detail: 'Historique modifié avec succès',
      life: 3000
    });
    this.editHistoPaieDialog = false;
  }

}


