# Cucumber-TestNG-BDD-Automation-Framework

## Behavior Driven Development Cucumber - Selenium based automation framework including Extent reports

This framework contains sample code containing:
```bash
  1 feature
  3 scenarios
```
## Directory structure:

![image](https://github.com/user-attachments/assets/69131b5f-70f4-4a7f-a254-20f9089e4e74)

## Steps to run at your system:
```bash
1. Clone the repository using "git clone"

2. Go to project directory from terminal and run following command
   "mvn clean test -DsuiteXmlFile=TestNG.xml" ( default will run in chrome browser )

To run tests in different browsers pass parameter values as below:
  Edge browser    -> -DbrowserName=edge
  Firefox browser -> -DbrowserName=firefox

To run tests in headless mode pass parameter value as below:
  "mvn clean test -DsuiteXmlFile=TestNG.xml -DbrowserName=edge -DheadlessMode=true"
```

```bash
 Run Cucumber TestRunner from src/test/java/runner/TestRunner
 ```
## Extent Report:
After test execution report will be generated in this folder "test-output/spark"

![image](https://github.com/user-attachments/assets/a405d1c0-a1b2-4d8d-8a3a-b64d7c29d330)

![image](https://github.com/user-attachments/assets/ff1a5291-4185-496e-9d52-3c582fdabc8e)

