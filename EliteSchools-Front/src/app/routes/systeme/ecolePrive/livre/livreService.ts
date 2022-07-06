import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Livre } from './livre';
import {Observable} from "rxjs";

@Injectable()
export class LivreService {

  status: string[] = ['OUTOFSTOCK', 'INSTOCK', 'LOWSTOCK'];

  private baseUrl = 'http://localhost:9090/administration/livres';



  constructor(private http: HttpClient) { }

  getAll(): Observable<Livre[]> {
    return this.http.get<Livre[]>(this.baseUrl);
  }


  deleteLivreById(productId: number): Observable<Livre> {
    return this.http.delete<Livre>(`${this.baseUrl}/${productId}`);
  }

  getDetailLivre(idLivre: number): Observable<Livre> {
    const url = this.baseUrl + "/" + idLivre;
    return this.http.get<Livre>(url);
  }

  updateLivre(productData: FormData, productid: number): Observable<Livre> {
    return this.http.put<Livre>(`${this.baseUrl}/${productid}`, productData);
  }

  createLivre(productData: FormData): Observable<Livre> {
    return this.http.post<Livre>(this.baseUrl, productData);
  }





}
