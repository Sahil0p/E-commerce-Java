# E-Commerce Application
A full-stack Java E-Commerce web application built using Spring Boot, Thymeleaf, and an H2 in-memory database.
## Prerequisites
Before you begin, ensure you have met the following requirements:
* **Java 17**: Ensure you have JDK 17 installed.
* **Maven**: Ensure you have Apache Maven installed (or you can use the Maven wrapper if included).
* **Tomcat** (Optional): If you wish to deploy the `.war` file, you will need Apache Tomcat.
## Tech Stack
* **Backend**: Java 17, Spring Boot 2.7.x
* **Frontend**: HTML, Thymeleaf
* **Database**: H2 Database (In-Memory)
* **Data Access**: Spring Data JPA
* **Build Tool**: Maven
## Getting Started
Follow these steps to get your development environment set up.
### 1. Clone the repository
```bash
git clone <your-repository-url>
cd e-commerce
```
2. Build the project
You can build the project and package it into a .war file using Maven:

bash
mvn clean install
Note: This will also run the automated tests.

3. Running the application locally
Since this is a Spring Boot application, you can run it directly from your terminal:

bash
mvn spring-boot:run
The application will start up on http://localhost:8080.

4. Accessing the H2 Database Console
Because this project uses an in-memory H2 database, the data is stored only while the application is running. You can view the database console (if enabled in your application.properties) by navigating to:

URL: http://localhost:8080/h2-console
JDBC URL: Check your application.properties (typically jdbc:h2:mem:testdb)
5. Deployment (Tomcat)
This project is packaged as a .war file (ecommerce-app.war) located in the /target directory after a successful build.

To deploy:

Copy the target/ecommerce-app.war file.
Paste it into the /webapps directory of your Apache Tomcat installation.
Start the Tomcat server. The app will be available at http://localhost:8080/ecommerce-app.
