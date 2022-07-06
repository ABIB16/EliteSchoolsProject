import {Wilaya} from "../../../systeme/commun/wilaya/Wilaya";
import {Commune} from "../../../systeme/commun/wilaya/Commune";
import {Ecole} from "../../../systeme/coursSoutien/entity/Ecole";
import {InscriptionMatiere} from "./InscriptionMatiere";

export interface Eleve {
  ideleve: number;
  nomeleve: string;
  matricule: string;
  nomarabe: string;
  prenomeleve: string;
  prenomarabe: string;
  statut: string;
  datenaissance: Date;
  lieunaiss: string;
  ecole: string;
  remarques: string;
  seriebac: string;
  seriebem: string;
  motif: string;
  adresse : string;
  wilaya : string;
  commune : string;
  mail : string;
  tel1: string;
  de1: string;
  tel2 : string;
  de2: string;
  tel3: string;
  de3: string;
  etat: string;
  cycleleve: string;
  photo?: string;
  //inscriptionMatiereList : InscriptionMatiere [];



}


