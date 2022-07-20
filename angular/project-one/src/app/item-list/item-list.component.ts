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
  searchId :number;
  warehouseSearchId :number;
  item :any;
  warehouseItems :Array<any> = [];
  saveItem :any = {};


  constructor(service :ItemApiService) 
  { 
    this.service = service;
    this.searchId = 0; 
    this.warehouseSearchId = 0;
  }

  ngOnInit(): void 
  {
    this.service.findAll().subscribe(data =>
      {
        this.items = data;
      })

  }

  onChange() :void
  {
    this.service.findById(this.searchId).subscribe(data =>
      {
        this.item = data;
      })
  }

  warehouseCheck() :void
  {
    this.service.findByWarehouseId(this.warehouseSearchId).subscribe(data =>
      {
        this.warehouseItems = data;
      })
  }

  submit(saveItem: any) :void
  {
    this.service.save(saveItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }
  
}
