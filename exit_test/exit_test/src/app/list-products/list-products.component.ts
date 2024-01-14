import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.scss']
})
export class ListProductsComponent implements OnInit {


  name:string|undefined;
  nameSearchText: string | undefined;
  productCodeSearchText: string | undefined;
  brandSearchText: string | undefined;
  minPriceSearchText: number | undefined;
  maxPriceSearchText: number | undefined;
  searchOptions = {
    name: false,
    productCode: false,
    brand: false,
    
  };
  searchResults: any[] =[];
  products: any = {};
  private url = "http://localhost:8090/items";

  constructor(private http: HttpClient, private router: Router) { }
  collection: any[] = [];
  filteredCollection: any[] = [];

  ngOnInit(): void {
    this.http.get(this.url).subscribe((products: any) => {
      this.collection = products;
      this.filteredCollection = this.collection; 
    });
  }

  logout(): void {
 
    this.showAlert('Logout successful!', 'alert-success');
    localStorage.clear();
    this.router.navigate(['/login']);
    
  }


  private showAlert(message: string,alertClass: string): void {
    const alertContainer = document.createElement('div');
    alertContainer.classList.add('alert', alertClass, 'position-fixed', 'top-0', 'end-0', 'm-3');
    alertContainer.style.zIndex = '9999';
    alertContainer.style.backgroundColor = '#FFCCCB';
    alertContainer.innerText = message;
    document.body.appendChild(alertContainer);

    setTimeout(() => {
      alertContainer.remove();
    }, 5000);
  }



  details(productcode:number){
    this.router.navigate(['product-info',{productcode}]);

   

  }




  search(): void {
    const apiUrl = 'http://localhost:8090/items/search';
    let queryParams = '';

    if (this.searchOptions.name && this.nameSearchText) {
      queryParams += `name=${this.nameSearchText}&`;
    }
    if (this.searchOptions.productCode && this.productCodeSearchText) {
      queryParams += `productcode=${this.productCodeSearchText}&`;
    }
    if (this.searchOptions.brand && this.brandSearchText) {
      queryParams += `brand=${this.brandSearchText}&`;
    }
    if (this.minPriceSearchText !== undefined) {
      queryParams += `minPrice=${this.minPriceSearchText}&`;
    }
    if (this.maxPriceSearchText !== undefined) {
      queryParams += `maxPrice=${this.maxPriceSearchText}&`;
    }

    this.http.get<any[]>(apiUrl + '?' + queryParams).subscribe(data => {
      this.searchResults = data;
      this.filteredCollection = this.collection.filter(item =>
        this.searchResults.some(result => result.productcode === item.productcode)
      );
    });
  }
}
