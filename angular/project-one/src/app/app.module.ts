import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HttpClientModule} from'@angular/common/http'
import { FormsModule } from '@angular/forms';
import { ItemFindComponent } from './item-find/item-find.component';
import { ItemSaveComponent } from './item-save/item-save.component';
import { ItemDeleteComponent } from './item-delete/item-delete.component';
import { ItemUpdateComponent } from './item-update/item-update.component';
import { ButtonModule } from 'primeng/button'
import {TableModule} from 'primeng/table'
import {DropdownModule} from 'primeng/dropdown'

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    ItemFindComponent,
    ItemSaveComponent,
    ItemDeleteComponent,
    ItemUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ButtonModule,
    TableModule,
    DropdownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
