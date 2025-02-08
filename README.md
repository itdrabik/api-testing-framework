# API Testing Framework

## Description

**API Testing Framework** is a lightweight and flexible framework for API testing, enabling automation of REST API
tests. The project uses **Java**, **JUnit**, and **REST Assured** for structured endpoint testing.

## Technologies

- **Java** – main programming language
- **JUnit** – unit testing framework
- **REST Assured** – primary library for REST API tests
- **Cucumber** – for BDD-style testing
- **Git** – version control
- **Jenkins** – continuous integration (optional)

## Directory Structure

```
api-testing-framework/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── pages/          
│   │   │   ├── runners/        
│   │   │   ├── stepdefinitions/ 
│   │   │   ├── tests/          
│   │   ├── resources/
│   │   │   ├── features/       
│   ├── config.properties       
├── pom.xml      
├── README.md    
```

## Installation and Configuration

1. **Clone the repository**:
   ```sh
   git clone https://github.com/itdrabik/api-testing-framework.git
   cd api-testing-framework
   ```

2. **Run tests** (example using Maven):
   ```sh
   mvn test
   ```

## How Tests Are Structured?

The framework includes two types of tests:

### **1. Unit and Integration Tests (JUnit + REST Assured)**

These tests are located in the `UserApiTest` class and use:

- **JUnit** – for test execution
- **REST Assured** – for making HTTP requests and assertions

#### **List of JUnit Tests**

1. **`testGetUsers()`** – Sends a `GET` request to retrieve users and verifies the response status.
2. **`testCreateUser()`** – Sends a `POST` request to create a user and checks if the response contains valid user data.
3. **`testUpdateUser()`** – Sends a `PUT` request to update an existing user and verifies if the response contains
   updated information.
4. **`testDeleteUser()`** – Sends a `DELETE` request to remove a user and ensures the response body is empty.

### **2. BDD Tests (Cucumber)**

These tests are defined in the **`user_api.feature`** file and executed via `CucumberTestRunner`.

- **Cucumber** – Uses Gherkin syntax for behavior-driven testing.
- **Step Definitions (`UserApiSteps`)** – Implements test logic in Java.

#### **List of Cucumber Tests**

5. **`Retrieve list of users`** – Sends a `GET` request to fetch users and validates the response structure.
6. **`Create a new user`** – Sends a `POST` request to create a user and verifies correctness of the response.
7. **`Update an existing user`** – Sends a `PUT` request to update user data and ensures the changes are reflected.

### **Summary of Test Types**

| Test Name                   | Type | Framework |
|-----------------------------|------|------------|
| `testGetUsers()`            | API Test | JUnit + REST Assured |
| `testCreateUser()`          | API Test | JUnit + REST Assured |
| `testUpdateUser()`          | API Test | JUnit + REST Assured |
| `testDeleteUser()`          | API Test | JUnit + REST Assured |
| `Retrieve list of users`    | BDD Test | Cucumber |
| `Create a new user`         | BDD Test | Cucumber |
| `Update an existing user`   | BDD Test | Cucumber |


