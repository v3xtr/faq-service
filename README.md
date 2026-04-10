# 📚 FAQ Microservice

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

A high-performance Knowledge Base and FAQ management microservice designed for the **Aviapic** ecosystem. This service is engineered using **Spring Boot 3.x** and **Java 21**, focusing on high availability, data consistency, and seamless integration within a distributed architecture.

---

## 🛠 Functional Features

### 1. Knowledge Base Management
* **Content Creation**: Dedicated endpoints for structured question and answer submission.
* **Rich Text Support**: Full support for Markdown/HTML content to deliver detailed technical guides.
* **Smart Retrieval**: Integrated search functionality to fetch all entries or filter by specific queries.

### 2. Intelligence & Search
* **Full-text Search**: High-speed retrieval using PostgreSQL, allowing users to find answers across datasets instantly.
* **Flexible Querying**: Support for optional search parameters to narrow down results.

### 3. Reliability & Validation
* **Strict Typing**: Leveraging Java's type system and UUIDs for robust data integrity.
* **Input Validation**: Utilizing `@Valid` and JSR-303 annotations to ensure data quality before persistence.

---

## 🏗 Technology Stack

* **Language:** Java 21 (LTS)
* **Framework:** Spring Boot 3.x
* **Data Layer:** Spring Data JPA & PostgreSQL
* **Security:** Spring Security & Jakarta Validation
* **Logging:** SLF4J with Lombok integration

---

## 🚀 Architectural Principles

* **Clean Architecture**: Strict separation of concerns across Delivery (HTTP), Application (Service), and Internal (Domain) layers.
* **DTO Pattern**: Utilization of specialized Data Transfer Objects to decouple API contracts from database schemas.
* **Error Handling**: Granular exception mapping (e.g., handling `IllegalArgumentException` for malformed UUIDs).

---

## 📡 API Endpoints (Quick Reference)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/faq` | Fetch all FAQ entries (optional `search` param) |
| `POST` | `/api/faq/question` | Create a new question entry |
| `POST` | `/api/faq/answer` | Bind a new answer to an existing question ID |

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