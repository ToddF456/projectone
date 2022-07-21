import { Component, OnInit } from '@angular/core';
import { ItemApiService } from '../item-api.service';

@Component({
  selector: 'app-item-save',
  templateUrl: './item-save.component.html',
  styleUrls: ['./item-save.component.css']
})
export class ItemSaveComponent implements OnInit {

  service :ItemApiService;
  item :any = {};

  constructor(service :ItemApiService) 
  { 
    this.service = service; 
  }

  ngOnInit(): void {}

  saveItem(item: any) :void
  {
    this.service.save(item).subscribe(resp =>
      {
        console.log(resp);
      })
  }

  
}
