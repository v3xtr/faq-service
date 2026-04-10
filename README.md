# 📚 FAQ Microservice

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

A high-performance Knowledge Base and FAQ management microservice designed for the **Aviapic** ecosystem. This service is engineered using **Spring Boot 3.x** and **Java 21**, focusing on high availability, data consistency, and seamless integration within a distributed architecture.

---

## 🛠 Functional Features

### 1. Knowledge Base Management
* **Hierarchical Categorization**: Organizes support content into logical sections (e.g., Billing, Account Security, Flight Search).
* **Rich Text Support**: Full support for Markdown/HTML content to deliver detailed technical guides and documentation.
* **SEO-Optimized**: Automatic generation of unique, human-readable `slugs` for enhanced indexing.

### 2. Search & Intelligence
* **Full-text Search**: High-speed retrieval using PostgreSQL GIN indexes, allowing users to find answers across large datasets instantly.
* **Feedback System**: Integrated "Was this helpful?" rating system to measure content effectiveness.
* **Analytics**: Tracking view counts and popular queries to drive data-informed content updates.

### 3. Media & Cloud Storage
* **S3 Integration**: Native integration with S3-compatible storage (Beget/AWS) for managing diagrams and instructional media.
* **Path Management Logic**: Robust logic for automated file path formatting (e.g., `/products/`, `/faq/` prefixes).
* **Secure Access**: Implementation of time-limited Presigned URLs for secure asset delivery.

---

## 🏗 Technology Stack

* **Language:** Java 21 (LTS)
* **Framework:** Spring Boot 3.x
* **Data Layer:** Spring Data JPA & PostgreSQL
* **Migrations:** Flyway (Version control for database schema)
* **Messaging:** RabbitMQ (Event-driven processing for `user.created` events to provide predictive assistance)
* **Security:** Spring Security with RBAC (Role-Based Access Control)

---

## 🚀 Architectural Principles

* **Clean Architecture**: Strict separation of concerns across Web, Service, and Repository layers.
* **DTO Pattern**: Decoupling of persistence models from API contracts to ensure backward compatibility.
* **Global Exception Handling**: Centralized error management via `@ControllerAdvice` for standardized API error responses.
* **Resilience Patterns**: Configured Retry Policies and Dead Letter Queues (DLQ) to ensure robust message processing during downstream failures.

---

## 📡 API Endpoints (Quick Reference)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/faq` | Retrieve all categories and trending questions |
| `GET` | `/api/v1/faq/{slug}` | Fetch detailed article content |
| `GET` | `/api/v1/faq/search` | Execute full-text search across the KB |
| `POST` | `/api/v1/admin/faq` | Create new article (Admin only) |

---

## 📦 Getting Started

### Prerequisites
* JDK 21+
* Docker & Docker Compose

### Execution
```bash
# Build the application
./mvnw clean package

# Spin up the service and dependencies
docker-compose up -d faq-service