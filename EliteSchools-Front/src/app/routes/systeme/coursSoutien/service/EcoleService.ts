import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {CycleScolaire} from "../entity/CycleScolaire";
import {Ecole} from "../entity/Ecole";

@Injectable()
export class EcoleService {

  private baseUrl = 'http://localhost:9090/administration/ecoles';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Ecole[]> {
    return this.http.get<Ecole[]>(this.baseUrl);
  }
}
