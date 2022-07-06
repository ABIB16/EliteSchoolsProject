import {Paiement} from "./Paiement";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";

export class Detailpaiement {
  idDetail?: string | any;
  datepaimnt?: string;
  mntverser?: number;
  ecolesaisie?: string;
  code?: string;
  idpaiement?: Paiement;
  nivsclr?: NiveauScolaire | any;
  typePaiement?: string;
//  matiere?: string;

  constructor( ) {
  }

}
