import { Component, OnInit } from '@angular/core';
import { ItemApiService } from '../item-api.service';

@Component({
  selector: 'app-item-delete',
  templateUrl: './item-delete.component.html',
  styleUrls: ['./item-delete.component.css']
})
export class ItemDeleteComponent implements OnInit {

  service :ItemApiService;
  item :any = {};

  //Initiates the API when the component is loaded.
  constructor(service :ItemApiService) 
  { 
    this.service = service; 
  }

  ngOnInit(): void {}

  //Delete item function for this component
  deleteItem(item: any) :void
  {
    this.service.delete(item).subscribe(resp =>
      {
        console.log(resp);
      })
  }

}
