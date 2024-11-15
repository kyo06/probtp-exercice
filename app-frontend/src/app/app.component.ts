import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AdherentListComponent } from './components/adherent-list/adherent-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AdherentListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}
