import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { HttpClientModule } from '@angular/common/http';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductSearchComponent } from './product-search/product-search.component';
import { ProductInfoComponent } from './product-info/product-info.component';
import { RoutegaurdGuard } from './route-gaurd.guard';
import { LandComponent } from './land/land.component';
@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    UserRegistrationComponent,
    ListProductsComponent,
    ProductSearchComponent,
    ProductInfoComponent,
    LandComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RoutegaurdGuard ],
  bootstrap: [AppComponent]
})
export class AppModule { }
