import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})


export class ProductInfoComponent implements OnInit {
  productcode: number | undefined;
  product: any={}; 
  service:any={};
  pincode:number|undefined;
  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) { }
  infoCollection: any[] = [];
  collection: any[] = [];
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.productcode = params['productcode'];
      this.loadProductDetails();
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

  loadProductDetails(): void {
   
    console.warn(this.productcode)
    const apiUrl = `http://localhost:8090/items/${this.productcode}`;
    console.warn(apiUrl);
    this.http.get(apiUrl).subscribe((product: any) => {
      this.collection = product;  
      this.infoCollection.push(product);
    
    });
  }
  checkServiceability(productcode: any){
    const api=`http://localhost:8090/items/${this.productcode}/serviceability/${this.pincode}`

    this.http.get(api).subscribe((data:any)=>{
      this.service = data;
      
    })
  }
}
