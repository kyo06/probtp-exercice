import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { HasRoleDirective } from '../../directives/has-role.directive';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [RouterModule, HasRoleDirective],
  templateUrl: './member.component.html',
  styleUrl: './member.component.css'
})
export class MemberComponent {
  constructor(private router: Router) {}
  logout() {
    localStorage.removeItem('token'); // Remove the token
    this.router.navigate(['/auth']); // Redirect to the login page
  }
}
