# Simple Book Management Microservice

**Candidate:** Muhammad Ridhan Khoirullah  
**Role:** Junior Java Developer  

---

##  Project Overview

This project is a **Simple Book Management Microservice** built using **Spring Boot**.  
It exposes RESTful APIs to perform full **CRUD operations** on a **Book** resource.

The project demonstrates:

- REST API design following HTTP standards
- Layered architecture (Controller → Service → Repository)
- Database persistence using Spring Data JPA
- PostgreSQL integration
- Basic DevOps workflow using Git

---

##  Architecture

The application follows a standard **layered architecture**:

```
Controller Layer  →  Service Layer  →  Repository Layer  →  Database
```

### Layer Responsibilities

- **Controller**: Handles HTTP requests and responses  
- **Service**: Contains business logic  
- **Repository**: Data access using Spring Data JPA  
- **Entity**: Maps database tables to Java objects  

---

##  Project Structure

```
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
```

---

##  Entity Relationship Diagram (ERD)

![ER Diagram](src/img/ER_Diagram_Simple_Book_Management_Microservice.png)

This project uses a **single entity**, which fully satisfies the assignment requirements.

---

##  Database Design

### Entity: `Book`

| Column          | Data Type    | Description        |
|-----------------|-------------|--------------------|
| id              | BIGSERIAL   | Primary Key        |
| title           | VARCHAR(255)| Book title         |
| author          | VARCHAR(255)| Book author        |
| isbn            | VARCHAR(50) | Unique ISBN        |
| published_date  | DATE        | Published date     |

---

##  PostgreSQL DDL Script

```sql
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) UNIQUE NOT NULL,
    published_date DATE
);
```

---

##  Application Configuration

`application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookdb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

##  How to Run the Application

### Prerequisites

- Java JDK 17+
- Maven
- PostgreSQL

### Steps

1. **Create Database**
   ```sql
   CREATE DATABASE bookdb;
   ```

2. **Clone Repository**
   ```bash
   git clone https://github.com/MRidhanK/springboot-microservice-task-Muhammad-Ridhan-Khoirullah.git
   ```

3. **Navigate to Project Directory**
   ```bash
   cd springboot-microservice-task-muhammad-ridhan-khoirullah
   ```

4. **Run Application**
   ```bash
   mvn spring-boot:run
   ```

### Access Application

```
http://localhost:8080
```

---

##  API Endpoints

| HTTP Method | Endpoint              | Description              |
|------------|-----------------------|--------------------------|
| POST       | /api/books            | Create new book          |
| GET        | /api/books            | Retrieve all books       |
| GET        | /api/books/{id}       | Retrieve book by ID      |
| PUT        | /api/books/{id}       | Update entire book       |
| PATCH      | /api/books/{id}       | Partial update           |
| DELETE     | /api/books/{id}       | Delete book              |

---

##  Sample Request Payload

### Create Book (POST)

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedDate": "2008-08-01"
}
```

---

##  Postman Testing

All API endpoints were tested using **Postman**.

Postman Collection:  
https://www.postman.com/login4-9184/workspace/simple-book-management-microservice

---

##  Test Evidence

Screenshots or API simulation evidence:

```
### Add a New Book
![Add a New Book](src/img/Add_a_new%20book.png)

### Delete a Book
![Delete a Book](src/img/Delete_a_book.png)

### Get a Book by ID
![Get a Book by ID](src/img/Get_a_book_by_ID.png)

### Get All Books
![Get All Books](src/img/Get_all_books.png)

### Partial Update of a Book (Title Only)
![Partial Update Book](src/img/Partial%20update_of_a_book_(e.g.%20title%20only).png)

### Update Book by ID (Full Update)
![Update Book Full](src/img/Update__book_by_ID_(full%20update).png)

```

---

##  Git Workflow

- Meaningful commit messages  
- Feature-based commits  
- Clean and readable repository structure  

---

##  Conclusion

This project showcases a clean and maintainable **Spring Boot microservice** with proper architecture, database integration, and RESTful API design — suitable for a **Junior Java Developer** assessment.
