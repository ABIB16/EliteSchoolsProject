import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {CycleScolaire} from "../entity/CycleScolaire";

@Injectable()
export class CycleService {

  private baseUrl = 'http://localhost:9090/administration/cycles';

  constructor(private http: HttpClient) { }

  getAll(): Observable<CycleScolaire[]> {
    return this.http.get<CycleScolaire[]>(this.baseUrl);
  }
}
