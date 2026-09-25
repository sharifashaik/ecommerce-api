🛒 E-Commerce REST API
A robust backend RESTful API for an e-commerce platform built with Java and Spring Boot, supporting product management, user authentication, shopping cart features, and order processing.

✨ Features
🔐 User Authentication & Authorization: Secure JWT-based authentication with role-based access control (Admin / Customer) via Spring Security.

📦 Product Management: Full CRUD operations for products, category filtering, and inventory tracking using Spring Data JPA.

🛒 Shopping Cart: Add, update, or remove items from the shopping cart seamlessly.

💳 Order Processing: Complete checkout workflow, order placement, and status tracking.

🛢️ Database Integration: Relational database persistence using JPA/Hibernate.

🛠️ Tech Stack
☕ Language: Java 17+

🍃 Framework: Spring Boot

🔒 Security: Spring Security & JSON Web Tokens (JWT)

💾 Persistence: Spring Data JPA / Hibernate

🛢️ Database: PostgreSQL / MySQL

🔨 Build Tool: Maven / Gradle
🔌 API Endpoints
🔐 Authentication
POST /api/auth/register - Register a new user 👤

POST /api/auth/login - Authenticate user & receive JWT token 🔑

📦 Products
GET /api/products - Fetch all products 🛍️

GET /api/products/{id} - Fetch product details by ID 🔎

POST /api/products - Add a new product (Admin only) ➕

PUT /api/products/{id} - Update product details (Admin only) ✏️

DELETE /api/products/{id} - Delete a product (Admin only) ❌

🛒 Cart & Orders
GET /api/cart - View shopping cart 🛒

POST /api/cart/items - Add item to cart ➕

POST /api/orders - Checkout and place an order 💳

GET /api/orders/my-orders - Fetch current user's order history 📋
