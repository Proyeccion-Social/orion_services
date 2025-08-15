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
