import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProducerService {

  private baseUrl = 'http://localhost:8080/producers';

  constructor(private http: HttpClient) {
  }

  getProducer(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // tslint:disable-next-line:ban-types
  createProducer(product: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, product);
  }

  deleteProducer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  getProducerList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
