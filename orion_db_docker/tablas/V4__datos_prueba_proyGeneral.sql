INSERT INTO tecnologias (name)
VALUES ('Springboot')
ON CONFLICT DO NOTHING;

INSERT INTO rol (rol_name)
VALUES ('Lider')
ON CONFLICT DO NOTHING;

INSERT INTO proyecto (title, description, created_at)
VALUES ('Sistema pruba', 'prueba de segundo proyecto', '10:00:00')
ON CONFLICT DO NOTHING;

INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (1, 2, 1, 1)
ON CONFLICT DO NOTHING;

INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (1, 2, 2, 2)
    ON CONFLICT DO NOTHING;

INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (2, 2, 1, 1)
ON CONFLICT DO NOTHING;
INSERT INTO proyectos_generales (proyecto_id, integrante_id, tecnologia_id, rol_id)
VALUES (2, 2, 1, 2)
    ON CONFLICT DO NOTHING;