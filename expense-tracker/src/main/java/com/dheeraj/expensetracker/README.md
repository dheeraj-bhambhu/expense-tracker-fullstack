# Expense Tracker API

A RESTful Expense Tracker backend built with Spring Boot. It allows users to securely manage expenses, organize them into categories, set budgets, and monitor spending. Authentication is handled using JWT and the project follows clean layered architecture with unit testing.

---

## Features

### Authentication
- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization (USER, ADMIN)

### Expense Management
- Create Expense
- Update Expense
- Delete Expense
- Get Expense by ID
- Get All Expenses
- Search Expenses

### Category Management
- Create Category
- Update Category
- Delete Category
- Get All Categories

### Budget Management
- Create Budget
- Update Budget
- Delete Budget
- Get Budget
- Budget Validation

### Security
- Spring Security
- JWT Authentication
- Role-Based Access
- Password Encryption

### Validation & Exception Handling
- Bean Validation
- Global Exception Handling
- Custom Exception Messages

### API Documentation
- Swagger UI (OpenAPI)

### Testing
- Unit Testing using JUnit 5
- Mockito for Service Layer Testing

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT
- Lombok
- Maven
- Swagger/OpenAPI
- JUnit 5
- Mockito

---

## Project Structure

```
src
├── controller
├── service
├── service/impl
├── repository
├── entity
├── dto
├── security
├── config
├── exception
├── util
└── test
```

---

## API Endpoints

### Authentication
- POST /api/auth/register
- POST /api/auth/login

### Expenses
- POST /api/expenses
- GET /api/expenses
- GET /api/expenses/{id}
- PUT /api/expenses/{id}
- DELETE /api/expenses/{id}

### Categories
- POST /api/categories
- GET /api/categories
- PUT /api/categories/{id}
- DELETE /api/categories/{id}

### Budgets
- POST /api/budgets
- GET /api/budgets
- PUT /api/budgets/{id}
- DELETE /api/budgets/{id}

---

## Running the Project

1. Clone the repository

```bash
git clone <repository-url>
```

2. Configure MySQL in `application.properties`

3. Run the application

```bash
mvn spring-boot:run
```

---

## Running Tests

```bash
mvn test
```

---

## Future Improvements

- Docker Support
- Docker Compose
- Deployment
- CI/CD Pipeline
- Integration Testing

---

## Author

**Dheeraj Bhambhu**