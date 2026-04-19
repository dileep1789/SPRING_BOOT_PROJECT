# SPRING_BOOT_PROJECT

Simple Spring Boot REST API project for student management.

## Tech Stack

- Java 17
- Spring Boot 4.0.5
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- ModelMapper
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Project Structure

- `src/main/java/SPRING_BOOT_PROJECT`
  - `Controller` - REST controllers
  - `service` - business logic
  - `repository` - database access
  - `entity` - JPA entities
  - `dto` - request/response DTOs
  - `config` - app configurations
- `src/main/resources/application.properties` - application configuration

## Run Locally

1. Configure PostgreSQL settings in `src/main/resources/application.properties`.
2. Build and run:

```bash
./mvnw spring-boot:run
```

For Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

## Build and Test

```bash
./mvnw clean test
```

For Windows PowerShell:

```powershell
.\mvnw.cmd clean test
```

## Notes

- Maven wrapper files are included so everyone uses a consistent Maven version.
- Keep sensitive values (like DB passwords) out of source control.
