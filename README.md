
# Spring Boot PostgreSQL Dockerized App

This project is a minimal Spring Boot application built using **Java 21**, connected to a **PostgreSQL** database, and fully **Dockerized** for deployment in a virtual machine or any container environment.

## 📦 Technologies Used

- Java 21
- Spring Boot
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## 🏗️ Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.test.test/
    │       ├── controller/
    │       │   └── UserController.java
    │       ├── models/
    │       │   └── Student.java
    │       └── service/
    │           └── StudentService.java
    └── resources/
        └── application.properties
```

---

## ⚙️ Prerequisites

- Java 21 installed
- Docker and Docker Compose installed
- Maven installed

---

## 🧪 Build the Project

Run the following command to build the project and skip test cases:

```bash
mvn clean package -DskipTests
```

> 💡 `-DskipTests` is used to skip running unit/integration tests, which is useful for faster packaging in production environments.

---

## 🐳 Dockerize the App

Ensure you have the following files created in the project root:

### 📄 Dockerfile

```Dockerfile
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 📄 docker-compose.yml

```yaml
version: '3.8'

services:
  app:
    build: .
    container_name: springboot-app
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tharundb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres

  db:
    image: postgres:15
    container_name: postgres-db
    environment:
      POSTGRES_DB: tharundb
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
```

### 📄 application.properties

```properties
spring.application.name=test
server.port=8080

spring.datasource.url=jdbc:postgresql://db:5432/tharundb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
```

---

## 🚀 Run the Application

Use Docker Compose to build and run all services:

```bash
docker compose up --build -d
```

> 🔸 `--remove-orphans`: This ensures that any containers not defined in your current `docker-compose.yml` file are removed, keeping the environment clean.

---

## ✅ API Endpoints

| Method | URL          | Description              |
|--------|--------------|--------------------------|
| GET    | `/api/sample` | Health check endpoint     |
| GET    | `/api`        | Fetch all student records |

---

## 🛑 Stop Containers

```bash
docker compose down
```

---

## 📌 Tips

- Make sure the PostgreSQL port `5432` is not being used by another instance.

To view logs:

```bash
docker logs -f springboot-app
```

To clean and rebuild everything from scratch:

```bash
docker compose down --volumes --remove-orphans
mvn clean package -DskipTests
docker compose up --build -d
```

---

## 🧑‍💻 Author

Created by Pranay – feel free to contribute or fork!
