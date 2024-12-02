import { Routes } from '@angular/router';
import { AuthGuardService } from './services/auth-guard.service';

export const routes: Routes = [
    { path: '', redirectTo: 'auth', pathMatch: 'full' },
    { path: 'auth', loadComponent: () => import('./components/auth/auth.component').then(m => m.AuthComponent) }, // Remplacez par votre composant d'authentification
    { path: 'register', loadComponent: () => import('./components/register/register.component').then(m => m.RegisterComponent) },       
    { path: 'member', loadComponent: () => import('./components/member/member.component').then(m => m.MemberComponent), canActivate: [AuthGuardService] }, // Protéger la route member
    { path: '**', redirectTo: 'auth' }
];  