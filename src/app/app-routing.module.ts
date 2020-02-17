import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {CreateProductComponent} from './create-product/create-product.component';
import {ProducerDetailsComponent} from './producer-details/producer-details.component';
import {CreateProducerComponent} from './create-producer/create-producer.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ProducerListComponent} from './producer-list/producer-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'product', pathMatch: 'full' },
  { path: 'products', component: ProductListComponent},
  { path: 'add', component: CreateProductComponent },
  { path: 'details/:id', component: ProductDetailsComponent },

  { path: '', redirectTo: 'producer', pathMatch: 'full' },
  { path: 'producers', component: ProducerListComponent},
  { path: 'add1', component: CreateProducerComponent },
  { path: 'details1/:id', component: ProducerDetailsComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
