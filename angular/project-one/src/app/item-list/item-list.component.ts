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


  constructor(service :ItemApiService) 
  { 
    this.service = service; 
    this.warehouseSearchId = 0;
    this.nameSearch = "";
    this.priceSearchId = 0;
  }

  ngOnInit(): void 
  {
    this.service.findAll().subscribe(data =>
      {
        this.items = data;
      })

  }

  warehouseList() :void
  {
    this.service.findByWarehouseId(this.warehouseSearchId).subscribe(data =>
      {
        this.warehouseItems = data;
      })
  }

  nameList() :void
  {
    this.service.findByName(this.nameSearch).subscribe(data =>
      {
        this.nameItems = data;
      })
  }

  priceList() :void
  {
    this.service.findByPrice(this.priceSearchId).subscribe(data =>
      {
        this.priceItems = data;
      })
  }
  
}
