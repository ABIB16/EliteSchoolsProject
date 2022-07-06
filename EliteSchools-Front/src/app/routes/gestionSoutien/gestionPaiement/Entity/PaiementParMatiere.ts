import {Inscription} from "../../gestionEleve/Entity/Inscription";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {Paiement} from "./Paiement";


export interface PaiementParMatiere {
  idPayeParMat: string;
  remise: number;
  netpayer: number;
  verser: number;
  reste: number;
  taux: number;
  nbrSeance: number;
  //mois: String;
  niveauscolaire: NiveauScolaire;
  numpaiement: Paiement;

}




