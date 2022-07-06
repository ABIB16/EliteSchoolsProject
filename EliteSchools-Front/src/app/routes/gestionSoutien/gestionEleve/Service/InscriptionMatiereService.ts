import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, of, tap, throwError} from "rxjs";
import {Inscription} from "../Entity/Inscription";
import {Eleve} from "../Entity/Eleve";
import {CycleScolaire} from "../../../systeme/coursSoutien/entity/CycleScolaire";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {InscriptionMatiere} from "../Entity/InscriptionMatiere";


@Injectable()
export class InscriptionMatiereService {

  private baseUrl = 'http://localhost:9090/cours-de-soutien/listEleves';
  private baseUrl3 = 'http://localhost:9090/cours-de-soutien/eleve';
  private baseUrl2 = 'http://localhost:9090/cours-de-soutien/updateCell';
  private baseUrl4 = 'http://localhost:9090/cours-de-soutien';


  constructor(private http: HttpClient) {
  }

  getAll(page: number, size: number): any {
    return this.http.get(`${this.baseUrl}?page=${page}&size=${size}`);
  }

  listMatiereByEleve(idEleve: number): Observable<InscriptionMatiere[]> {
    return this.http.get<InscriptionMatiere[]>(`${this.baseUrl3}/matieres?id=${idEleve}`);
  }

  findInscriptionByEleve(id:Number): Observable<Inscription> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.get<Inscription>(this.baseUrl4+"/eleve/inscription?id="+id);
  }

  updateMatiereInscription(inscriptionMatiere: InscriptionMatiere): Observable<InscriptionMatiere> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<InscriptionMatiere>(this.baseUrl2, inscriptionMatiere, {headers}).pipe(
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
