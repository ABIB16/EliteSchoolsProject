import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {Wilaya} from "./Wilaya";
import {NiveauScolaire} from "../../coursSoutien/entity/NiveauScolaire";
import {Commune} from "./Commune";


@Injectable()
export class CommuneService {

  private baseUrl = 'http://localhost:9090/administration/wilayas';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Wilaya[]> {
    return this.http.get<Wilaya[]>(this.baseUrl);
  }

  listCommune( productid: string): Observable<Commune[]> {
    return this.http.get<Commune[]>(`${this.baseUrl}/commune?code=${productid}`);
  }
}
