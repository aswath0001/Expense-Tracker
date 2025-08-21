Expense Tracker

A robust, scalable, and production-ready expense tracking system built with Spring Boot and MySQL. It supports full financial tracking, user management, split expenses, and real-time balance calculations.

🚀 Features Overview
1. 👤 User Management

✅ User Registration – Create new users with email validation

✅ Get All Users – Retrieve full list of users

✅ Get User by ID – Fetch specific user details

✅ Update User – Modify user data

✅ Delete User – Remove users with relationship handling

2. 💸 Expense Management

✅ Create Expenses – Add new expense records

✅ View All Expenses – Full expense history

✅ Get Expense by ID – Retrieve specific expense

✅ Update Expenses – Modify existing records

✅ Delete Expenses – Remove records cleanly

✅ Date Range Filtering – Filter expenses by date

✅ Title-based Search – Find expenses by name/title

3. 💰 Income Tracking

✅ Record Income – Add income entries

✅ View All Income – Complete income log

✅ Get Income by ID – Specific income details

✅ Update Income – Edit income data

✅ Delete Income – Remove entries

4. 👥 Split Expense System

✅ Create Splits – Divide expenses among users

✅ View All Splits – See all divisions

✅ Get Split by ID – Fetch a specific split

✅ Settle Splits – Mark splits as settled

✅ Delete Splits – Remove records

✅ Payer-based Filtering – See what each user owes

✅ Payee-based Filtering – See what each user receives

5. 📊 Balance Management

✅ Automatic Balance Updates – Real-time balance changes

✅ User Balance Tracking – Current financial position

✅ Transaction History – Full record of income, expenses, and splits

🗄️ Database Structure
🔑 Core Tables

user – User accounts, balance tracking

expense – Expense records with categories and timestamps

income – Income records with source tracking

split_expense – Shared expenses across users

expense_participant – Links participants in splits

🔗 Key Relationships

Users can create multiple expenses and income entries

Expenses can be split between multiple users

Automatic balance sync between users

Referential integrity using foreign keys

🧠 Technical Architecture
⚙️ Backend

Spring Boot 3.x – Modern Java framework

Spring Data JPA – ORM and repository pattern

RESTful APIs – Clean, maintainable, scalable

CORS Enabled – Cross-origin resource sharing

Error Handling – Centralized and descriptive

🗃️ Database

MySQL – Relational database integration

Auto-increment IDs – Primary key management

Foreign Key Constraints – Referential integrity

Transaction Management – ACID-compliant operations

Lazy Loading – Efficient resource use

✅ Data Validation

Unique email enforcement

Proper data type validation

Foreign key constraints for relationships

Real-time balance sync logic

🔄 Workflow Example

A user creates an expense: ₹1000 Dinner

Split with 3 friends → ₹333.33 each

Automatic balance update:

Payer’s balance: -₹666.67

Each payee’s balance: +₹333.33

Splits are marked as settled when paid

🚦 Production-Ready Features

✅ Database migrations with schema updates

✅ Proper HTTP status codes & error responses

✅ Full input validation

✅ Optimized SQL queries via JPA

✅ Scalable codebase and modular design

🛠️ Getting Started
Prerequisites

Java 17+

Maven

MySQL Server

Setup Instructions

Clone the Repository

git clone https://github.com/aswath0001/expense-tracker.git
cd expense-tracker

Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Run the Application

mvn spring-boot:run

