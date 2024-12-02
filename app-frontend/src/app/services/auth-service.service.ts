import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { User } from '../../models/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private apiUrl = 'http://localhost:8090/api/auth';

  constructor(private http: HttpClient) {}

  login(credentials: User): Observable<any> {
    return this.http.post<{ accessToken: string }>(`${this.apiUrl}/login`, credentials).pipe(
      tap((response: { accessToken: string }) => {
        localStorage.setItem('token', response.accessToken); // Store the token
      })
    );  
  }

  register(user: User): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user); // Endpoint for registration
  }


  getUserRoles(): string[] {
    // Get token from localStorage
    const token = localStorage.getItem('token');
    if (!token) {
      return [];
    }

    try {
      // Decode the JWT token
      const tokenPayload = JSON.parse(atob(token.split('.')[1]));
      // Return roles from token payload, or empty array if no roles found
      return tokenPayload.roles || [];
    } catch (error) {
      console.error('Error decoding token:', error);
      return [];
    }
  }

  logout(): void {
    localStorage.removeItem('token'); // Remove the token
  }

  isAuthenticated(): boolean {
      // Logique pour vérifier si l'utilisateur est authentifié
      return !!localStorage.getItem('token');
  }
}
