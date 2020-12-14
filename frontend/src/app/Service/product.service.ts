import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private baseUrl = 'http://localhost:8080/products';

    constructor(private http: HttpClient) {
    }

    getProduct(id: number): Observable<any> {
        return this.http.get(`${this.baseUrl}/${id}`);
    }

    // tslint:disable-next-line:ban-types
    createProduct(product: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}`, product);
    }

    deleteProduct(id: number): Observable<any> {
        return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
    }

    getProductList(): Observable<any> {
        return this.http.get(`${this.baseUrl}`);
    }
}
