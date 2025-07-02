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
- **Secure Auth** — JWT‑protected endpoints; passwords hashed with BCrypt.
- **Job Management** — Post, edit, delete, filter, and schedule job postings.
- **Resume Uploads** — Files stored locally in `/resumes/`.
- **Dark, Responsive UI** — Java Swing with a professional look & feel.
- **Custom Data Structures** — `ArrayBag<T>`, Priority Queues, Sorting utilities.
- **Self‑Contained DB** — Lightweight SQLite for zero‑config local setup.
- **API Docs** — Interactive Swagger UI at `/swagger‑ui.html`.
- **100 % Free to Run** — No paid services; deployable on free tiers (Render, Fly.io, etc.).

---

## Architecture

> **Desktop UI** runs locally as a JAR; it calls the **Spring Boot** backend (also local or cloud‑hosted), which persists data in **SQLite**. Separation keeps the UI snappy while letting the backend scale or move to the cloud later.

---

## Tech Stack

| Layer        | Technology                       | Why?                                   |
|--------------|----------------------------------|----------------------------------------|
| UI           | Java Swing (JDK 21)              | Native desktop look, zero browser lag  |
| State Mgmt   | Custom MVC + Observer pattern    | Lightweight, no external libs          |
| Backend      | Spring Boot 3, Spring Security   | Rapid REST APIs, robust auth           |
| DB           | SQLite 3 (JDBC)                  | Serverless, portable                   |
| AuthN/AuthZ  | JWT, BCrypt                      | Stateless, secure                      |
| Testing      | JUnit 5, Mockito                 | Unit/integ tests                       |
| Docs         | Swagger‑UI (springdoc‑openapi)   | Live API playground                    |

---

## Getting Started

### Prerequisites
- **JDK 21**  
- **Maven 3.9+**  
- **Git**  
- (Optional) **Docker** if you prefer containerized runs  

### 1️⃣ Clone
~~~bash
git clone https://github.com/your-handle/ArrayOfHope.git
cd ArrayOfHope
~~~

### 2️⃣ Backend Setup
~~~bash
cd backend
mvn clean package
mvn spring-boot:run
~~~
The API now lives at **http://localhost:8080**. Access docs at **/swagger-ui.html**.

### 3️⃣ Frontend Setup
~~~bash
cd desktop
mvn clean package
java -jar target/ArrayOfHope-desktop.jar
~~~
## Project Structure

```bash
ArrayOfHope/
├── backend/                         # Spring Boot project (API + Security)
│   ├── src/main/java/com/arrayofhope/backend
│   │   ├── config/                  # Security and DB config
│   │   ├── controller/              # REST API endpoints
│   │   ├── service/                 # Business logic
│   │   ├── repository/              # Data access layer (JPA repositories)
│   │   └── BackendApplication.java  # Main backend app class
│   └── src/main/resources/
│       └── application.properties   # DB and app settings
│
├── desktop/                         # Java Swing client (UI)
│   └── src/main/java/
│       ├── ui/auth/                 # Login, Register, Forgot Password screens
│       ├── ui/main/                 # Dashboards for Admins and Users
│       ├── ui/views/                # Post, View, Filter, Apply to jobs
│       ├── data/                    # DAOs (JDBC for SQLite)
│       ├── model/                   # POJO classes (Job, User, Application)
│       ├── util/                    # SessionManager, helpers
│       └── Main.java                # Main launcher class
│
├── resumes/                         # Uploaded resume files
└── README.md                        # This file
```

## Running the App

| Environment | Command                                           | Notes                                      |
|-------------|---------------------------------------------------|-------------------------------------------|
| **Dev**     | `mvn spring-boot:run` + `java -jar desktop.jar`   | Runs backend + frontend locally           |
| **Docker**  | `docker compose up`                               | Builds backend image + mounts DB          |
| **Prod**    | Build JARs & deploy backend to Render/Fly.io; run desktop JAR | Compatible with free tiers       |

## Roadmap

Here are some features and improvements planned for future versions:

- [ ] 🔄 Migrate DB layer to Spring Data JDBC
- [ ] 📧 Add email notifications (e.g., job status, application updates)
- [ ] 📤 Export job listings to CSV / PDF
- [ ] 🔐 Add two-factor authentication (2FA)
- [ ] 🔁 Scheduled job cleanup using Quartz or built-in scheduler
- [ ] ⚙️ Set up GitHub Actions for CI/CD builds

---

## Contributing

We welcome contributions from the community!

### How to Contribute:
1. **Fork** the repo and clone it locally.
2. Create a **new branch**: `git checkout -b feature/my-feature`
3. Make your changes, ensuring `mvn test` passes.
4. Commit using [Conventional Commits](https://www.conventionalcommits.org/):  
   Example: `feat: add resume parser for admin view`
5. Push and submit a **Pull Request** (PR).

Please include clear descriptions of what your PR does and why. ❤️

---

## License

This project is licensed under the [MIT License](LICENSE).

You are free to use, modify, and distribute it for personal or commercial use — just give credit where it’s due.

---


