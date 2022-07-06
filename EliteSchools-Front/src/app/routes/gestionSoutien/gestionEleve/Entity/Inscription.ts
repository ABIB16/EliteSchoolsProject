import {CycleScolaire} from "../../../systeme/coursSoutien/entity/CycleScolaire";
import {Eleve} from "./Eleve";
import {Anneescolaire} from "../../../systeme/coursSoutien/entity/Anneescolaire";
import {InscriptionMatiere} from "./InscriptionMatiere";

export interface Inscription {
  idInscription: string;
  matricule: string;
  eleve: Eleve;
  idanne: Anneescolaire;
  cycleleve: CycleScolaire;
  inscriptionMatiereList : InscriptionMatiere [];

  // ideleve: number;
  // nomeleve: string;
  // nomarabe: string;
  // prenomeleve: string;
  // prenomarabe: string;
  // statut: string;
  // cycleleve: string;



}


