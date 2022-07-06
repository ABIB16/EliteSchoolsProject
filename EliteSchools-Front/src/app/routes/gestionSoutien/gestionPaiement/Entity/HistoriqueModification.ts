import {Paiement} from "./Paiement";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";

export interface HistoriqueModification {
  dateModif: Date;
  datepaimnt?: string;
  montantModif: number;
  modifierPar: string;



}
