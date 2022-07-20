import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemDeleteComponent } from './item-delete/item-delete.component';
import { ItemFindComponent } from './item-find/item-find.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemSaveComponent } from './item-save/item-save.component';
import { ItemUpdateComponent } from './item-update/item-update.component';

const routes: Routes = [
    { path: 'item-list', component: ItemListComponent},
    { path: 'item-find', component: ItemFindComponent},
    { path: 'item-save', component: ItemSaveComponent},
    { path: 'item-update', component: ItemUpdateComponent},
    { path: 'item-delete', component: ItemDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
