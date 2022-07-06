import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {CycleScolaire} from "../entity/CycleScolaire";
import {Groupe} from "../entity/Groupe";

@Injectable()
export class GroupeService {

  private baseUrl = 'http://localhost:9090/administration/groupes';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Groupe[]> {
    return this.http.get<Groupe[]>(this.baseUrl);
  }
}
