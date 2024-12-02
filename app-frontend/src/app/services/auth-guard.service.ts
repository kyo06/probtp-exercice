import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivate } from '@angular/router';
import { AuthService } from './auth-service.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
      if (this.authService.isAuthenticated()) {
          return true;
      } else {
          this.router.navigate(['auth']); // Rediriger vers la page d'authentification
          return false;
      }
  }
}
