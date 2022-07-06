import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {catchError, Observable, tap, throwError} from "rxjs";
import {Matiere} from "../entity/Matiere";

@Injectable()
export class MatiereService {

  status: string[] = ['OUTOFSTOCK', 'INSTOCK', 'LOWSTOCK'];

  private baseUrl = 'http://localhost:9090/administration/matieres';



  constructor(private http: HttpClient) { }

  getAll(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(this.baseUrl);
  }

  /*deleteLivreById(idLivre: number): Observable<number> {
    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
    return this.http.delete<number>(this.baseUrl + '/?id=' + idLivre,
      httpOptions);
  }*/

  deleteMatiereById(productId: number): Observable<Matiere> {
    return this.http.delete<Matiere>(`${this.baseUrl}/${productId}`);
  }

  getDetailMatiere(idMatiere: number): Observable<Matiere> {
    const url = this.baseUrl + "/" + idMatiere;
    return this.http.get<Matiere>(url);
  }


  updateMatiere(productData: FormData, productid: number): Observable<Matiere> {
    return this.http.put<Matiere>(`${this.baseUrl}/${productid}`, productData);
  }


  /*createMatiere(productData: FormData): Observable<Matiere> {
    return this.http.post<Matiere>(this.baseUrl, productData);
  }*/



  createMatiere(matiere: Matiere): Observable<Matiere> {

    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<Matiere>(this.baseUrl, matiere, {headers}).pipe(
      tap(data => console.log('create matiere: ' + JSON.stringify(data))),
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
