
#  Selenium Java Automation Framework (SauceDemo)

This project is a robust, end-to-end UI automation framework built to test the SauceDemo website using modern Java-based test automation practices.

---


## Author

**Manasa T S**  
QA Engineer

---

##  Tech Stack

| Tool | Purpose |
|------|---------|
| **Java 11** | Programming Language |
| **Maven** | Dependency & build management |
| **Selenium WebDriver** | UI automation |
| **Cucumber** | BDD syntax |
| **TestNG** | Test execution engine |
| **ExtentReports** | Rich HTML reporting |
| **Log4j** | Logging |
| **Azure DevOps** | CI/CD execution |
| **GitHub** | Code hosting and version control |

---

##  Project Structure

```
Exact_Automation_Assesment/
├── src/
│   ├── main/java/utility/           # WebDriver setup, browser config, reusable functions
│   └── test/java/
│       ├── stepDefinitions/         # Step definitions linked to feature files
│       ├── testRunners/             # TestNG+Cucumber runner class
│       └── utility/                 # Hooks, TestReporter, config utils
├── src/test/resources/features/    # Gherkin-style feature files
├── test-output/ExtentReports/      # Extent HTML report output
├── azure-pipelines.yml             # CI pipeline for Azure DevOps
├── pom.xml                         # Project dependencies and build plugins
└── README.md
```

---

## How to Run Tests Locally

### Pre-requisites

- Java 11 installed
- Maven installed
- Chrome or Firefox installed
- IDE (e.g. IntelliJ, Eclipse)

### Run with Chrome UI

mvn clean verify -Dbrowser=chrome -Dheadless=false

### Run in Headless Mode (for CI/CD)

mvn clean verify -Dbrowser=chrome -Dheadless=true


> Supports both Chrome and Firefox (modify browser param accordingly)


## Test Structure

### Feature File (Gherkin)
Located at: `src/test/resources/features/`
```gherkin
Feature: Login functionality
  Scenario: Login with valid credentials
    Given user is on SauceDemo login page
    When user enters valid username "standard_user" and password "secret_sauce"
    And clicks on login button
    Then user should be navigated to homepage
```

### Step Definitions
Located in `stepDefinitions/LoginSteps.java`, maps to steps from the feature.

### Page Objects
Located in `pages/`, encapsulates web locators and actions for maintainability.

---

## Test Report (ExtentReport)

After test execution, open the HTML report at:

```
test-output/ExtentReports/ExtentReport.html
```

This contains:
- Step-by-step logs
- Scenario results (pass/fail)
- Screenshots (attached manually via `TestReporter`)

---

## Azure DevOps CI/CD

### Steps to Use

1. Ensure `azure-pipelines.yml` is committed to project root
2. Create a pipeline in Azure DevOps using the **"Existing YAML file"** option
3. Choose branch: `main`, YAML file path: `azure-pipelines.yml`
4. Pipeline runs on each push and publishes:

    - Test results
    - ExtentReport.html as artifact

### Re-run Pipeline

You can re-run the pipeline from the Azure DevOps UI or by pushing new commits.

---

## Pipeline Artifact Access

1. After pipeline completes, Navigate to Job
2. Under **Artifacts**, click `ExtentReport`
3. Download `.zip` → open `ExtentReport.html`

To ensure it’s always published, `azure-pipelines.yml` uses:

```yaml
- task: PublishPipelineArtifact@1
  condition: always()
  inputs:
    targetPath: 'test-output/ExtentReports'
    artifact: 'ExtentReport'
```

