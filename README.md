
# Orion Services – Dependencias Spring

Este proyecto cuenta con las siguientes dependencias esenciales para su funcionamiento:

## 📦 Dependencias

- **Spring Boot Starter Data JPA**  
  Permite la integración con **JPA/Hibernate** para la gestión de persistencia de datos.
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
- **Spring Boot Starter Web**
Proporciona soporte para el desarrollo de aplicaciones web y RESTful.

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

- **Lombok**
Librería para reducir el código repetitivo (getters, setters, constructores, etc.).

   ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
  </dependency>
- **Spring Boot Starter Test**
Incluye herramientas para realizar pruebas unitarias y de integración.

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
  </dependency>
- **PostgreSQL Driver**
Driver JDBC para conectar el proyecto con bases de datos PostgreSQL.

    ```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
- **Spring Boot Starter Validation**
Proporciona validaciones con anotaciones (JSR 380 - Bean Validation 2.0).

    ````xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
🛠️ Notas
Todas las dependencias se encuentran configuradas en el archivo pom.xml.

Se recomienda ejecutar mvn clean install después de clonar la rama para asegurar que las librerías se descarguen correctamente.

PostgreSQL debe estar en ejecución y configurado en el archivo application.properties o application.yml.

#  Migración Automática de Base de Datos con Docker

Este servicio Docker tiene como objetivo **generar de forma automática** (en caso de que no exista previamente en el servidor) una base de datos PostgreSQL llamada **`orion_db`**, utilizando las credenciales y el puerto **`5432`** definidos en el archivo `.env`.

##  Descripción General

- **Tecnología Base:** PostgreSQL (versión especificada en `docker-compose.yml`)
- **Puerto de Exposición:** Configurable vía `.env` (por defecto `5432`)
- **Objetivo:** Levantar un contenedor que contenga la base de datos **lista para usarse**, con sus tablas creadas y datos de prueba iniciales.
- **Persistencia:** Los datos se almacenan en un volumen Docker para que no se pierdan al reiniciar el contenedor.
- **Inicialización:** Ejecución automática de scripts SQL para creación de tablas y relaciones.

---

##  Configuración del Contenedor

El archivo `docker-compose.yml` contiene:

- **Versión de PostgreSQL** a utilizar.
- **Puerto del contenedor** mapeado con el servidor anfitrión.
- **Montaje de volúmenes**:
  - Persistencia de datos de PostgreSQL.
  - Montaje de la carpeta con scripts SQL para inicialización automática.

---

##  Script de Inicialización (`V#_descripcion_sentencia.sql`)

El archivo `V#__descripcion_sentencia.sql` contiene:

- **Creación de entidades** (tablas) según el modelo de datos aprobado.
- **Definición de claves primarias y foráneas**.
- **Restricciones y relaciones** necesarias para la integridad referencial.
- **Datos de prueba** para validar el correcto funcionamiento.
  Dependendiendo de la descripcion dada dentro del nombre del __.sql, sera su comportamiento dentro de la base de datos. Esto ademas de ser expandible a mas versiones de la base de datos y sus respectivas sentencias sql. 

---

##  Uso

1. Levantar el servicio:

    ```bash
    docker-compose run --rm migrations
    ```

2. Acceder a la base de datos desde cualquier cliente PostgreSQL como puede ser pgadmin4

---

##  Notas Importantes

- Los scripts guardadados dentro del directorio "tablas" se ejecutan al crear el contenedor mediante el comando indicado en el paso #1.
- Si deseas reiniciar la base de datos y volver a ejecutar el script, debes eliminar el volumen asociado (recomendado cada vez que se haga un "pull origin" del respositorio, para mantener actualizadas las nuevas versiones de sentencias sql):

    ```bash
    docker-compose down -v
    docker-compose run --rm migrations
    ```


##  Estructura de Archivos

  ```plaintext
      .
      ├── docker-compose.yml       # Configuración del contenedor PostgreSQL
      ├── .env                     # Variables de entorno (puertos, credenciales)
      ├── /tablas                 # Carpeta en donde se encuentran las sentencias sql versionadas
          └── V#__descripcion_sentencia.sql       #Sentencia sql segun su version y descripcion
  ```
#  Servicios CRUD

Se encuentra los servicios CRUD iniciales de las diferentes entidades para su acceso y gestion de sus respectivas tablas.

Para su debida ejecucion es necesario:
  1. Levantar el contenedor Docker segun las indicaciones dadas en la seccion anterior
  2. Inicializar el proyecto Spring
  3. Tener en cuenta que esta preconfigurado para ser ejecutado mediante el puerto 8081, si por razones de conflicto esto no se hace posible, cambiar el puerto tanto en 'aplication.properties' como en los respectivos enlaces

##  Integrantes
- Mediante el enlace "http://localhost:8081/orion/integrantes/get_all" se espera acceder a todos los datos ingresados previamente a la tabla integrantes en forma de JSON
- Respuesta esperada:
  ```Respuesta esperada con los datos iniciales de prueba
    [
      {
          "username": "Juan Pérez",
          "created_at": "1970-01-01T14:00:00.000+00:00"
      },
      {
          "username": "Devin Alzate",
          "created_at": "1970-01-01T16:00:00.000+00:00"
      }
    ]
  ```
