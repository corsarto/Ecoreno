INSERT INTO employee (id, name, email, password, role) VALUES 
    ('11111111-1111-1111-1111-000000000001', 'John', 'john@ecoreno.test', '$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC', 'EMPLOYE'),
    ('11111111-1111-1111-1111-000000000002', 'Greg', 'greg@ecoreno.test', '$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC', 'EMPLOYE'),
    ('11111111-1111-1111-1111-000000000003', 'Matt', 'matt@ecoreno.test', '$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC', 'ADMIN');

INSERT INTO client (id, name, email, phone_number, housing_address) VALUES
    ('22222222-2222-2222-2222-000000000001', 'Jean Dupont', 'jean.dupont@example.com', '0639980001', '12 rue des Lilas, 66000 Perpignan'),
    ('22222222-2222-2222-2222-000000000002', 'Sophie Martin', 'sophie.martin@example.com', NULL, '8 avenue Victor Hugo, 34000 Montpellier'),
    ('22222222-2222-2222-2222-000000000003', 'Thomas Bernard', 'thomas.bernard@example.com', NULL, '25 rue de la République, 31000 Toulouse'),
    ('22222222-2222-2222-2222-000000000004', 'Camille Moreau', 'camille.moreau@example.com', '0639980002', '17 boulevard Gambetta, 11000 Carcassonne');

INSERT INTO renovation_request (id, reference, description, renovation_type, status, estimated_amount, created_at, updated_at, client_id, employee_id) VALUES
    ('33333333-3333-3333-3333-000000000001', 'REQ-2026-11-003', 'Isolation des combles perdus avec pose de laine de verre pour améliorer les performances énergétiques du logement.', 'ISOLATION', 'RECUE', NULL, '2026-11-23 09:40:00', '2026-11-23 09:40:00', '22222222-2222-2222-2222-000000000004', '11111111-1111-1111-1111-000000000001'),
    ('33333333-3333-3333-3333-000000000002', 'REQ-2026-11-002', 'Remplacement de la chaudière au gaz par une pompe à chaleur air-eau.', 'CHAUFFAGE', 'EN_QUALIFICATION', NULL, '2026-11-12 13:30:00', '2026-11-19 10:00:00', '22222222-2222-2222-2222-000000000002', '11111111-1111-1111-1111-000000000003'),
    ('33333333-3333-3333-3333-000000000003', 'REQ-2026-11-001', 'Installation d''une VMC double flux dans une maison individuelle.', 'VENTILATION', 'DEVIS_ENVOYE', 6200.00, '2026-11-03 08:50:00', '2026-11-17 14:10:00', '22222222-2222-2222-2222-000000000002', '11111111-1111-1111-1111-000000000001'), 
    ('33333333-3333-3333-3333-000000000004', 'REQ-2026-10-001', 'Remplacement de huit fenêtres en simple vitrage par des fenêtres PVC double vitrage.', 'MENUISERIES', 'PLANIFIEE', 7800.00, '2026-10-06 10:00:00', '2026-11-04 15:45:00', '22222222-2222-2222-2222-000000000003', '11111111-1111-1111-1111-000000000002'),
    ('33333333-3333-3333-3333-000000000005', 'REQ-2026-09-001', 'Isolation thermique des murs extérieurs avec finition par enduit.', 'ISOLATION', 'TERMINEE', 9800.00, '2026-09-08 09:15:00', '2026-11-13 17:00:00', '22222222-2222-2222-2222-000000000001', '11111111-1111-1111-1111-000000000001'), 
    ('33333333-3333-3333-3333-000000000006', 'REQ-2026-09-002', 'Installation de radiateurs électriques à inertie dans trois chambres et un salon.', 'CHAUFFAGE', 'REFUSEE', 3200.00, '2026-09-21 11:05:00', '2026-10-09 16:30:00', '22222222-2222-2222-2222-000000000003', '11111111-1111-1111-1111-000000000002'),
    ('33333333-3333-3333-3333-000000000007', 'REQ-2026-08-001', 'Rénovation complète d''une salle de bain avec remplacement des équipements sanitaires et amélioration de la ventilation.', 'AUTRE', 'RECUE', NULL, '2026-08-24 14:20:00', '2026-08-24 14:20:00', '22222222-2222-2222-2222-000000000004', '11111111-1111-1111-1111-000000000003');