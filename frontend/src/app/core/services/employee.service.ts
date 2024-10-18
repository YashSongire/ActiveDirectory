import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http :  HttpClient) { }

  private url = `http://localhost:8080/api/v1/employees`

  getAllemployee(): Observable<any>{
    return this.http.get(this.url);
  }

}
