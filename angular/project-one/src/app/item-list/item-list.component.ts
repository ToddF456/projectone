import { Component, OnInit } from '@angular/core';
import { ItemApiService } from '../item-api.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  service :ItemApiService;
  items :Array<any> = [];
  warehouseSearchId :number;
  nameSearch :String;
  priceSearchId :number;
  warehouseItems :Array<any> = [];
  warehouseOptions :Array<number> = [1, 2, 3]
  nameItems :Array<any> = [];
  priceItems :Array<any> = [];

  //Initiates the API when the component is loaded.
  constructor(service :ItemApiService) 
  { 
    this.service = service; 
    this.warehouseSearchId = 0;
    this.nameSearch = "";
    this.priceSearchId = 0;
  }

  //Lists all of the items in the database when the component is initialized.
  ngOnInit(): void 
  {
    this.service.findAll().subscribe(data =>
      {
        this.items = data;
      })

  }

  //Lists items based on their warehouse ID
  warehouseList() :void
  {
    this.service.findByWarehouseId(this.warehouseSearchId).subscribe(data =>
      {
        this.warehouseItems = data;
      })
  }

  //Lists items based on their name
  nameList() :void
  {
    this.service.findByName(this.nameSearch).subscribe(data =>
      {
        this.nameItems = data;
      })
  }

  //Lists items based on their price
  priceList() :void
  {
    this.service.findByPrice(this.priceSearchId).subscribe(data =>
      {
        this.priceItems = data;
      })
  }
  
}
