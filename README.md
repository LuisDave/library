
# Library Management System

## Overview

This project is a Library Management System built using Spring Boot, allowing users to manage a collection of books. The system provides RESTful API endpoints to perform CRUD operations on the books.

## Features

- **Create a Book**: Add a new book to the library.
- **Get Book by ID**: Retrieve details of a book using its ID.
- **Update Book**: Modify details of an existing book.
- **Delete Book**: Mark a book as inactive.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger for API documentation
- JUnit and Mockito for testing

## Getting Started

### Prerequisites

- Java 17
- Maven
- MySQL

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/LuisDave/management.git
   cd library
   ```

2. **Setup MySQL Database**
   ```sql
   CREATE DATABASE library_db;
   ```

3. **Configure `application.properties`**

   Update the MySQL configurations in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
   ```

4. **Build and Run the application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access the API documentation**
   Open your browser and go to `http://localhost:8080/swagger-ui.html` to access the Swagger UI.

## Project Structure

- **`controller`**: Contains the REST controllers for handling HTTP requests.
- **`dto`**: Data Transfer Objects for transferring data between layers.
- **`model`**: Entity classes representing the database schema.
- **`repository`**: JPA repositories for database operations.
- **`service`**: Service layer containing business logic.
- **`validator`**: Classes for validating input data.
- **`testdata`**: Utility class for generating test data.

## API Endpoints

### Create a Book

- **URL**: `/books`
- **Method**: `POST`
- **Request Body**: `BookDTO`
- **Response**: `Book`

### Get Book by ID

- **URL**: `/books/{id}`
- **Method**: `GET`
- **Path Variable**: `id`
- **Response**: `Book`

### Update a Book

- **URL**: `/books/{id}`
- **Method**: `PUT`
- **Path Variable**: `id`
- **Request Body**: `BookDTO`
- **Response**: `Book`

### Delete a Book

- **URL**: `/books/{id}`
- **Method**: `DELETE`
- **Path Variable**: `id`
- **Response**: `204 No Content`

## Running Tests

To run the unit tests, use the following command:
```bash
mvn test
```

## Contribution

Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
