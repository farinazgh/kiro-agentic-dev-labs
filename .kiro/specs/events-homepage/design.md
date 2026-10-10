# Events Company Homepage - Technical Design

## Architecture Overview
Simple MVC pattern using Spring Boot with Thymeleaf server-side rendering. No services layer needed.

## Component Design

### 1. Model Layer
**File:** `src/main/java/com/example/demo/model/Event.java`

```java
public record Event(String name, String date, String location, String description) {}
```

**Rationale:** Java record for immutable event data. No getters/setters needed.

### 2. Controller Layer
**File:** `src/main/java/com/example/demo/controller/HomeController.java`

- **Endpoint:** `GET /`
- **Method:** `home(Model model)`
- **Responsibility:** Create 3-4 sample events, add to model, return view name
- **Sample Data:** Hardcoded `Event` instances with varied dates (concerts, conferences, workshops)

**Key Logic:**
```java
List<Event> events = List.of(
    new Event("Spring Conference", "2026-11-15", "Tech Center", "..."),
    new Event("Jazz Night", "2026-11-20", "Music Hall", "..."),
    new Event("Workshop", "2026-12-01", "Community Center", "...")
);
model.addAttribute("events", events);
```

### 3. View Layer
**File:** `src/main/resources/templates/index.html`

**Structure:**
- `<head>`: CSS link, page title
- `<body>`:
  - Welcome section: `<header>` with company name and tagline
  - Events section: `<main>` with loop `th:each="event : ${events}"`
  - Contact section: `<footer>` with email, phone, address

**Thymeleaf Expressions:**
- `th:text="${event.name}"` - Display event name
- `th:text="${event.date}"` - Display event date
- `th:text="${event.location}"` - Display event location
- `th:text="${event.description}"` - Display event description

### 4. Styling Layer
**File:** `src/main/resources/static/css/styles.css`

**Styling Approach:**
- Simple container with max-width for content centering
- Event cards with border, padding, margin for visual separation
- Basic typography and color scheme (professional blues/grays)
- Flexbox or simple block layout for card arrangement

## Configuration

### Dependencies (already in pom.xml)
- `spring-boot-starter-web` (includes Spring MVC)
- `spring-boot-starter-thymeleaf` (needs to be added)

### Application Properties
No custom configuration needed - defaults are sufficient.

## Testing Strategy

### Unit Test
**File:** `src/test/java/com/example/demo/controller/HomeControllerTest.java`

**Test Cases:**
1. `testHomePageReturnsCorrectView()` - Verify controller returns "index" view name
2. `testHomePageAddsEventsToModel()` - Verify model contains "events" attribute
3. `testEventListHasMinimumThreeEvents()` - Verify at least 3 events present

**Approach:** Use `@WebMvcTest(HomeController.class)` with MockMvc

### Integration Test (Optional)
Verify full page rendering with `@SpringBootTest` and TestRestTemplate if time permits.

## File Structure
```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/
│   │   │   └── HomeController.java
│   │   └── model/
│   │       └── Event.java
│   └── resources/
│       ├── static/css/
│       │   └── styles.css
│       └── templates/
│           └── index.html
└── test/
    └── java/com/example/demo/controller/
        └── HomeControllerTest.java
```

## Implementation Notes
- No service layer - controller directly creates sample data
- No repository layer - no database
- No DTOs - Event record serves both model and view
- Keep CSS minimal - focus on readability over design complexity
