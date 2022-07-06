import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {catchError, Observable, of, tap, throwError} from "rxjs";
import {CycleScolaire} from "../../../systeme/coursSoutien/entity/CycleScolaire";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {Livre} from "../../../systeme/ecolePrive/livre/livre";
import {Paiement} from "../Entity/Paiement";
import {Eleve} from "../../gestionEleve/Entity/Eleve";
import {InscriptionMatiere} from "../../gestionEleve/Entity/InscriptionMatiere";
import {PaiementParMatiere} from "../Entity/PaiementParMatiere";
import {Detailpaiement} from "../Entity/Detailpaiement";
import {HistoriqueModification} from "../Entity/HistoriqueModification";
import {ListePresence} from "../Entity/ListePresence";



@Injectable()
export class PresenceService {

  private baseUrl = 'http://localhost:9090/cours-de-soutien';

  constructor(private http: HttpClient) { }

  getListePresence(mat: number,grp: string,prof: string,mois: string): Observable<ListePresence[]> {
    return this.http.get<ListePresence[]>(`${this.baseUrl+"/listPresence"}?mat=${mat}&grp=${grp}&prof=${prof}&mois=${mois}`);
  }

  updateListePresence(presence: ListePresence): Observable<ListePresence> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<ListePresence>(this.baseUrl+"/majPresence", presence,{headers}).pipe(
      tap(data => console.log('inscriptionMatiere: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }


  private handleError(err: any): Observable<never> {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage: string;
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Backend returned code ${err.status}: ${err.body.error}`;
    }
    console.error(err);
    return throwError(errorMessage);
  }

}
