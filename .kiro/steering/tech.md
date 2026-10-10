# Technology Stack

## Core Technologies

- **Java**: 21
- **Spring Boot**: 3.2.0
- **Build Tool**: Maven (wrapper included)
- **Template Engine**: Thymeleaf
- **Web Framework**: Spring Web MVC

## Dependencies

- `spring-boot-starter-web` - REST/web endpoints
- `spring-boot-starter-thymeleaf` - server-side templating
- `spring-boot-starter-test` - testing framework

## Common Commands

### Build
```bash
./mvnw clean package
```

### Run Application
```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080` by default.

### Run Tests
```bash
./mvnw test
```

### Clean Build Artifacts
```bash
./mvnw clean
```

## Java Version

The project requires Java 21. Ensure `JAVA_HOME` points to a Java 21 installation.
