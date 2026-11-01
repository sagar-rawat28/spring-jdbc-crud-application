# Spring JDBC CRUD Application

A CRUD (Create, Read, Update, Delete) application built using **Java, Spring JDBC, and MySQL** to perform database operations efficiently.

## Features

- Create new records in the database.
- Retrieve all records.
- Retrieve records by ID.
- Update existing records.
- Delete records.
- Perform database operations using Spring JdbcTemplate.
- Manage database connectivity using Spring configuration.

## Technologies Used

- Java
- Spring Framework
- Spring JDBC
- JdbcTemplate
- MySQL
- Maven

## Project Structure

```text
spring-jdbc-crud-application/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/
│       │       ├── Main.java
│       │       ├── model/
│       │       ├── dao/
│       │       └── config/
│       │
│       └── resources/
│           └── application.properties
│
├── database/
│   └── schema.sql
│
├── pom.xml
├── .gitignore
├── README.md
└── LICENSE
```

*Adjust the structure according to your actual implementation.*

## Key Concepts Covered

- Understanding Spring JDBC.
- Working with JdbcTemplate.
- Database connectivity and configuration.
- Executing SQL queries using Spring JDBC.
- Implementing CRUD operations.
- Using DAO (Data Access Object) pattern.
- Handling database exceptions.

## How to Run

1. Clone this repository.
2. Configure your MySQL database.
3. Update database credentials in the configuration file.
4. Create the required database and tables.
5. Build the project using Maven.
6. Run the Main class.

## Learning Objectives

This project demonstrates how Spring JDBC simplifies database operations compared to traditional JDBC by reducing boilerplate code and providing convenient database interaction through JdbcTemplate.

It is a practical project for understanding Java backend development and database integration using the Spring Framework.
