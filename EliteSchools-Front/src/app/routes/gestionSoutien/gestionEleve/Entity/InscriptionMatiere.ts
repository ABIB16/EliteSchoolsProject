import {Inscription} from "./Inscription";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {Anneescolaire} from "../../../systeme/coursSoutien/entity/Anneescolaire";
import {Eleve} from "./Eleve";


export class InscriptionMatiere {
  idInscriptionMatiere? : string;
  niveauscolaire?: NiveauScolaire | any;
  // ideleve?: Eleve ;
  // idanne? : Anneescolaire ;
  inscription? : Inscription
  nomProf? :string;
  groupe? :string;
  remise? :number;
  remisePersonnel? :string;
  remiseProf? :string;

  constructor( ) {
  }



}
