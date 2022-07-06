import {NiveauScolaire} from "../../coursSoutien/entity/NiveauScolaire";
import {Wilaya} from "./Wilaya";

export interface Commune {
  codeCommune:string;
  nomCommune: string;
  codeWil : Wilaya
}
