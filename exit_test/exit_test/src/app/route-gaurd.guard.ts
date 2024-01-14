import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({

  providedIn: 'root'

})

export class RoutegaurdGuard implements CanActivate {

  canActivate(

    route: ActivatedRouteSnapshot,

    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree

    {

      if(localStorage.getItem("email") == null) {

        return false

      }

      return true;

  }

 

}