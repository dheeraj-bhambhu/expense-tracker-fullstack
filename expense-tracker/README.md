# Expense Tracker API

A RESTful Expense Tracker backend built using **Spring Boot** that enables users to securely manage expenses, categories, and budgets. The project implements JWT authentication, role-based authorization, Swagger documentation, unit testing, and Docker containerization.

---

## Features

### Authentication & Authorization

* User Registration
* User Login
* JWT Authentication
* BCrypt Password Encryption
* Role-Based Authorization (USER, ADMIN)

### Expense Management

* Create Expense
* Update Expense
* Delete Expense
* Get Expense by ID
* Get All Expenses
* Search Expenses

### Category Management

* Create Category
* Update Category
* Delete Category
* Get All Categories

### Budget Management

* Create Budget
* Update Budget
* Delete Budget
* Get Budget
* Budget Validation

### Security

* Spring Security
* JWT Authentication
* Password Encryption
* Role-Based Access Control

### Validation & Exception Handling

* Bean Validation
* Global Exception Handling
* Custom Exception Handling

### API Documentation

* Swagger UI (OpenAPI)

### Testing

* JUnit 5
* Mockito
* Service Layer Unit Testing

### Docker

* Dockerized Spring Boot Application
* Custom Dockerfile
* Docker Image Creation
* Containerized Application Execution

---

# Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL
* JWT
* Maven
* Lombok
* Swagger (OpenAPI)
* JUnit 5
* Mockito
* Docker
* Git
* GitHub

---

# Project Structure

```
expense-tracker
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
├── target
├── Dockerfile
├── pom.xml
└── README.md
```

---

# API Endpoints

## Authentication

* POST /api/auth/register
* POST /api/auth/login

## Expenses

* POST /api/expenses
* GET /api/expenses
* GET /api/expenses/{id}
* PUT /api/expenses/{id}
* DELETE /api/expenses/{id}

## Categories

* POST /api/categories
* GET /api/categories
* PUT /api/categories/{id}
* DELETE /api/categories/{id}

## Budgets

* POST /api/budgets
* GET /api/budgets
* PUT /api/budgets/{id}
* DELETE /api/budgets/{id}

---

# Running the Project

## Clone Repository

```bash
git clone <repository-url>
cd expense-tracker
```

## Configure Database

Update the MySQL configuration in:

```
src/main/resources/application.properties
```

## Run Using Maven

```bash
./mvnw spring-boot:run
```

---

# Running Tests

```bash
./mvnw test
```

---

# Docker

## Build Docker Image

```bash
docker build -t expense-tracker .
```

## Run Docker Container

```bash
docker run -d --name expense-tracker-container -p 8080:8080 --add-host=host.docker.internal:host-gateway expense-tracker
```

## Check Running Containers

```bash
docker ps
```

## Stop Container

```bash
docker stop expense-tracker-container
```

## Start Container

```bash
docker start expense-tracker-container
```

## Remove Container

```bash
docker rm -f expense-tracker-container
```

---

# Future Improvements

* Docker Compose
* Cloud Deployment
* CI/CD Pipeline
* Integration Testing
* Redis Caching

---

# Author

**Dhiraj Bhambhu**
