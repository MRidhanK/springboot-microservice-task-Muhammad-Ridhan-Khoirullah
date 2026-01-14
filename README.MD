Simple Book Management Microservice
Candidate: Muhammad Ridhan Khoirullah
Role: Junior Java Developer
Architecture: RESTful Microservice
Language: Java
Framework: Spring Boot
Build Tool: Maven
Database: PostgreSQL

1. Project Overview
This project is a Simple Book Management Microservice implemented using Spring Boot.
The service exposes RESTful APIs to perform full CRUD operations on a Book resource.
This project demonstrates:
REST API design following HTTP standards
Layered architecture (Controller → Service → Repository)
Database persistence using Spring Data JPA
PostgreSQL integration
Basic DevOps workflow using Git

2. Project Architecture
The application follows a standard layered architecture:
Controller Layer  ->  Service Layer  ->  Repository Layer  ->  Database
Layer Responsibilities:
Controller: Handles HTTP requests and responses
Service: Contains business logic
Repository: Data access using Spring Data JPA
Entity: Maps database tables to Java objects

3. Project Structure
springboot-microservice-task-muhammad-ridhan-khoirullah
│
├── src/main/java/com/bookservice
│   ├── controller
│   │   └── BookController.java
│   │
│   ├── service
│   │   ├── BookService.java
│   │   └── BookServiceImpl.java
│   │
│   ├── repository
│   │   └── BookRepository.java
│   │
│   ├── entity
│   │   └── Book.java
│   │
│   └── BookserviceApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── docs
│   └── er-diagram.png
│
├── pom.xml
└── README.md
4. Entity Relationship Diagram (ER Diagram)
ER Diagram Preview
![ER Diagram](docs/er-diagram.png)
The project uses a single entity, which fully satisfies the assignment requirements.

5. Database Design
Entity: Book
Column	Data Type	Description
id	BIGSERIAL	Primary Key
title	VARCHAR(255)	Book title
author	VARCHAR(255)	Book author
isbn	VARCHAR(50)	Unique ISBN
published_date	DATE	Published date

6. PostgreSQL DDL Script
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) UNIQUE NOT NULL,
    published_date DATE
);

7. Application Configuration
application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookdb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

8. How to Run the Application

Prerequisites:
Java JDK 17+
Maven
PostgreSQL

Steps:
Create database
CREATE DATABASE bookdb;
Clone repository
git clone https://github.com/MRidhanK/springboot-microservice-task-Muhammad-Ridhan-Khoirullah.git
Navigate to project directory
cd springboot-microservice-task-muhammad-ridhan-khoirullah
Run application
mvn spring-boot:run

Access application:
http://localhost:8080

9. API Endpoints
HTTP Method	Endpoint	Description
POST	/api/books	Create new book
GET	/api/books	Retrieve all books
GET	/api/books/{id}	Retrieve book by ID
PUT	/api/books/{id}	Update entire book
PATCH	/api/books/{id}	Partial update (e.g. title only)
DELETE	/api/books/{id}	Delete book

10. Sample Request Payload
Create Book (POST)
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedDate": "2008-08-01"
}

11. Postman Testing
All API endpoints were tested using Postman.
Postman Collection:
(https://www.postman.com/login4-9184/workspace/simple-book-management-microservice)

12. Test Evidence
Screenshots or API simulation evidence:
[POSTMAN TESTING SCREENSHOTS HERE]

13. Git Workflow
Meaningful commit messages
Feature-based commits
Clean and readable repository structure


