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



@Injectable()
export class PaiementService {

  private baseUrl = 'http://localhost:9090/cours-de-soutien';

  constructor(private http: HttpClient) { }

  getAllPaiement(page: number,size: number): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(`${this.baseUrl+"/listPaiement"}?page=${page}&size=${size}`);
  }

  genererAllPaiement(page: number,size: number): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(`${this.baseUrl+"/genererPaiement"}?page=${page}&size=${size}`);
  }

  listPaiementParMois( idEleve: number,mois:String): Observable<PaiementParMatiere[]> {
    return this.http.get<PaiementParMatiere[]>(`${this.baseUrl}/eleve/paiementMatiere?id=${idEleve}&mois=${mois}`);
  }

  getAllPaiementAntecedent(ideleve: number): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(`${this.baseUrl+"/listAntecedent"}`);
  }

  getDetailPaiement(idPaiement: string): Observable<Paiement> {
    const url = this.baseUrl+"/editPaiement?id=" + idPaiement;
    return this.http.get<Paiement>(url);
  }

  majPaiementMatiere(paieMatiere: PaiementParMatiere,mnt:number,type:string): Observable<PaiementParMatiere> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<PaiementParMatiere>(this.baseUrl+"/majPaiementMatiere?mnt="+mnt+"&type="+type, paieMatiere,{headers}).pipe(
      tap(data => console.log('inscriptionMatiere: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  updatePaiementMatiere(paieMatiere: PaiementParMatiere): Observable<PaiementParMatiere> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<PaiementParMatiere>(this.baseUrl+"/editPaiementMatiere", paieMatiere,{headers}).pipe(
      tap(data => console.log('inscriptionMatiere: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  updateHistoriqueMatiere(detail: Detailpaiement): Observable<Detailpaiement> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<Detailpaiement>(this.baseUrl+"/editHistoriqueMatiere", detail,{headers}).pipe(
      tap(data => console.log('inscriptionMatiere: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  listHistoPaiement(idPaiement: number): Observable<Detailpaiement[]> {
    return this.http.get<Detailpaiement[]>(`${this.baseUrl+"/listHistoPaiement?id="+ idPaiement}`);
  }

  listHistoMatiere(idMatiere: String): Observable<HistoriqueModification[]> {
    return this.http.get<HistoriqueModification[]>(`${this.baseUrl+"/listHistoriqueMatiere?id="+ idMatiere}`);
  }


  deleteMatiere(matierePaie: PaiementParMatiere): Observable<PaiementParMatiere> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<PaiementParMatiere>(this.baseUrl+"/deletePaieMatiere",matierePaie,{headers}).pipe(
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
