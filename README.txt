Test Automation Project
Overview
Welcome to the Test Automation Project!

The target website for this automation is Kristini-BG. While the website does not have many functionalities, the goal is to create a regression test suite that covers most of its features.

This project serves as an example of how an Automation Framework looks in a real-world company environment.

Technology Stack
We are using the following technologies:

Programming Language: Java
Automation Frameworks: Selenium + Cucumber
Project Management: Maven
Testing Library: TestNG
CI/CD: Jenkins
Continuous Integration with Jenkins
The project is integrated with Jenkins. A Jenkins Maven job runs all test cases under the KristiniRegression feature set. Additionally, Cucumber reports (including screenshots) are uploaded in Jenkins via a plugin.

Future Enhancements
Planned improvements include:

API Automation: Implementing REST API tests.
TestRail Integration: Creating Test Runs in TestRail and linking automated test cases to TestRail cases.
Automated Test Reporting: With TestRail + Jenkins, we aim to auto-update test results within TestRail, following a common industry practice.
Project Structure
The project is structured as follows:

Test Definitions & Features
📂 src/test/java/stepDefinitions/

Contains step definition files (Gherkin + Java code).
📂 src/test/resources/features/

Stores feature files written in Gherkin.
The Placeholder.feature file is used for testing newly implemented steps/test cases.
Test Runners
📂 src/test/java/runners/

Contains the MainRunner class.
Configures CucumberOptions (e.g., console output format, reporting to HTML).
Modules & Page Object Model (POM)
📂 src/main/java/modules/

Stores module classes that interact with step definitions.
📂 src/main/java/pages/
