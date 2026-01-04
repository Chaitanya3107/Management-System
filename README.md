# Bike Parts Inventory & POS System 🏍️

A centralized management platform designed for manage shops to streamline stock tracking, pricing, and automated billing.

## 🚀 Overview
This application replaces manual bookkeeping with a digital solution. It allows shop owners to manage their inventory in real-time and generate professional bills for customers while automatically updating stock levels.

## 🛠️ Tech Stack
- **Backend:** Java 17+, Spring Boot, Spring Data JPA
- **Database:** PostgreSQL
- **Frontend:** Next.js (React), Tailwind CSS (Upcoming)
- **API Style:** RESTful API

## ✨ Key Features
- **Inventory Management:** Full CRUD operations for bike parts (Name, Brand, Price, Stock).
- **Stock Control:** Automated stock deduction upon sale and low-stock indicators.
- **Billing System:** Generate bills with multiple line items, automated total calculation, and price-at-sale persistence.
- **Robust Logic:** Transactional safety to prevent data mismatch and a global error handler for "Out of Stock" scenarios.

## 🏗️ Database Schema
The system uses a relational schema to ensure data integrity:
- `parts`: Master inventory list.
- `bills`: Header information for sales (Date, Total Price).
- `sale_items`: Granular details of each transaction (Quantity, Price at Sale).
