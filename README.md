
<p align="center">
  <img src="https://d9hhrg4mnvzow.cloudfront.net/lp.3035tech.com/96c1669d-logo-teach-horiz-branco_1000000000000000000028.png" alt="3035tech Logo" width="200"/>
</p>

# CRUD Library API


A simple Java REST API to manage a library system with basic CRUD operations.  
Built with **Spring Boot**, following best practices like layered architecture, DTO usage, and Swagger for documentation.

## Features

- Create, read, update, and delete (CRUD) operations for book entities.
- Clean and maintainable code using:
  - Controller, Service, Repository layers.
  - Data Transfer Objects (DTOs).
- Auto-generated API documentation with Swagger UI.
- Easy to extend and understand — perfect for learning Spring Boot basics.

## Technologies

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (or your choice)
- Swagger (Springdoc OpenAPI)
- Maven

## Endpoints Overview

Base URL: `http://localhost:8080`
| Method | Endpoint      | Description                        |
|--------|---------------|------------------------------------|
| GET    | `/books`      | Retrieves all books                |
| GET    | `/books/{id}` | Retrieves a book by its ID         |
| POST   | `/books`      | Creates a new book                 |
| PUT    | `/books/{id}` | Fully updates a book by its ID     |
| PATCH  | `/books/{id}` | Partially updates the book's title |
| DELETE | `/books/{id}` | Deletes a book by its ID           |

## Swagger API Docs

After running the application, you can access the Swagger UI at:


This documentation is automatically generated and helps test your API easily.

## What I Learned

This project helped me understand and practice:

- Setting up a Spring Boot project
- Building RESTful APIs using layered architecture
- Applying DTOs for cleaner and decoupled code
- Documenting endpoints with Swagger
- Using Maven for project management
- Organizing packages and writing unit tests

## How to Run

```bash
# Clone this repository
git clone https://github.com/Felipecardosovargas/crud.git
cd crud

# Run with Maven
./mvnw spring-boot:run

