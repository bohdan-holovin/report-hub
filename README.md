# ReportHub

## Table of Contents
- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Architecture](#architecture)
- [Tests](#tests)

## Introduction

RESTful API for managing companies and their financial reports. The service provides CRUD operations, JWT authentication and authorization, database migrations, API documentation, and automated tests.

## Technologies
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT(JSON Web Tokens)**
- **PostgreSQL** 
- **MongoDB**
- **Hibernate**
- **Liquibase**
- **Swagger**
- **JUnit**
- **Maven**
- **Docker**

## Architecture
The application follows Model-View-Controller architecture with clear separation of concerns. Key components include:
- **Controllers**: Handle HTTP requests and responses.
- **Services**: Contain business logic.
- **Repositories**: Interact with the database.
- **Security**: Configure authentication and authorization.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/bohdan-holovin/report-hub.git
cd report-hub
```

### Start the Databases

For a local build and run, start PostgreSQL and MongoDB first:

```bash
docker compose up -d postgres-db mongo-db
```

### Build the Project
To build the project, run the following command:
```bash
./mvnw clean package
```

### Run the Application
You can run the application locally using Maven or Docker Compose.

#### Using Maven
```bash
./mvnw spring-boot:run
```

#### Using Docker Compose
Ensure Docker is installed and running on your machine. Then, run the following command:
```bash
docker compose up --build
```

This command will start the application and all required services defined in the `docker-compose.yml` file.

#### API documentation
   Open your browser and navigate to `http://localhost:8080/swagger-ui.html`.

#### Using JWT Authentication
1. **Register a new user:**
    ```bash
    curl -X POST "http://localhost:8080/users" -H "Content-Type: application/json" -d '{"username":"testuser", "password":"password"}'
    ```
2. **Authenticate the user to receive a JWT token:**
    ```bash
    curl -X POST "http://localhost:8080/authenticate" -H "Content-Type: application/json" -d '{"username":"testuser", "password":"password"}'
    ```
   You will receive a JWT token in the response.

3. **Access secured endpoints using the JWT token:**
    ```bash
    curl -X GET "http://localhost:8080/companies" -H "Authorization: Bearer your_jwt_token"
    ```



## Tests

The project includes unit tests, MVC tests, and repository integration tests. PostgreSQL and MongoDB must be available for the full test suite.

```bash
./mvnw test
```
