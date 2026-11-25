CREATE TABLE client (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    phone_number varchar(20),
    housing_address varchar(200) NOT NULL
);

CREATE TABLE employee (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(80) NOT NULL,
    role varchar(20) NOT NULL CHECK(role IN('EMPLOYE','ADMIN'))
);

CREATE TABLE renovation_request (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    reference varchar(100) NOT NULL UNIQUE,
    description varchar NOT NULL,
    renovation_type varchar(20) NOT NULL CHECK(renovation_type IN('ISOLATION', 'CHAUFFAGE', 'VENTILATION', 'MENUISERIES', 'AUTRE')),
    status varchar(40) NOT NULL CHECK(status IN('RECUE','EN_QUALIFICATION', 'DEVIS_ENVOYE', 'PLANIFIEE', 'TERMINEE', 'REFUSEE')),
    estimated_amount numeric(10, 2),
    created_at timestamp NOT NULL DEFAULT now(),
    updated_at timestamp NOT NULL DEFAULT now(),
    client_id uuid NOT NULL REFERENCES client(id),
    employee_id uuid NOT NULL REFERENCES employee(id)
);