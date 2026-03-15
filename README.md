# InkSync

Real time collaborative document backend built with **Spring Boot** and **WebSockets**.

InkSync is a backend system that allows multiple users to edit the same document simultaneously. When a user makes a change, the update is sent to the server and instantly broadcast to all other connected clients so everyone sees the same document in real time.

The goal of this project is to demonstrate the backend mechanics behind collaborative editing platforms and real time communication systems.

---

# Links

Live Application
https://inksync-7hn6.onrender.com

H2 Database Console
https://inksync-7hn6.onrender.com/h2-console

---

# What This Project Demonstrates

Most modern applications are not simple request response systems anymore. Many tools such as shared editors, chat applications, and live dashboards rely on **persistent connections and real time data flow**.

InkSync demonstrates how a backend system can maintain live connections with multiple clients and distribute updates instantly.

The project shows how to build:

A backend that supports **real time collaboration**

A **WebSocket based communication layer**

A simple **document storage system**

A service capable of **broadcasting updates to multiple users**

This makes InkSync a useful learning project for understanding the foundations of real time systems.

---

# Key Features

Real time collaborative editing using WebSockets

Instant broadcasting of document updates to connected users

REST APIs for creating and retrieving documents

In memory H2 database for simple setup

Clean layered backend architecture using Spring Boot

Container ready deployment using Docker

---

# Technology Stack

Backend
Java 21
Spring Boot
Spring WebSocket
Spring Data JPA

Database
H2 In Memory Database

Deployment
Docker
Render Cloud Platform

---

# System Architecture

InkSync follows a layered backend architecture that separates responsibilities across different components.

Controller Layer
Handles REST API requests and WebSocket message communication. This layer acts as the entry point for incoming requests.

Service Layer
Contains the core application logic responsible for processing document edits and coordinating updates.

Repository Layer
Manages database access using Spring Data JPA.

Database Layer
Stores document information using an H2 in memory database.

This structure keeps the system modular and easy to extend.

---

# How Real Time Collaboration Works

Traditional web applications operate through request response cycles. A client sends a request and waits for the server to respond.

Collaborative applications require something different. Instead of repeated requests, they maintain **continuous communication channels** between clients and the server.

InkSync achieves this using WebSockets.

The collaboration flow works like this:

1 A document is created using a REST API.

2 A client opens the document and establishes a WebSocket connection with the server.

3 When a user edits the document, the change is sent to the backend through the WebSocket connection.

4 The server processes the edit and broadcasts it to all connected clients.

5 Each client updates the document locally so every user stays synchronized.

This approach allows changes to appear almost instantly across multiple users.

---

# Running the Project Locally

## 1 Clone the repository

git clone https://github.com/baggashivansh/InkSync.git

cd InkSync

## 2 Build the project

mvn clean install

## 3 Run the application

mvn spring-boot:run

Once the application starts, the server will be available at

http://localhost:8080

---

# Accessing the Database

InkSync uses an H2 in memory database for simplicity.

You can inspect the database using the built in H2 console.

Open the following URL

http://localhost:8080/h2-console

Use the following configuration

JDBC URL
jdbc:h2:mem:inksyncdb

Username
sa

Password
leave empty

Because the database exists only in memory, all stored data resets whenever the application restarts.

---

# WebSocket Communication

Clients connect to the WebSocket endpoint to send and receive document updates.

Example endpoint

/ws

When an edit is received by the server, the update is broadcast to every connected client working on the same document.

This mechanism allows multiple users to stay synchronized while editing the same content.

---

# Deployment

InkSync is containerized and can be deployed easily using Docker.

The project is currently deployed on Render.

Live deployment

https://inksync-7hn6.onrender.com

Note

Because the application uses an in memory database, stored documents are cleared whenever the server restarts.

---

# Author

Built by Shivansh Bagga

