# La Coquette eCommerce Website

A full-stack fashion eCommerce web application built with **Angular**, **Spring Boot**, and **MySQL**. This project demonstrates the core functionalities of an online shopping platform through a modern, responsive customer interface.

---

# Project Overview

**La Coquette** is a fashion eCommerce platform that allows users to browse products, view product details, manage their shopping cart, complete the checkout process, and review their order history.

This project currently focuses on the **customer-side experience**, providing a functional shopping workflow while serving as a foundation for future enhancements such as an administrative dashboard and complete backend integration.

---

# Current Features

### Customer Side

- User Registration
- User Login & Authentication
- Responsive Home Page
- About Page
- Product Catalog
- Product Details Page
- Shopping Cart
- Checkout Page
- Order History
- Responsive User Interface

---

# Current Limitations

This project is primarily developed for the **customer side** of the application.

Although the frontend interface and backend services are operational, some features are currently intended for demonstration purposes and are **not yet fully integrated with the database**.

Examples include:

- Some customer transactions are not fully persisted.
- Certain frontend components use partially integrated backend functionality.
- The application currently does **not** include an administrator dashboard.

---

# Future Improvements

Planned enhancements include:

- Admin Dashboard
- Product Management
- Category Management
- Customer Management
- Order Management
- Inventory Management
- Sales Reports and Analytics
- Payment Gateway Integration
- Email Notifications
- Role-based Authentication and Authorization
- Complete database integration for all customer transactions

---

# Tech Stack

## Frontend

- Angular
- TypeScript
- HTML
- CSS

### Features

- Responsive User Interface
- Product Browsing
- Product Details
- Shopping Cart
- Checkout
- Order History

---

## Backend

- Spring Boot
- Java
- Maven
- REST API
- Hibernate / JPA

### Features

- User Authentication
- Product APIs
- Order APIs
- Database Connectivity

---

## Database

- MySQL

### Stores

- Customer Information
- Products
- Orders
- Order Items
- Payments
- Menu Data

---

# Project Structure

```
La-Coquette-Website
│
├── Database
│   ├── ecom_customers.sql
│   ├── ecom_hibernate_sequence.sql
│   ├── ecom_menu_data.sql
│   ├── ecom_order_item_data.sql
│   ├── ecom_orders.sql
│   ├── ecom_payments.sql
│   └── ecom_products.sql
│
├── ecommerce
│   └── Spring Boot Backend
│
└── Main Front
    └── Product
        └── Angular Frontend
```

---

# Getting Started

## Prerequisites

Before running the project, make sure the following software is installed:

- Java 17 or later
- Maven
- Node.js
- npm
- Angular CLI
- MySQL Server
- IntelliJ IDEA
- Visual Studio Code

---

# Database Setup

### 1. Start MySQL

Start your local MySQL server.

### 2. Create the Database

Run the following SQL command:

```sql
CREATE DATABASE ecom;
```

### 3. Import Database Files

Import all SQL files located in the **Database** folder.

Recommended import order:

1. ecom_hibernate_sequence.sql
2. ecom_products.sql
3. ecom_customers.sql
4. ecom_orders.sql
5. ecom_order_item_data.sql
6. ecom_payments.sql
7. ecom_menu_data.sql

After importing, verify that all tables and sample data have been successfully created.

---

# Running the Backend

1. Open the **ecommerce** project using **IntelliJ IDEA**.

2. Open the built-in terminal.

3. Build the project:

```bash
mvn clean install
```

4. Start the Spring Boot application:

```bash
mvn spring-boot:run
```

Alternatively, you may run the `EcommerceApplication.java` file directly from IntelliJ.

The backend will run on:

```
http://localhost:8080
```

---

# Running the Frontend

1. Open the project using **Visual Studio Code**.

2. Navigate to the Angular frontend project.

```bash
cd "Main Front/Product"
```

3. Install the project dependencies.

```bash
npm install
```

4. Start the Angular development server.

```bash
ng serve
```

5. Open your browser and visit:

```
http://localhost:4200
```

---

# Technologies Used

### Frontend

- Angular
- TypeScript
- HTML
- CSS

### Backend

- Spring Boot
- Java
- Maven
- Hibernate / JPA
- REST API

### Database

- MySQL

### Development Tools

- IntelliJ IDEA
- Visual Studio Code
- Git
- GitHub

---

# Author

**Natalie Veluz**

This project was developed as a personal full-stack web development portfolio project to demonstrate proficiency in Angular, Spring Boot, Java, MySQL, RESTful API development, and modern web application architecture.
