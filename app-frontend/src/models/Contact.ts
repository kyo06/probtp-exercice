import { Document } from "./Document";

interface Contact {
  id: number;
  dateContact: Date;
  typeContact: string;

  document: Document[];
}

export type { Contact };
