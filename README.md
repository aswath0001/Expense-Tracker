💰 Expense Tracker
🚀 Implemented Functionality
1. User Management
✅ User Registration - Create new users with email validation
✅ Get All Users - Retrieve complete user list
✅ Get User by ID - Fetch specific user details
✅ Update User - Modify user information
✅ Delete User - Remove users (with relationship handling)

2. Expense Management
✅ Create Expenses - Add new expense records
✅ View All Expenses - Get complete expense history
✅ Expense by ID - Retrieve specific expense details
✅ Update Expenses - Modify existing expenses
✅ Delete Expenses - Remove expense records
✅ Date Range Filtering - Filter expenses by date ranges
✅ Title-based Search - Find expenses by title

3. Income Tracking
✅ Record Income - Add income entries
✅ View All Income - Get complete income history
✅ Income by ID - Retrieve specific income details
✅ Update Income - Modify income records
✅ Delete Income - Remove income entries

4. Split Expense System
✅ Create Splits - Divide expenses among users
✅ View All Splits - See all expense divisions
✅ Get Split by ID - Retrieve specific split details
✅ Settle Splits - Mark splits as paid/processed
✅ Delete Splits - Remove split records
✅ Payer-based Filtering - Find splits by who owes money
✅ Payee-based Filtering - Find splits by who receives money

5. Balance Management
✅ Automatic Balance Updates - Real-time balance calculations
✅ Balance Tracking - Current balance for each user
✅ Transaction History - Complete financial tracking

🗄️ Database Structure
Core Tables:
user - User accounts with balance tracking

expense - Expense records with categories and dates

income - Income records with categorization

split_expense - Expense division between users

expense_participant - Track participants in splits

Key Relationships:
Users can create multiple expenses

Expenses can be split among multiple users

Automatic balance synchronization

Referential integrity with foreign keys

📋 Available API Endpoints
Users (/api/user)
POST / - Create new user

GET / - Get all users

GET /{id} - Get user by ID

PUT /{id} - Update user

DELETE /{id} - Delete user

Expenses (/api/expense)
POST / - Create expense

GET / - Get all expenses

GET /{id} - Get expense by ID

GET /title/{title} - Search by title

GET /filter - Filter by date range

PUT /{id} - Update expense

DELETE /{id} - Delete expense

Split Expenses (/api/split-expense)
POST / - Create split expense

GET / - Get all splits

GET /{id} - Get split by ID

GET /payer/{id} - Get splits by payer

GET /payee/{id} - Get splits by payee

PUT /{id} - Update split

DELETE /{id} - Delete split

Income (/api/income)
POST / - Create income record

GET / - Get all income

GET /{id} - Get income by ID

PUT /{id} - Update income

DELETE /{id} - Delete income

🎯 Technical Features
Backend:
Spring Boot 3.x - Modern Java framework

Spring Data JPA - Database management

MySQL Integration - Production-ready database

RESTful APIs - Clean, standardized endpoints

CORS Enabled - Cross-origin support

Error Handling - Comprehensive exception management

Data Management:
Auto-increment IDs - Proper primary key management

Foreign Key Constraints - Data integrity enforcement

Transaction Management - Atomic operations

Lazy Loading - Performance optimization

JSON Serialization - Clean API responses

Validation:
Unique Email Enforcement - Prevent duplicate accounts

Data Type Validation - Proper field validation

Relationship Integrity - Prevent orphaned records

Balance Consistency - Financial data accuracy

🔄 Workflow Example
User creates expense: ₹1000 dinner

Split among friends: 3 people × ₹333.33 each

Automatic balance update:

Payer balance: -₹333.33

Payee balance: +₹333.33

Settlement: Mark splits as paid when settled

🚦 Ready for Production
✅ Database migrations - Automatic schema updates
✅ Error handling - Proper HTTP status codes
✅ Input validation - Data integrity checks
✅ Performance optimized - Efficient database queries
✅ Scalable architecture - Ready for more users
This is a fully functional expense tracker with all core features implemented and tested!
