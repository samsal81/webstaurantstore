##  Project:  Webstaurant Store Test Automation

This is the README file for the project Webstaurant Store Test Automation. 

**Description:**  Testing the search and adding to/emptying cart. 

**Requirements:**

* Java 1.8 or later
* Apache Maven 3

**Getting Started:**

1. Clone the project:

```
git clone https://github.com/your-username/your-project-name.git
```
2. Navigate to the project directory:

```
cd your-project-name
```
3. Install dependencies:

```
mvn install
```

**Building the Project:**

```
mvn package
```

This will create a JAR file in the `target` directory.

**Dependencies:**

* Selenium Java: [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) (version 3.141.59)
* WebDriverManager: [https://github.com/bonigarcia/webdrivermanager](https://github.com/bonigarcia/webdrivermanager) (version 5.7.0)
* TestNG (test scope): [https://mvnrepository.com/artifact/org.testng/testng](https://mvnrepository.com/artifact/org.testng/testng) (version 6.14.3)


**Build Plugins:**

This project uses the following Maven plugins:

* maven-clean-plugin: cleans the project
* maven-resources-plugin: copies resources
* maven-compiler-plugin: compiles Java source code
* maven-surefire-plugin: runs tests
* maven-jar-plugin: creates JAR file
* maven-install-plugin: installs project artifacts
* maven-deploy-plugin: deploys project artifacts
* maven-site-plugin: generates project site
* maven-project-info-reports-plugin: generates project information reports
