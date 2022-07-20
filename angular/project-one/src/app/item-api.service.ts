import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemApiService {

  http :HttpClient;

  constructor(http :HttpClient) 
  {
    this.http = http; 
  }

  findAll() :Observable<any>
  {
    return this.http.get(environment.generalUrl);
  }

  findById(id :number) :Observable<any>
  {
    return this.http.get(environment.generalUrl + id);
  }

  findByWarehouseId(warehouseId :number) :Observable<any>
  {
    return this.http.get(environment.warehouseUrl + warehouseId);
  }

  save(item :any) :Observable<any>
  {
    return this.http.post(environment.generalUrl, item)
  }
}

