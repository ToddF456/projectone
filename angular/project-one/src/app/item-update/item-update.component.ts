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

  constructor(service :ItemApiService) 
  { 
    this.service = service; 
  }

  ngOnInit(): void {}

  updateWarehouse(warehouseItem: any) :void
  {
    this.service.updateWarehouseId(warehouseItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

  updateName(nameItem: any) :void
  {
    this.service.updateName(nameItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

  updatePrice(priceItem: any) :void
  {
    this.service.updatePrice(priceItem).subscribe(resp =>
      {
        console.log(resp);
      })
  }

}
