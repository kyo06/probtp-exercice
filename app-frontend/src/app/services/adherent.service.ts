import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Adherent } from '../../models/Adherent';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdherentService {

  readonly apiUrl = 'http://localhost:8090';

  readonly #http = inject(HttpClient);

  getAllAdherents(): Observable<Adherent[]> {
    return this.#http.get<Adherent[]>(`${this.apiUrl}/adherents`);
  }
}
