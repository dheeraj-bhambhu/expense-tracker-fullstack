# 💰 Expense Tracker API

A secure RESTful Expense Tracker API built with **Java, Spring Boot, Spring Security, JWT Authentication, MySQL, Hibernate, and JPA**. It allows users to manage expenses, categories, and monthly budgets with secure authentication.

---

## 🚀 Features

### 🔐 Authentication
- User Registration
- User Login
- JWT Authentication
- Password Encryption using BCrypt
- Protected APIs using Spring Security

### 💸 Expense Management
- Create Expense
- Get All Expenses
- Get Expense by ID
- Update Expense
- Delete Expense

### 📂 Category Management
- Create Category
- Get All Categories
- Get Category by ID
- Update Category
- Delete Category

### 💰 Budget Management
- Set Monthly Budget
- View Budget Summary
- Total Amount Spent
- Remaining Budget Calculation

### ⚠️ Exception Handling
- Global Exception Handling
- Validation Error Handling
- Resource Not Found Exception
- Duplicate Resource Exception
- Standard Error Response

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- MySQL
- Maven
- Lombok
- Bean Validation
- Postman
- Git & GitHub

---

## 📁 Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── repository
 ├── security
 └── service
```

---

## 🔑 Authentication Flow

1. Register User
2. Login
3. Receive JWT Token
4. Add Token in Authorization Header

```
Authorization: Bearer <your_token>
```

5. Access Protected APIs

---

## 📌 Expense APIs

| Method | Endpoint |
|----------|----------------|
| POST | /expenses |
| GET | /expenses |
| GET | /expenses/{id} |
| PUT | /expenses/{id} |
| DELETE | /expenses/{id} |

---

## 📌 Category APIs

| Method | Endpoint |
|----------|----------------|
| POST | /categories |
| GET | /categories |
| GET | /categories/{id} |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |

---

## 📌 Budget APIs

| Method | Endpoint |
|----------|----------------|
| POST | /budget |
| GET | /budget |

---

## 🧪 Tested Using

- Postman

---

## 📷 Sample Budget Response

```json
{
    "monthlyBudget": 5000.0,
    "spentAmount": 500.0,
    "remainingAmount": 4500.0
}
```

---

## ⚙️ Installation

Clone the repository

```bash
git clone https://github.com/your-username/expense-tracker.git
```

Go to project directory

```bash
cd expense-tracker
```

Build project

```bash
mvn clean install
```

Run project

```bash
mvn spring-boot:run
```

---

## 📌 Upcoming Features

- Expense Analytics
- Custom Queries
- Swagger Documentation
- Docker
- Deployment

---

## 👨‍💻 Author

**Dhiraj Bhambhu**

GitHub:
https://github.com/dhirajbhambhu

LinkedIn:
https://www.linkedin.com/in/dheeraj-bhambhu