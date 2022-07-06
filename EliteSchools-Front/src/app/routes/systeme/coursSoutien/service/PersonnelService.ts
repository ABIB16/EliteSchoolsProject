import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {CycleScolaire} from "../entity/CycleScolaire";
import {Personnel} from "../entity/Personnel";

@Injectable()
export class PersonnelService {

  private baseUrl = 'http://localhost:9090/administration/personnels';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Personnel[]> {
    return this.http.get<Personnel[]>(this.baseUrl);
  }
}
