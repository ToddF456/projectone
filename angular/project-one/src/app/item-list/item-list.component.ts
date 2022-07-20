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
  warehouseItems :Array<any> = [];
  saveItem :any = {};


  constructor(service :ItemApiService) 
  { 
    this.service = service; 
    this.warehouseSearchId = 0;
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

  createItem(saveItem: any) :void
  {
    this.service.save(saveItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }
  
}
