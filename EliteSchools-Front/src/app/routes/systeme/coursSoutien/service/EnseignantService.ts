import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {CycleScolaire} from "../entity/CycleScolaire";
import {Enseignant} from "../entity/Enseignant";

@Injectable()
export class EnseignantService {

  private baseUrl = 'http://localhost:9090/administration/enseignants';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Enseignant[]> {
    return this.http.get<Enseignant[]>(this.baseUrl);
  }
}
