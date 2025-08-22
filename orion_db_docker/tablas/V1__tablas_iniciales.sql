CREATE TABLE IF NOT EXISTS status (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    state VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS tecnologias (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS rol (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    rol_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS integrantes (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(100) NOT NULL,
    start TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS proyecto (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    created_at TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS proyectos_generales (
    proyecto_id INTEGER REFERENCES proyecto(id),
    integrante_id INTEGER REFERENCES integrantes(id),
    tecnologia_id INTEGER REFERENCES tecnologias(id),
    rol_id INTEGER REFERENCES rol(id),
    PRIMARY KEY (proyecto_id, integrante_id, tecnologia_id, rol_id)
);

CREATE TABLE IF NOT EXISTS proyecto_status (
    proyecto_id INTEGER REFERENCES proyecto(id),
    state_id INTEGER REFERENCES status(id),
    date Date NOT NULL,
    PRIMARY KEY (proyecto_id, state_id)
);
