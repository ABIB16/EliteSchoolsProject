import {Inscription} from "../../gestionEleve/Entity/Inscription";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {Paiement} from "./Paiement";
import {PaiementParMatiere} from "./PaiementParMatiere";


export interface ListePresence {
  idPresence: string;
  seance1: boolean;
  seance2: boolean;
  seance3: boolean;
  seance4: boolean;
  seance5: boolean;
  jour1?: number|any;
  jour2?: number|any;
  jour3?: number|any;
  jour4?: number|any;
  jour5?: number|any;
  nbrPresence: number;
  payeProf: number;
  idPayeParMat: PaiementParMatiere;








}




