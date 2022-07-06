import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';


import {Observable} from "rxjs";
import {Wilaya} from "./Wilaya";


@Injectable()
export class WilayaService {

  private baseUrl = 'http://localhost:9090/administration/wilayas';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Wilaya[]> {
    return this.http.get<Wilaya[]>(this.baseUrl);
  }
}
