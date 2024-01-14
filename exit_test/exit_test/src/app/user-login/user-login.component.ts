import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

interface CustomWindow extends Window {
  alertVisible: boolean;
}

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {

  user: any = {};
  error: string|undefined;
  private apiUrl = 'http://localhost:8090/users';



  constructor(private http: HttpClient, private router: Router) {}


  loginUser() {
    this.http.get(this.apiUrl).subscribe(
      (users: any) => {
        const foundUser = users.find(
          (user: any) =>
            user.email === this.user.email && user.password === this.user.password
        );
        if (foundUser) {
          console.log('Login successful'); 
          localStorage.setItem("email",this.user.email);
           this.router.navigate(['/list-product']);
           
           this.showSuccessAlert('Login successful!');
        } else {
          console.error('Invalid credentials');
          this.error = 'Invalid email or password.';
        }
      },
      error => {
        console.error('Login failed:', error);
        this.error = 'Login failed. Please try again.';
      }
    );
  }


  private showSuccessAlert(message: string): void {
    const alertContainer = document.createElement('div');
    alertContainer.classList.add('alert', 'alert-success', 'position-fixed', 'top-0', 'end-0', 'm-3');
    alertContainer.style.zIndex = '9999';
    alertContainer.innerText = message;
    document.body.appendChild(alertContainer);

    setTimeout(() => {
      alertContainer.remove();
    }, 5000);
  }

}
