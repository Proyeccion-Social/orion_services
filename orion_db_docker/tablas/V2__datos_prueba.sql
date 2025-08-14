-- Tabla status
INSERT INTO status (state) 
VALUES ('En progreso');

-- Tabla tecnologias
INSERT INTO tecnologias (name) 
VALUES ('Java');

-- Tabla rol
INSERT INTO rol (rol_name) 
VALUES ('Desarrollador');

-- Tabla integrantes
INSERT INTO integrantes (username, start) 
VALUES ('Juan Pérez', '09:00:00');

-- Tabla proyecto
INSERT INTO proyecto (title, description, created_at) 
VALUES ('Sistema Orion', 'Plataforma para gestión de proyectos.', '10:00:00');

-- Tabla proyectos_generales (necesita ids existentes)
INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (1, 1, 1, 1);

-- Tabla proyecto_status
INSERT INTO proyecto_status (proyecto_id, state_id, date) 
VALUES (1, 1, '2025-08-13');
