import { Component, OnInit } from '@angular/core';
import { ItemApiService } from '../item-api.service';

@Component({
  selector: 'app-item-update',
  templateUrl: './item-update.component.html',
  styleUrls: ['./item-update.component.css']
})
export class ItemUpdateComponent implements OnInit {

  service :ItemApiService;
  warehouseItem :any = {};
  nameItem :any = {};
  priceItem :any = {};

  //Initiates the API when the component is loaded.
  constructor(service :ItemApiService) 
  { 
    this.service = service; 
  }

  ngOnInit(): void {}

  //Updates the warehouse ID of an item
  updateWarehouse(warehouseItem: any) :void
  {
    this.service.updateWarehouseId(warehouseItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

  //Updates the warehouse ID of an item
  updateName(nameItem: any) :void
  {
    this.service.updateName(nameItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

  //Updates the warehouse ID of an item
  updatePrice(priceItem: any) :void
  {
    this.service.updatePrice(priceItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

}
