import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {catchError, Observable, of, tap, throwError} from "rxjs";
import {Inscription} from "../Entity/Inscription";
import {Eleve} from "../Entity/Eleve";
import {CycleScolaire} from "../../../systeme/coursSoutien/entity/CycleScolaire";
import {NiveauScolaire} from "../../../systeme/coursSoutien/entity/NiveauScolaire";
import {InscriptionMatiere} from "../Entity/InscriptionMatiere";


@Injectable()
export class EleveService {

  private baseUrl = 'http://localhost:9090/cours-de-soutien';

  constructor(private http: HttpClient) { }

  getAllEleve(page: number,size: number): Observable<Inscription> {
    return this.http.get<Inscription>(`${this.baseUrl+"/listEleves"}?page=${page}&size=${size}`);
  }

  getAllElevePreinscrit(page: number,size: number): any {
    return this.http.get(`${this.baseUrl+"/listElevesPreinscrit"}?page=${page}&size=${size}`);
  }

  getAllAncienEleve(page: number,size: number): any {
    return this.http.get(`${this.baseUrl+"/listAncienEleves"}?page=${page}&size=${size}`);
  }

  getDetailEleve(ideleve: number): Observable<Eleve> {
    const url = this.baseUrl+"/editEleve?id=" + ideleve;
    return this.http.get<Eleve>(url);
  }

  getDetailEleveMaj(ideleve: number): Observable<Eleve> {
    const url = this.baseUrl+"/editEleveMaj" + "?id=" + ideleve;
    return this.http.get<Eleve>(url);
  }

  createEleve(productData: FormData,cycle :CycleScolaire): Observable<Eleve> {
    // const params = new HttpParams()
    //   .set('eleve', ''+eleve)
    //   .set('listMatiere', '2');

   // console.log(paramss.toString());
    // params = params.set('listNiveau', listNiveau.join(', '));
    const headers = new HttpHeaders({'Content-Type': 'application/json'});

    return this.http.post<Eleve>(this.baseUrl+"/addEleve?cycle="+cycle, productData,{headers}).pipe(
      tap(data => console.log('create eleve: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );

  }

  updateEleve(eleve: Eleve,cycle :CycleScolaire): Observable<Eleve> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<Eleve>(this.baseUrl+"/updateEleve/"+cycle, eleve,{headers}).pipe(
      tap(data => console.log('create eleve: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  updateEleveMaj(eleve: Eleve,cycle :CycleScolaire): Observable<Eleve> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<Eleve>(this.baseUrl+"/updateEleveMaj/"+cycle, eleve,{headers}).pipe(
      tap(data => console.log('create eleve: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  addListMatiere( listMatiere:InscriptionMatiere []): Observable<InscriptionMatiere []> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
     let params = new HttpParams().set('listMatiere', JSON.stringify(listMatiere));
   // return this.http.get<InscriptionMatiere []>(this.baseUrl+"/addListMatiere",{params: params});
    return this.http.post<InscriptionMatiere []>(this.baseUrl+"/addListMatiere", listMatiere,{headers}).pipe(
      tap(data => console.log('add matiere eleve: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  editListMatiere(listMatiere: InscriptionMatiere [],eleve: Eleve): Observable<InscriptionMatiere []> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put<InscriptionMatiere []>(this.baseUrl+"/editNiveau?eleve="+eleve, listMatiere,{headers}).pipe(
      tap(data => console.log('add matiere eleve: ' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  // addListMatiere(list: InscriptionMatiere []): Observable<InscriptionMatiere []> {
  //   const headers = new HttpHeaders({'Content-Type': 'application/json'});
  //   return this.http.put<InscriptionMatiere []>(this.baseUrl+"/editNiveau?eleve="+eleve, listMatiere,{headers}).pipe(
  //     tap(data => console.log('add matiere eleve: ' + JSON.stringify(data))),
  //     catchError(this.handleError)
  //   );
  // }

  createInscription(inscription: Inscription): Observable<Inscription> {

    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<Inscription>(this.baseUrl+"/addEleve", inscription,{headers}).pipe(
      tap(data => console.log('create inscription: ' + JSON.stringify(data))),
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
