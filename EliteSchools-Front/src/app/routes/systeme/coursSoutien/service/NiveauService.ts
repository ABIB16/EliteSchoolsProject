import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { NiveauScolaire } from '../entity/NiveauScolaire';
import {catchError, Observable, of, tap} from "rxjs";


@Injectable()
export class NiveauService {


  private baseUrl = 'http://localhost:9090/administration/niveaux';
  private shoppingList: NiveauScolaire[] = [];


  constructor(private http: HttpClient) { }

  getAll(): Observable<NiveauScolaire[]> {
    return this.http.get<NiveauScolaire[]>(this.baseUrl);
  }


  deleteLivreById(productId: number): Observable<NiveauScolaire> {
    return this.http.delete<NiveauScolaire>(`${this.baseUrl}/${productId}`);
  }

  getDetailNiveau(idniv: number): Observable<NiveauScolaire> {
    const url = this.baseUrl + "/" + idniv;
    return this.http.get<NiveauScolaire>(url);
  }

  listNiveau( productid: number): Observable<NiveauScolaire[]> {
    return this.http.get<NiveauScolaire[]>(`${this.baseUrl}/matiere?id=${productid}`);
  }


  createLivre(productData: FormData): Observable<NiveauScolaire> {
    return this.http.post<NiveauScolaire>(this.baseUrl, productData);
  }

  add(shoppingItem: NiveauScolaire): Observable<NiveauScolaire> {
    this.shoppingList.push(shoppingItem);
    return of(shoppingItem);
  }


  getShopping(): Observable<NiveauScolaire[]> {
    return of(this.shoppingList);
  }


}
