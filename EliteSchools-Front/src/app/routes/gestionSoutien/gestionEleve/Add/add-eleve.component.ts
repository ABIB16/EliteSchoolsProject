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

@Component({
  selector: 'ajouter-eleve',
  templateUrl: './add-eleve.component.html',
  styleUrls: ['./add-eleve.component.scss']
})
export class AddEleveComponent implements OnInit {
  matiereDialog!: boolean;
  submitted!: boolean;
  isSubmitted = false;
  eleve!: Eleve;
  eleveForm!: FormGroup;
  // inscriptionMatiereForm!: FormGroup;
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
  imageLocation = './assets/images/' ;
  inscriptionMatieresList: InscriptionMatiere[] = [];
  private niveau: any;

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
              private messageService: MessageService) {
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
  }

  openNew() {
    this.submitted = false;
    this.matiereDialog = true;
  }

  private initForm() {
    this.eleveForm = this.fb.group({
      ideleve: [ Validators.required],
      nomeleve: ['yiyui', Validators.required],
      prenomeleve: ['yuiyu', Validators.required],
      nomarabe: ['yuiyui', Validators.required],
      prenomarabe: ['yuiyu', Validators.required],
      sexe: ['yuiyui', Validators.required],
      datenaissance: ['', Validators.required],
      lieunaiss: ['yuiyui', Validators.required],
      ecole: [''],
      mail: ['yuiuyi@fh.coim', [Validators.required, Validators.email]],
      etat: [''],
      statut: [''],
      adresse: ['yuiyui'],
      remarques: [''],
      seriebac: [''],
      seriebem: [''],
      motif: [''],
      photo: [''],
      wilaya: [null],
      commune: [null],
      tel1: ['', Validators.required],
      de1: ['yuiyui', Validators.required],
      tel2: [''],
      de2: [''],
      tel3: [''],
      de3: [''],
      productImage: [''],
      cycleleve: [null, Validators.required],
      inscriptionMatiereList: this.fb.array([])
    });

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
        detail: 'Veuillez vérifier les champs obligatoires',
        life: 3000
      });
      return;
    }

    if (this.inscriptionMatieresList != null) {
      for (let item of this.inscriptionMatieresList) {
        this.listMatiereInscription().push(this.fb.group({
          niveauscolaire: item.niveauscolaire,
          nomProf: item.nomProf,
          groupe: item.groupe,
          remise: item.remise,
          remisePersonnel: item.remisePersonnel,
          remiseProf: item.remiseProf,
        }));
      }
    }

    const productFormData = new FormData();
    Object.keys(this.formEleve).map((key) => {
      productFormData.append(key, this.formEleve[key].value);
    });

    this.eleveService.createEleve(this.eleveForm.value, this.eleveForm.value.cycleleve).subscribe((res: Eleve) => {
    });
    this.messageService.add({
      severity: 'success',
      summary: 'Information',
      detail: 'L élève  ' + this.eleveForm.value.nomeleve + '  ' + this.eleveForm.value.prenomeleve + ' à été créé avec succès',
      life: 3000
    });
    this.eleveForm.reset();
    this.inscriptionMatieresList = [];
  }

  onImageUpload(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.eleveForm.patchValue({productImage: file});
      this.formEleve.photo.setValue(file.name);
      // @ts-ignore
      this.eleveForm.get('productImage').updateValueAndValidity();
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
    this.eleveService.addListMatiere(this.inscriptionMatieresList).subscribe();
  }

  closeDialog() {
    this.matiereDialog = false;
  }

  retour() {
    window.history.back();
  }


}


