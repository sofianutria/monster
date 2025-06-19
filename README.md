# 📝 Monster Shop 

A RESTful API built with **Spring Boot** that allows managing an ecommerce store that sells Monsters. The project follows a clean, modular architecture in Java, using layered design with controllers, services, repositories, DTOs, and entities.

---

## 🎯 Features

- CRUD operations for monsters.
- Creation of reviews
- Get reviews of the monsters
- Layered architecture using Spring Boot
- Structured and controlled API responses
- Ready to be connected to frontend or Postman tests

---

## 🏗️ Architecture

The project follows a layered architecture:

```bash
MONSTER/
├── controller/    # REST Controllers
├── service/       # Business Logic
├── repository/    # JPA Data Access
├── dto/           # Data Transfer Objects
```

---

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- MySQL (based on config)

---

## 🚀 How to Run

### Requirements

- JDK 21
- Maven installed
- IDE (IntelliJ, VSCode, Eclipse)

### Steps

1. Clone or unzip the project
2. Configure `application.properties` inside `src/main/resources` (if needed)
3. Run from IDE or terminal:

```bash
mvn spring-boot:run
```

4. API will be available at:

```
http://localhost:8080
```

---

## 📬 Available Endpoints

> Note: Endpoints are grouped by resource type.

### 🔤 Products (`/products`)

- `GET /products` – Get all products
- `GET /products/{id}` – Get a monster by ID
- `POST /products` – Create new monster
- `PUT /products/{id}` – Update monster
- `DELETE /products/{id}` – Delete monster


### 👤 Review (`/reviews`)

- `GET /reviews/{id}` – Get all reviews for monster
- `POST /reviews/{id}` – Create review for a monster


## 📁 Project Structure

```bash
src/
├── main/
│   ├── java/
│   │   ├── controllers/
│   │   ├── services/
│   │   ├── repositories/
│   │   ├── dtos/
│   │   ├── models/
│   │   └── MonsterApplication.java
│   └── resources/
│       └── application.properties
```

---


## 📈 Future features

- Connect Frontend and Backend

---

## 🙏 Acknowledgments

- Spring Boot Team
- Factoria F5
- Open Source Community

---

Thanks for using MFPSB! 🚀
