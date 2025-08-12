# 📦 Migración Automática de Base de Datos con Docker

Este servicio Docker tiene como objetivo **generar de forma automática** (en caso de que no exista previamente en el servidor) una base de datos PostgreSQL llamada **`orion_db`**, utilizando las credenciales y el puerto **`5432`** definidos en el archivo `.env`.

## 🚀 Descripción General

- **Tecnología Base:** PostgreSQL (versión especificada en `docker-compose.yml`)
- **Puerto de Exposición:** Configurable vía `.env` (por defecto `5432`)
- **Objetivo:** Levantar un contenedor que contenga la base de datos **lista para usarse**, con sus tablas creadas y datos de prueba iniciales.
- **Persistencia:** Los datos se almacenan en un volumen Docker para que no se pierdan al reiniciar el contenedor.
- **Inicialización:** Ejecución automática de scripts SQL para creación de tablas y relaciones.

---

## 📂 Estructura de Archivos

```plaintext
.
├── docker-compose.yml       # Configuración del contenedor PostgreSQL
├── .env                     # Variables de entorno (puertos, credenciales)
├── init.sql                 # Script SQL con la definición de tablas y datos iniciales
└── README.md                # Documentación del servicio


## 🛠 Configuración del Contenedor

El archivo `docker-compose.yml` contiene:

- **Versión de PostgreSQL** a utilizar.
- **Puerto del contenedor** mapeado con el servidor anfitrión.
- **Montaje de volúmenes**:
  - Persistencia de datos de PostgreSQL.
  - Montaje de la carpeta con scripts SQL para inicialización automática.

---

## 📜 Script de Inicialización (`init.sql`)

El archivo `init.sql` contiene:

- **Creación de entidades** (tablas) según el modelo de datos aprobado.
- **Definición de claves primarias y foráneas**.
- **Restricciones y relaciones** necesarias para la integridad referencial.
- **Datos de prueba** para validar el correcto funcionamiento.

---

## ⚙️ Uso

1. Configurar las variables de entorno en el archivo `.env`:

    ```env
    POSTGRES_USER=usuario_prueba
    POSTGRES_PASSWORD=contraseña_prueba
    POSTGRES_DB=orion_db
    POSTGRES_PORT=5432
    ```

2. Levantar el servicio:

    ```bash
    docker-compose up -d
    ```

3. Acceder a la base de datos desde cualquier cliente PostgreSQL usando:

    ```yaml
    Host: localhost
    Puerto: 5432
    Usuario: usuario_prueba
    Contraseña: contraseña_prueba
    Base de datos: orion_db
    ```

---

## 📌 Notas Importantes

- El script `init.sql` se ejecuta **únicamente** la primera vez que se crea el contenedor con una base de datos vacía.
- Si deseas reiniciar la base de datos y volver a ejecutar el script, debes eliminar el volumen asociado:

    ```bash
    docker-compose down -v
    docker-compose up -d
    ```
