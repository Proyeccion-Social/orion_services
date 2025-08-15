-- Tabla status
INSERT INTO status (state) 
VALUES ('En progreso')
ON CONFLICT DO NOTHING;

-- Tabla tecnologias
INSERT INTO tecnologias (name) 
VALUES ('Java')
ON CONFLICT DO NOTHING;

-- Tabla rol
INSERT INTO rol (rol_name) 
VALUES ('Desarrollador')
ON CONFLICT DO NOTHING;

-- Tabla integrantes
INSERT INTO integrantes (username, start) 
VALUES ('Juan Pérez', '09:00:00')
ON CONFLICT DO NOTHING;

-- Tabla proyecto
INSERT INTO proyecto (title, description, created_at) 
VALUES ('Sistema Orion', 'Plataforma para gestión de proyectos.', '10:00:00')
ON CONFLICT DO NOTHING;

-- Tabla proyectos_generales (necesita ids existentes)
INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (1, 1, 1, 1)
ON CONFLICT DO NOTHING;

-- Tabla proyecto_status
INSERT INTO proyecto_status (proyecto_id, state_id, date) 
VALUES (1, 1, '2025-08-13')
ON CONFLICT DO NOTHING;
