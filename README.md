# Array of Hope — Job Finder 🔍💼

A full-stack **Java** job-portal application that lets employers post jobs, applicants search & apply, and admins keep everything running smoothly.  
Built entirely with **free, open-source tools** (Java Swing, Spring Boot, SQLite) and designed to be **production-ready**, secure, and easy to extend.

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=spring)  
![SQLite](https://img.shields.io/badge/SQLite-3.x-lightgrey?logo=sqlite)  
![License](https://img.shields.io/badge/license-MIT-yellow)

---

## Table of Contents
1. [Key Features](#key-features)  
2. [Architecture](#architecture)  
3. [Tech Stack](#tech-stack)  
4. [Getting Started](#getting-started)  
5. [Project Structure](#project-structure)  
6. [Running the App](#running-the-app)  
7. [API Reference](#api-reference)  
8. [Testing](#testing)  
9. [Roadmap](#roadmap)  
10. [Contributing](#contributing)  
11. [License](#license)

---

## Key Features
- **Role-Based Access** — Admin, Employer (Job Poster), and Applicant logins.
- **Secure Auth** — JWT-protected endpoints; passwords hashed with BCrypt.
- **Job Management** — Post, edit, delete, filter, and schedule job postings.
- **Resume Uploads** — Files stored locally in `/resumes/`.
- **Dark, Responsive UI** — Java Swing with a professional look & feel.
- **Custom Data Structures** — `ArrayBag<T>`, Priority Queues, Sorting utilities.
- **Self-Contained DB** — Lightweight SQLite for zero-config local setup.
- **API Docs** — Interactive Swagger UI at `/swagger-ui.html`.
- **100 % Free to Run** — No paid services; deployable on free tiers (Render, Fly.io, etc.).

---

## Architecture

> **Desktop UI** runs locally as a JAR; it calls the **Spring Boot** backend (also local or cloud-hosted), which persists data in **SQLite**. Separation keeps the UI snappy while letting the backend scale or move to the cloud later.

---

## Tech Stack

| Layer        | Technology                       | Why?                                   |
|--------------|----------------------------------|----------------------------------------|
| UI           | Java Swing (JDK 21)              | Native desktop look, zero browser lag  |
| State Mgmt   | Custom MVC + Observer pattern    | Lightweight, no external libs          |
| Backend      | Spring Boot 3, Spring Security   | Rapid REST APIs, robust auth           |
| DB           | SQLite 3 (JDBC)                  | Serverless, portable                   |
| AuthN/AuthZ  | JWT, BCrypt                      | Stateless, secure                      |
| Testing      | JUnit 5, Mockito                 | Unit/integ tests                       |
| Docs         | Swagger-UI (springdoc-openapi)   | Live API playground                    |

---

## Getting Started

### Prerequisites
- **JDK 21**  
- **Maven 3.9+**  
- **Git**  
- (Optional) **Docker** if you prefer containerized runs

###Project Structure  
  ArrayOfHope/
├── backend/                     
│   ├── src/main/java/com/arrayofhope/backend
│   │   ├── config/              # Security & DB configs
│   │   ├── controller/          # REST endpoints
│   │   ├── service/             # Business logic
│   │   ├── repository/          # JPA repositories
│   │   └── BackendApplication.java
│   └── src/main/resources/
│       └── application.properties
├── desktop/                     
│   └── src/main/java/
│       ├── ui/auth/             # Login, Register, ForgotPwd
│       ├── ui/main/             # Dashboards
│       ├── ui/views/            # PostJob, ViewJobs...
│       ├── data/                # DAO (JDBC)
│       ├── model/               # POJOs
│       ├── util/                # SessionManager, Helpers
│       └── Main.java
├── resumes/                     # Uploaded files
└── README.md

### 1️⃣ Clone
```bash
git clone https://github.com/your-handle/ArrayOfHope.git
cd ArrayOfHope
---
cd backend
mvn clean package
mvn spring-boot:run
---
cd desktop
mvn clean package
java -jar target/ArrayOfHope-desktop.jar
---


