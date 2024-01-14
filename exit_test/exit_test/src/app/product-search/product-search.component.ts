import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent {
  nameSearchText: string|undefined;
  productCodeSearchText: string|undefined;
  brandSearchText: string|undefined;
  searchOptions = {
    name: false,
    productCode: false,
    brand: false
  };
  searchResults: any[]|undefined;
  constructor(private http: HttpClient) {}

  search(): void {
    const apiUrl = 'http://localhost:8090/products/search';
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

    this.http.get<any[]>(apiUrl + '?' + queryParams).subscribe(data => {
      this.searchResults = data;
    });
  }


}
