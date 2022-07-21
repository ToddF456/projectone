import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemApiService {

  http :HttpClient;

  //This contructor allows to use of http methods to be used throughout all of the method in this file.
  constructor(http :HttpClient) 
  {
    this.http = http; 
  }

  //Finds all of the items in the database.
  findAll() :Observable<any>
  {
    return this.http.get(environment.generalUrl);
  }

  //Finds an item based on it's ID.
  findById(id :number) :Observable<any>
  {
    return this.http.get(environment.generalUrl + id);
  }

  //Finds an item based on it's warehouse ID.
  findByWarehouseId(warehouseId :number) :Observable<any>
  {
    return this.http.get(environment.warehouseUrl + warehouseId);
  }

  //Finds an item based on it's name.
  findByName(name :String) :Observable<any>
  {
    return this.http.get(environment.nameUrl + name);
  }

  //Finds an item based on it's price.
  findByPrice(price :number) :Observable<any>
  {
    return this.http.get(environment.priceUrl + price);
  }

  //Updates an item's warehouse location via changing its warehouse ID.
  updateWarehouseId(warehouseId :number) :Observable<any>
  {
    return this.http.post(environment.warehouseUrl, warehouseId);
  }

  //Updates the name of an item.
  updateName(name :String) :Observable<any>
  {
    return this.http.post(environment.nameUrl, name);
  }

  //Updates the price of an item.
  updatePrice(price :number) :Observable<any>
  {
    return this.http.post(environment.priceUrl, price);
  }

  //Creates an item in the database.
  save(item :any) :Observable<any>
  {
    return this.http.post(environment.generalUrl, item)
  }

  //Delete an item in the database.
  delete(item :any) :Observable<any>
  {
    return this.http.post(environment.deleteUrl, item)
  }

}

