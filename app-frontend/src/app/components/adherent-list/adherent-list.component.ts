import { Component, inject } from '@angular/core';
import { AdherentService } from '../../services/adherent.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-adherent-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './adherent-list.component.html',
  styleUrl: './adherent-list.component.css'
})
export class AdherentListComponent {
  readonly #adherentService = inject(AdherentService);

  //le $ à la fin du nom de la variable signifie que c'est un observable
  readonly adherents$ = this.#adherentService.getAllAdherents();
}
