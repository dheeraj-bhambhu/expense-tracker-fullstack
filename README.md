# Expense Tracker Backend

A RESTful Expense Tracker API built using Spring Boot and MySQL. This project helps users manage expenses through CRUD operations and serves as the backend foundation for a full-stack expense tracking application.

## 🚀 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* Maven

## 📁 Project Structure

src/main/java/com/dheeraj/expensetracker

├── controller

├── service

├── repository

├── entity

├── security

├── exception

├── config

└── dto

## ✅ Features Implemented

### Expense Management

* Create Expense
* Get All Expenses
* Get Expense By ID
* Update Expense
* Delete Expense

### Database

* MySQL Integration
* Hibernate ORM
* Auto Table Creation using JPA

## 📌 API Endpoints

### Create Expense

POST /expenses

Request Body:

```json
{
  "title": "Pizza",
  "amount": 250,
  "description": "Dominos Pizza"
}
```

### Get All Expenses

GET /expenses

### Get Expense By ID

GET /expenses/{id}

### Update Expense

PUT /expenses/{id}

```json
{
  "title": "Burger",
  "amount": 300
}
```

### Delete Expense

DELETE /expenses/{id}

## 🗄️ Database Schema

### Expense

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| title       | String    |
| amount      | Double    |
| description | String    |
| date        | LocalDate |

## 🧪 Testing

All APIs tested successfully using Postman.

* Create Expense ✅
* Get Expense By ID ✅
* Update Expense ✅
* Delete Expense ✅

## 🔜 Upcoming Features

* User Management
* Authentication & Authorization
* JWT Security
* Role-Based Access Control
* Expense Categories
* Dashboard Analytics
* React Frontend

## 👨‍💻 Author

Dhiraj Bhambhu

* GitHub: https://github.com/dheeraj-bhambhu
* LinkedIn: https://www.linkedin.com/in/dhiraj-bhambhu/
