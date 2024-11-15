-- Insertions pour la table `adherent`
INSERT INTO `adherent` (`id`, `nom`, `prenom`) VALUES
(1, 'Dupont', 'Jean'),
(2, 'Martin', 'Claire'),
(3, 'Durand', 'Paul'),
(4, 'Bernard', 'Sophie'),
(5, 'Petit', 'Louis'),
(6, 'Robert', 'Camille'),
(7, 'Richard', 'Julie'),
(8, 'Simon', 'Thomas'),
(9, 'Lemoine', 'Sarah'),
(10, 'Garcia', 'Antoine');

-- Insertions pour la table `contact`
INSERT INTO `contact` (`id`, `date_contact`, `type_contact`, `adherent_id`) VALUES
(1, '2024-01-01', 1, 1),
(2, '2024-01-05', 2, 2),
(3, '2024-01-10', 1, 3),
(4, '2024-01-15', 3, 4),
(5, '2024-01-20', 2, 5),
(6, '2024-01-25', 1, 6),
(7, '2024-02-01', 3, 7),
(8, '2024-02-05', 2, 8),
(9, '2024-02-10', 1, 9),
(10, '2024-02-15', 3, 10);

-- Insertions pour la table `document`
INSERT INTO `document` (`id`, `contenu`, `date_contact`, `type_contact`, `contact_id`) VALUES
(1, 'Document 1', '2024-01-01', 1, 1),
(2, 'Document 2', '2024-01-05', 2, 2),
(3, 'Document 3', '2024-01-10', 1, 3),
(4, 'Document 4', '2024-01-15', 3, 4),
(5, 'Document 5', '2024-01-20', 2, 5),
(6, 'Document 6', '2024-01-25', 1, 6),
(7, 'Document 7', '2024-02-01', 3, 7),
(8, 'Document 8', '2024-02-05', 2, 8),
(9, 'Document 9', '2024-02-10', 1, 9),
(10, 'Document 10', '2024-02-15', 3, 10);

-- Insertions pour la table `book`
INSERT INTO `book` (`id`, `title`, `author`, `contenu`) VALUES
(1, '1984', 'George Orwell', 'Dystopia'),
(2, 'Le Petit Prince', 'Antoine de Saint-Exupéry', 'Fantasy'),
(3, 'Harry Potter', 'J.K. Rowling', 'Magic'),
(4, 'Les Misérables', 'Victor Hugo', 'Classic'),
(5, 'La Peste', 'Albert Camus', 'Philosophy'),
(6, 'Candide', 'Voltaire', 'Satire'),
(7, 'Le Rouge et le Noir', 'Stendhal', 'Romanticism'),
(8, 'L’Étranger', 'Albert Camus', 'Absurdism'),
(9, 'Madame Bovary', 'Gustave Flaubert', 'Realism'),
(10, 'Don Quixote', 'Miguel de Cervantes', 'Adventure');

-- Insertions pour la table `adherent_contacts`
INSERT INTO `adherent_contacts` (`adherent_id`, `contacts_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Insertions pour la table `contact_documents`
INSERT INTO `contact_documents` (`contact_id`, `documents_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
