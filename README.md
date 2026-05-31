# RestAssuredTesting

A REST Assured test automation framework using Cucumber and TestNG for validating CRUD operations on the Petstore Swagger API (`https://petstore.swagger.io/v2`).

## Features

- **Cucumber BDD integration**: Scenarios written in Gherkin syntax for clarity and accessibility.
- **REST Assured**: Fluent HTTP client for making API requests and asserting response data.
- **TestNG Runner**: Runs Cucumber features with custom plugin reports.
- **Dynamic Test Data**: Automated request payload generation.

---

## Project Structure

```text
├── pom.xml                                      # Project dependencies & build config
├── src/test/java/
│   ├── data/
│   │   └── MockDataGenerator.java               # Dynamic payload mock data helper
│   ├── features/
│   │   └── petstore_scenario.feature            # BDD scenario definitions (Create, Read, Update, Delete)
│   ├── stepdefinitions/
│   │   └── MyStepdefs.java                      # REST Assured step definitions matching Gherkin steps
│   └── testrunner/
│       └── CucumberDriver.java                  # TestNG Cucumber Runner config
```

---

## Getting Started

### Prerequisites

- **Java JDK 26** or higher
- **Apache Maven 3.9** or higher

### Running the Tests

To compile and run the full Cucumber test suite, execute:

```bash
mvn clean test
```

### Viewing Reports

Upon execution completion, reports are generated under the `reports/` directory:
- **HTML Report**: `reports/CucumberReport.html`
- **JSON Report**: `reports/CucumberReport.json`
- **JUnit XML Report**: `reports/CucumberReport.xml`
