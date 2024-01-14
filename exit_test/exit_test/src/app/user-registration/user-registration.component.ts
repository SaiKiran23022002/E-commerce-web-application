import { Component,OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent 
{
  emailPattern = '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}';
  namePattern = '[A-Za-z]+';
  passwordPattern = '.{8,}';
  phoneNumberPattern = '[0-9]{10}';
  user: any = {};

  error: string|undefined;
  private apiUrl = 'http://localhost:8090/users';
  constructor(private http: HttpClient,private router: Router) { }
 
 

  registerUser() {
    this.http.post('http://localhost:8090/users', this.user).subscribe(
      response => {
        console.log('Registration successful');
        this.router.navigate(['/login']);
      },
      error => {
        console.error('Registration failed:', error);
        this.error = 'Registration failed. Please try again.'; 
        
      }
    );
  }
  

}
