# Automatic Irrigation System

### **POC Description**

-----
Building an Irrigation System where users can
- **Create Plot Of land.**
- **Configure a plot of land.**
- **Edit a plot of land.**
- **List all plots and it's details.**
- **Integration interface with the sensor device once a plot of land
  need to be irrigate.**
- **Update the status of the slot once the request is successfully sent
  to the sensor device.**
- **Retry calls to the sensor device in case the sensor not available
  (pre configured.**
- **Alerting system to be implemented in case the sensor not
  available and after exceeding the retry times.**

### Documentation For RESTful Api Usage (Resources and Endpoints)

📧 https://documenter.getpostman.com/view/28448487/2sAYQgg7vq

### ⚙ Used Technologies ⚙

---
* Java version 17 from (**Eclipse Adoptium**)
* Spring Boot Version (3.3.2)
* Spring Data JPA
* Apache Maven version (**3.9.3**)
* Tomcat Server (Embedded Server)
* Spring Bean Validation
* JSON-B for Binding
* Postman to test APIs
* Postgresql Database
* Liquibase As Database Migration Tool
### 🛠 Work With Maven(software project management)

---
* Configure the pom.xml file
* Deploy the application using maven with spring-boot plugin and tomcat web container.

for generating the jar file and running all test cases we can use this command

`mvn clean package spring-boot:run` used to generate the jar file
and deploy it automatically into Tomcat Web server.




### Postgresql DataBase

---
* you need to create database **irrigation_system** and adding the credentials into the **application.properties** file
* Adding the configuration of datasource into the application.properties file (connection String, username, password, Driver)
* Adding Liquibase Configuration to apply the changesets when the application starts.



- Try
  `mvn clean spring-boot:run` to run the application



------
### My  Accounts (LINKEDIN, HACKERRANK)

[LinkedIn Account](https://www.linkedin.com/in/abdallah96)


[HackerRank Account](https://www.hackerrank.com/profile/abdallahsameer22)

