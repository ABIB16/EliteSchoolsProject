import {Inscription} from "../../gestionEleve/Entity/Inscription";
import {Detailpaiement} from "./Detailpaiement";


export interface Paiement {
  idpaiement: string;
  moispaiement: string;
  //matricule: string;
  //cycleleve: string;
 // prenomeleve: string;
 // nomeleve: string;
  total: number;
  verser: number;
  reste: number;
  //ideleve: number;
  //detailpaiementList : Detailpaiement[]
  inscription: Inscription;

}


