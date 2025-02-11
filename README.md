# **CBT Container Therapy App Back End (WIP)**

This repository contains the back-end service for the CBT Container App. It provides a RESTful API for managing topics and subtopics, allowing full CRUD operations. This back-end is built using Spring Boot and integrates with a MySQL database for data persistence.

## **Table of Contents**
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [API Endpoints] (#api-endpoints)
- [Contributing](#contributing)

## **Introduction**

The back-end service handles all data management for the CBT Container App, providing endpoints for creating, retrieving, updating, and deleting topics and subtopics. It ensures secure and efficient data handling while maintaining seamless communication with the front-end.

## **Features**

RESTful API: Provides endpoints for all CRUD operations.

Data Persistence: Uses MySQL for reliable data storage.

Validation: Ensures data integrity with validation mechanisms.

Error Handling: Global error handling for consistent API responses.

## **Technologies Used**

Java

Spring Boot

MySQL

Hibernate/JPA

Maven

## **Setup and Installation**

Clone the repository:

git clone https://github.com/YourUsername/container-therapy-backend.git

Navigate to the project directory:

cd container-therapy-backend

Configure your application.yaml with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/cbt_app
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Build and run the application:

mvn spring-boot:run

## **API Endpoints**

GET /containerObjects: Retrieve all objects.

POST /containerObjects: Create a new topic.

GET /containerObjects/{id}: Retrieve a specific topic by ID.

PUT /containerObjects/{id}: Update a specific topic.

DELETE /containerObjects/{id}: Delete a specific topic.

## **Features to be Added**

POST /containerObjects/{id}/subtopics: Add a subtopic to a topic.

DELETE /subtopics/{id}: Delete a subtopic by ID.

Connection to front end of application (WIP)

## **Contributing**

Contributions are welcome! Please submit a Pull Request for any improvements or bug fixes.
