import { Component, OnInit } from '@angular/core';
import { ItemApiService } from '../item-api.service';

@Component({
  selector: 'app-item-find',
  templateUrl: './item-find.component.html',
  styleUrls: ['./item-find.component.css']
})
export class ItemFindComponent implements OnInit {

  service :ItemApiService;
  searchId :number;
  item :any;
  
  //Initiates the API when the component is loaded.
  constructor(service :ItemApiService) 
  { 
    this.service = service;
    this.searchId = 0; 
    
  }

  ngOnInit(): void {}
  
  //Finding the ID method for this component.
  onChange() :void
  {
    this.service.findById(this.searchId).subscribe(data =>
      {
        this.item = data;
      })
  }

}
