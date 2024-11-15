import { Contact } from "./Contact";

interface Adherent {
  id: number;
  nom: string;
  prenom: string;
  contact: Contact[];
}

export type { Adherent };
