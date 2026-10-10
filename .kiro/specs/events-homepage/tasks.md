# Implementation Plan: Events Company Homepage

## Overview
Implementation of a static events company homepage using Spring Boot, Thymeleaf, and CSS. The homepage will display welcome information, hardcoded sample events in card format, and contact details.

## Task Dependency Graph
```mermaid
graph TD
    T1[1. Add Thymeleaf Dependency]
    T2[2. Create Event Model]
    T3[3. Implement Home Controller]
    T4[4. Create CSS Stylesheet]
    T5[5. Create Thymeleaf Template]
    T6[6. Write Controller Unit Tests]
    
    T1 --> T3
    T2 --> T3
    T3 --> T5
    T4 --> T5
    T3 --> T6

```json
{
  "waves": [
    [1, 2, 4],
    [3],
    [5],
    [6]
  ]
}
```

## Tasks

- [x] 1. Add Thymeleaf Dependency
  - **Requirements:** FR-1, NFR-1
  - **Description:** Add `spring-boot-starter-thymeleaf` dependency to `pom.xml` to enable Thymeleaf templating engine
  - **Files:** `pom.xml`
  - **Acceptance Criteria:**
    - Thymeleaf starter dependency added to pom.xml
    - Maven build completes successfully (`mvnw clean compile`)
    - Thymeleaf dependency appears in project classpath

- [x] 2. Create Event Model
  - **Requirements:** FR-3, FR-4, NFR-3
  - **Description:** Create `Event` Java record class in the model package to represent event data with immutable fields
  - **Files:** `src/main/java/com/example/demo/model/Event.java`
  - **Acceptance Criteria:**
    - Event record created with fields: name (String), date (String), location (String), description (String)
    - File compiles without errors
    - Record follows Java record syntax and conventions

- [x] 3. Implement Home Controller
  - **Dependencies:** 1, 2
  - **Requirements:** FR-1, FR-3, FR-4, NFR-3
  - **Description:** Create Spring MVC controller with GET endpoint for homepage that creates 3-4 hardcoded sample events and adds them to the model
  - **Files:** `src/main/java/com/example/demo/controller/HomeController.java`
  - **Acceptance Criteria:**
    - HomeController class created with @Controller annotation
    - GET mapping for "/" endpoint implemented
    - Method creates at least 3 sample Event instances with varied data
    - Events added to Model with attribute name "events"
    - Method returns "index" view name
    - Code compiles successfully

- [x] 4. Create CSS Stylesheet
  - **Requirements:** NFR-2, NFR-3
  - **Description:** Create CSS file with professional styling for homepage layout, event cards, typography, and color scheme
  - **Files:** `src/main/resources/static/css/styles.css`
  - **Acceptance Criteria:**
    - CSS file created in correct location
    - Styles defined for: body/container, header, event cards, footer
    - Professional color scheme applied (blues/grays recommended)
    - Appropriate spacing, padding, and margins defined
    - CSS is syntactically valid

- [x] 5. Create Thymeleaf Template
  - **Dependencies:** 3, 4
  - **Requirements:** FR-1, FR-2, FR-3, FR-5, NFR-2, NFR-3
  - **Description:** Create Thymeleaf HTML template with welcome section, event cards loop using th:each, and contact footer
  - **Files:** `src/main/resources/templates/index.html`
  - **Acceptance Criteria:**
    - Template created with proper HTML5 structure
    - Welcome section includes "EventPro" company name and tagline
    - Events section uses th:each to iterate over `${events}`
    - Each event card displays: name, date, location, description using Thymeleaf expressions
    - Contact section includes email, phone, and physical address
    - CSS stylesheet linked in <head> section
    - All Thymeleaf expressions are syntactically correct
    - HTML is well-formed and valid

- [x] 6. Write Controller Unit Tests
  - **Dependencies:** 3
  - **Requirements:** FR-1, FR-3, FR-4
  - **Description:** Create unit tests for HomeController using @WebMvcTest and MockMvc to verify view name, model attributes, and event data
  - **Files:** `src/test/java/com/example/demo/controller/HomeControllerTest.java`
  - **Acceptance Criteria:**
    - Test class created with @WebMvcTest(HomeController.class) annotation
    - Test 1: Verify controller returns "index" view name
    - Test 2: Verify model contains "events" attribute
    - Test 3: Verify events list has at least 3 items
    - All tests pass when running `mvnw test`
    - Tests use MockMvc for HTTP request simulation

## Notes

### Execution Strategy
**Phase 1 (Parallel):** Tasks 1, 2, and 4 can be executed concurrently as they have no dependencies.

**Phase 2 (Sequential):** Task 3 requires completion of tasks 1 and 2. Task 5 requires task 3 (and is enhanced by task 4).

**Phase 3 (Quality):** Task 6 requires task 3 for testing the controller.

### Final Verification Steps
After all tasks complete:
1. Run `mvnw clean test` - verify all tests pass
2. Run `mvnw spring-boot:run` - start the application
3. Navigate to `http://localhost:8080` - manually verify homepage displays correctly
4. Verify all acceptance criteria from requirements.md are met

### Technology Constraints
- Java 21 required
- Spring MVC for controller layer
- Thymeleaf for server-side templating
- CSS only (no JavaScript, TypeScript, or React)
- No database or authentication
