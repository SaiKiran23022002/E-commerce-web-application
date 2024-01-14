import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandComponent } from './land/land.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductInfoComponent } from './product-info/product-info.component';
import { RoutegaurdGuard } from './route-gaurd.guard';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
const routes: Routes = [
  {
    component:UserLoginComponent ,
    path:'login'
  },
  {
    component:UserRegistrationComponent,
    path:'register'
  },
  {
    component:ListProductsComponent ,
    canActivate :[RoutegaurdGuard],
    path:'list-product'
  },

  {
    component:ProductInfoComponent,
    canActivate :[RoutegaurdGuard],
    path:'product-info'
  },
  {
    component: LandComponent,
    path:''
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
