import {Component, OnInit, ViewChild} from '@angular/core';
import {Eleve} from "../Entity/Eleve";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Wilaya} from "../../../systeme/commun/wilaya/Wilaya";
import {WilayaService} from "../../../systeme/commun/wilaya/WilayaService";
import {CommuneService} from "../../../systeme/commun/wilaya/CommuneService";
import {Commune} from "../../../systeme/commun/wilaya/Commune";
import {CycleScolaire} from "../../../systeme/coursSoutien/entity/CycleScolaire";
import {CycleService} from "../../../systeme/coursSoutien/service/CycleService";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {NiveauService} from "../../../systeme/coursSoutien/service/NiveauService";
import {EcoleService} from "../../../systeme/coursSoutien/service/EcoleService";
import {Ecole} from "../../../systeme/coursSoutien/entity/Ecole";
import {EleveService} from "../Service/EleveService";
import {InscriptionMatiere} from "../Entity/InscriptionMatiere";
import {Groupe} from "../../../systeme/coursSoutien/entity/Groupe";
import {Enseignant} from "../../../systeme/coursSoutien/entity/Enseignant";
import {Personnel} from "../../../systeme/coursSoutien/entity/Personnel";
import {EnseignantService} from "../../../systeme/coursSoutien/service/EnseignantService";
import {PersonnelService} from "../../../systeme/coursSoutien/service/PersonnelService";
import {GroupeService} from "../../../systeme/coursSoutien/service/GroupeService";
import {MessageService} from "primeng/api";
import {ActivatedRoute} from "@angular/router";
import {InscriptionMatiereService} from "../Service/InscriptionMatiereService";

@Component({
  selector: 'modifier-eleve-maj',
  templateUrl: './edit-eleve-maj.component.html',
  styleUrls: ['./edit-eleve.component.scss']
})
export class EditEleveMajComponent implements OnInit {
  matiereDialog!: boolean;
  submitted!: boolean;
  isSubmitted = false;
  eleve!: Eleve;
  eleveForm!: FormGroup;
  editmode = false;
  wilayas: Wilaya[] = [];
  groupes: Groupe[] = [];
  enseignants: Enseignant[] = [];
  personnels: Personnel[] = [];
  communes: Commune[] = [];
  cycles: CycleScolaire[] = [];
  ecoles: Ecole[] = [];
  niveauScolaire: NiveauScolaire[] = [];
  selectedNiveau!: NiveauScolaire[];
  imageDisplay!: string | ArrayBuffer | null;
  currentEleveId!: number;
  listIdNiveauExist: Number[] = []

  inscriptionMatieresList: InscriptionMatiere[] = [];
  private niveau: any;
  currenteleveId!: number;

  constructor(private fb: FormBuilder,
              private wilayaService: WilayaService,
              private communeService: CommuneService,
              private cycleService: CycleService,
              private niveauService: NiveauService,
              private ecoleService: EcoleService,
              private eleveService: EleveService,
              private groupeService: GroupeService,
              private enseignantService: EnseignantService,
              private personnelService: PersonnelService,
              private inscriptionMatiereService: InscriptionMatiereService,
              private messageService: MessageService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.initForm();
    this.getAllWilaya();
    this.getAllCycle();
    this.getAllEcole();
    this.getAllGroupe();
    this.getAllProf();
    this.getAllPersonnel();
    this.getAllNiveau();
    this.checkEditMode();
  }


  date5!: Date

  private checkEditMode() {
    this.route.params.subscribe((params) => {
      if (params.id) {
        this.currentEleveId = params.id;

        this.inscriptionMatiereService.listMatiereByEleve(this.currentEleveId)
          .subscribe((data) => {
            console.log(data);
            this.inscriptionMatieresList = data;
          })

        this.eleveService.getDetailEleveMaj(params.id).subscribe((eleve) => {
          // this.formEleve.nomeleve.setValue(eleve.nomeleve)
          this.date5 = eleve.datenaissance
          this.eleveForm.patchValue(eleve);
          this.getAllCommuneByWilaya(eleve.wilaya);
        });
      }
    });
  }

  openNew() {
    this.submitted = false;
    this.matiereDialog = true;
  }

  private initForm() {
    this.eleveForm = this.fb.group({
      ideleve: [Validators.required],
      nomeleve: ['', Validators.required],
      prenomeleve: ['', Validators.required],
      nomarabe: ['', Validators.required],
      prenomarabe: ['', Validators.required],
      sexe: ['', Validators.required],
      datenaissance: [null, Validators.required],
      lieunaiss: ['', Validators.required],
      ecole: [''],
      mail: ['', [Validators.required, Validators.email]],
      etat: [''],
      statut: [''],
      adresse: [''],
      remarques: [''],
      seriebac: [''],
      seriebem: [''],
      motif: [''],
      photo: [''],
      wilaya: [null],
      commune: [null],
      tel1: ['', Validators.required],
      de1: ['', Validators.required],
      tel2: [''],
      de2: [''],
      tel3: [''],
      de3: [''],
      cycleleve: [null, Validators.required],
      inscriptionMatiereList: this.fb.array([])
    });

    /* this.inscriptionMatiereForm = this.fb.group({
       //idInscriptionMatiere: [''],
       //  niveauscolaire: [null],
       nomProf: ['',],
       groupe: [''],
       remise: [],
       remisePersonnel: [''],
       remiseProf: [''],
       // ideleve: [null],
       //  idanne: [null],
     });*/
  }

  listMatiereInscription(): FormArray {
    return this.eleveForm.get('inscriptionMatiereList') as FormArray;
  }


  getAllWilaya() {
    this.wilayaService.getAll()
      .subscribe((res) => {
        this.wilayas = res;
      })
  }


  getAllGroupe() {
    this.groupeService.getAll()
      .subscribe((res) => {
        this.groupes = res;
      })
  }

  getAllProf() {
    this.enseignantService.getAll()
      .subscribe((res) => {
        this.enseignants = res;
      })
  }

  getAllPersonnel() {
    this.personnelService.getAll()
      .subscribe((res) => {
        this.personnels = res;
      })
  }

  getAllCommuneByWilaya(code: string) {
    this.communeService.listCommune(code)
      .subscribe((res) => {
        this.communes = res;
      })
  }

  onChange(event: any) {
    this.getAllCommuneByWilaya(event.value);
  }

  onCellEdit(event: any) {
    this.inscriptionMatiereService.updateMatiereInscription(event.data).subscribe((res: any) => {
    });

  }

  getAllCycle() {
    this.cycleService.getAll()
      .subscribe((res) => {
        this.cycles = res;
      })
  }

  getAllEcole() {
    this.ecoleService.getAll()
      .subscribe((res) => {
        this.ecoles = res;
      })
  }

  getAllNiveau() {
    this.niveauService.getAll()
      .subscribe((res) => {
        this.niveauScolaire = res;
      })
  }

  onSubmit() {
    this.isSubmitted = true;

    if (this.eleveForm.invalid) {
      this.messageService.add({
        severity: 'error',
        summary: 'Erreur',
        detail: 'Veuillez v??rifier les champs obligatoires',
        life: 3000
      });
      return;
    }

    if (this.inscriptionMatieresList != null) {
      for (let item of this.inscriptionMatieresList) {
        console.log("matiereeeee " + item.remisePersonnel)
        this.listMatiereInscription().push(this.fb.group({
          idInscriptionMatiere: item.idInscriptionMatiere,
          niveauscolaire: item.niveauscolaire,
          nomProf: item.nomProf,
          groupe: item.groupe,
          remise: item.remise,
          // ideleve: item.ideleve,
         //  idanne: item.idanne,
          inscription : item.inscription,
          remisePersonnel: item.remisePersonnel,
          remiseProf: item.remiseProf,
        }));
      }
    }
    this.eleveService.updateEleveMaj(this.eleveForm.value, this.eleveForm.value.cycleleve).subscribe((res: any) => {
    });
    this.messageService.add({
      severity: 'success',
      summary: 'Information',
      detail: 'L ??l??ve  ' + this.eleveForm.value.nomeleve + '  ' + this.eleveForm.value.prenomeleve + ' ?? ??t?? mis ?? jour avec succ??s',
      life: 3000
    });
  }

  onImageUpload(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.eleveForm.patchValue({productImage: file});
      // @ts-ignore
      this.eleveForm.get('photo').updateValueAndValidity();
      const fileReader = new FileReader();
      fileReader.onload = () => {
        this.imageDisplay = fileReader.result;
      };
      fileReader.readAsDataURL(file);
    }
  }

  get formEleve() {
    return this.eleveForm.controls;
  }

  addMatiere() {
    this.inscriptionMatieresList = [];
    for (let item of this.selectedNiveau) {
      let insc: InscriptionMatiere = new InscriptionMatiere();
      insc.niveauscolaire = item;
      insc.remise = 0;
      this.inscriptionMatieresList.push(insc)
      this.matiereDialog = false;
    }
  }

  closeDialog() {
    this.matiereDialog = false;
  }

  retour() {
    window.history.back();
  }


}


