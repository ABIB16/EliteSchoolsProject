import {Component, OnInit, ViewChild} from '@angular/core';
import {EleveService} from "../Service/EleveService";
import {Router} from "@angular/router";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {NiveauService} from "../../../systeme/coursSoutien/service/NiveauService";
import {MessageService} from "primeng/api";
import {Commune} from "../../../systeme/commun/wilaya/Commune";
import {GroupeService} from "../../../systeme/coursSoutien/service/GroupeService";
import {Groupe} from "../../../systeme/coursSoutien/entity/Groupe";
import {EnseignantService} from "../../../systeme/coursSoutien/service/EnseignantService";
import {Enseignant} from "../../../systeme/coursSoutien/entity/Enseignant";
import {PresenceService} from "../../gestionPaiement/Service/PresenceService";
import {ListePresence} from "../../gestionPaiement/Entity/ListePresence";


@Component({
  selector: 'app-list-presence',
  templateUrl: './list-presence.component.html',
  styleUrls: ['./list-presence.component.scss']
})


export class ListPresenceComponent implements OnInit {

  listePresence: ListePresence[] = [];
  matiereDialog!: boolean;
  profDialog!: boolean;
  selectedProf!: Enseignant;
  selectedNiveau!: NiveauScolaire;
  matiere: any;
  enseingant: any;
  selectedMois: any;
  selectedGroupe: any;
  niveauScolaire: NiveauScolaire[] = [];
  groupes: Groupe[] = [];
  enseignants: Enseignant[] = [];
  listMois: Mois[] = [];
  submitted: boolean = false;

  constructor(private niveauService: NiveauService,
              private messageService: MessageService,
              private groupeService: GroupeService,
              private enseignantService: EnseignantService,
              private presenceService: PresenceService,
              private router: Router) {
    this.listMois = [
      {name: 'Janvier'},
      {name: 'Février'},
      {name: 'Mars'},
      {name: 'Avril'},
      {name: 'Mai'},
      {name: 'Juin'},
      {name: 'Juillet'},
      {name: 'Août'},
      {name: 'Septembre'},
      {name: 'Octobre'},
      {name: 'Novembre'},
      {name: 'Décembre'}
    ];
  }

  ngOnInit(): void {
    this.getAllNiveau();
    this.getAllGroupe();
    this.getAllProf();
    this.selectedMois = this.currentMonth();
  }

  getAllGroupe() {
    this.groupeService.getAll()
      .subscribe((res) => {
        this.groupes = res;
      })
  }

  currentMonth() {
    const date = new Date();
    const month = date.toLocaleString('default', {month: 'long'});
    return month[0].toUpperCase() + month.substr(1).toLowerCase();
  }

  getAllNiveau() {
    this.niveauService.getAll()
      .subscribe((res) => {
        this.niveauScolaire = res;
      })
  }

  getAllProf() {
    this.enseignantService.getAll()
      .subscribe((res) => {
        this.enseignants = res;
      })
  }


  afficherListePresence() {
    //this.submitted=true;
    if (this.selectedNiveau?.idnivscolaire != null && this.selectedGroupe != null && this.selectedProf?.nomenseignant != null) {
      this.presenceService.getListePresence(this.selectedNiveau.idnivscolaire, this.selectedGroupe,
        this.selectedProf.nomenseignant, this.selectedMois).subscribe((res) => {
        this.listePresence = res;
        console.log("lllllllllllllll "+this.listePresence.length)
        if (this.listePresence.length == 0) {
          this.messageService.add({
            severity: 'error',
            summary: 'Avertissement',
            detail: 'Aucun résultat trouvé !',
            life: 3000
          });
        }
      })
    }
  }

  openNew() {
    this.matiereDialog = true;
  }

  openProf() {
    this.profDialog = true;
  }

  private getAllEleve() {
    // this.eleveService.getAllEleve(this.currentPage, this.size)
    //   .subscribe((data) => {
    //     console.log(data);
    //     this.listeleve = data;
    //
    //   })
  }

  onRowSelect() {
    this.matiere = this.selectedNiveau.idmatiere?.matiere + " " + this.selectedNiveau.cycleniv?.cycleSclr
    this.matiereDialog = false;
  }

  onRowSelect2() {
    this.enseingant = this.selectedProf.nomenseignant + " " + this.selectedProf.prenomensingant
    this.profDialog = false;
  }

  updateSeance(presence: ListePresence, seance: number) {
    let day = ('0' + new Date().getDate()).slice(-2);
    switch (seance) {
      case 1:
        console.log("1111111111111111");
        presence.jour1 = parseInt(day);
        if (presence.seance1 != true) {
          presence.jour1=null;
        }
        break;
      case 2:
        console.log("22222222222");
        presence.jour2 = parseInt(day);
        if (presence.seance2 != true) {
          presence.jour2 = (null);
        }
        break;
      case 3:
        console.log("333333333");
        presence.jour3 = parseInt(day);
        if (presence.seance3 != true) {
          presence.jour3 = (null);
        }
        break;
      case 4:
        console.log("4444444444");
        presence.jour4 = parseInt(day);
        if (presence.seance4 != true) {
          presence.jour4 = null;
        }
        break;
      case 5:
        console.log("55555555555");
        presence.jour5 = parseInt(day);
        if (presence.seance5 != true) {
          presence.jour5 = null;
        }
        break;
    }

    if (presence.jour1 != null || presence.jour2 != null
      || presence.jour3 != null || presence.jour4 != null) {
      presence.nbrPresence=1;
    }
    if (presence.jour1 != null && presence.jour2 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour1 != null && presence.jour3 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour1 != null && presence.jour4 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour2 != null && presence.jour3 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour2 != null && presence.jour4 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour3 != null && presence.jour4 != null) {
      presence.nbrPresence=2;
    }
    if (presence.jour1 != null && presence.jour2 != null && presence.jour3 != null) {
      presence.nbrPresence=3;
    }
    if (presence.jour1 != null && presence.jour2 != null && presence.jour4 != null) {
      presence.nbrPresence=3;
    }
    if (presence.jour1 != null && presence.jour3 != null && presence.jour4 != null) {
      presence.nbrPresence=3;
    }
    if (presence.jour2 != null && presence.jour3 != null && presence.jour4 != null) {
      presence.nbrPresence=3;
    }
    if (presence.jour1 != null && presence.jour2 != null
      && presence.jour3 != null && presence.jour4 != null) {
      presence.nbrPresence=4;
    }
    if (presence.jour1 == null && presence.jour2 == null
      && presence.jour3 == null && presence.jour4 == null) {
      presence.nbrPresence=0;
    }


    this.presenceService.updateListePresence(presence).subscribe((res: any) => {
    });
  }


}

interface Mois {
  name: string
}
