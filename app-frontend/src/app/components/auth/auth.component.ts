import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth-service.service';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { User } from '../../../models/User';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [FormsModule, RouterModule, RouterLink],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent {
  credentials: User = { username: '', password: '', email: '' };

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.credentials).subscribe({
      next: () => {
        this.router.navigate(['member']); // Redirect to member page
      },
      error: (err) => {
        console.error('Login failed', err);
      }
    });
  } 
}
