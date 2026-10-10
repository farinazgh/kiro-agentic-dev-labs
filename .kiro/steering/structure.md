# Project Structure

## Directory Layout

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── DemoApplication.java          # Spring Boot entry point
│   │   ├── controller/                   # Web controllers (MVC)
│   │   │   └── HomeController.java
│   │   └── model/                        # Domain models/entities
│   │       └── Event.java
│   └── resources/
│       ├── application.properties        # Spring configuration
│       ├── static/
│       │   └── css/                      # Static CSS files
│       │       └── styles.css
│       └── templates/                    # Thymeleaf templates
│           └── index.html
└── test/
    └── java/com/example/demo/
        ├── DemoApplicationTests.java     # Application context tests
        └── controller/
            └── HomeControllerTest.java   # Controller tests
```

## Package Organization

- **`com.example.demo`**: Root package containing the main application class
- **`com.example.demo.controller`**: Spring MVC controllers handling HTTP requests
- **`com.example.demo.model`**: Domain models and data structures

## Key Conventions

- Controllers use the `@Controller` annotation for view-returning endpoints
- Models are implemented as Java records for immutable data structures
- Thymeleaf templates are located in `src/main/resources/templates/`
- Static assets (CSS, JS, images) go in `src/main/resources/static/`
- Test classes mirror the main source structure under `src/test/java/`
- Test class names follow the pattern `<ClassName>Test.java`

## Configuration

- `application.properties`: Spring Boot configuration (currently minimal/default)
- `pom.xml`: Maven dependencies and build configuration
