CREATE TABLE client (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    nom varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    telephone varchar(20),
    adresse_logement varchar(200) NOT NULL
);

CREATE TABLE utilisateur (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    nom varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    mot_de_passe varchar(80) NOT NULL,
    role varchar(20) NOT NULL CHECK(role IN('EMPLOYE','ADMIN'))
);

CREATE TABLE demande (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    reference varchar(100) NOT NULL UNIQUE,
    description varchar NOT NULL,
    type_renovation varchar(20) NOT NULL CHECK(type_renovation IN('ISOLATION', 'CHAUFFAGE', 'VENTILATION', 'MENUISERIES', 'AUTRE')),
    statut varchar(40) NOT NULL CHECK(statut IN('RECUE','EN_QUALIFICATION', 'DEVIS_ENVOYE', 'PLANIFIEE', 'TERMINEE', 'REFUSEE')),
    montant_estime numeric(10, 2),
    date_creation timestamp NOT NULL DEFAULT now(),
    date_maj timestamp NOT NULL DEFAULT now(),
    client_id uuid NOT NULL REFERENCES client(id),
    employe_id uuid NOT NULL REFERENCES utilisateur(id)
);