# InkSync

A realtime collaborative document editor built with Spring Boot and WebSockets.

InkSync allows multiple users to edit the same document at the same time while seeing changes instantly. Instead of storing notes locally on a device, InkSync synchronizes content through a backend service so edits appear across all connected users in real time.

This project focuses on building a backend system that handles realtime communication, document synchronization, and collaborative editing.

Example

User A typing in the editor

Hello from laptop

User B viewing the same document instantly sees

Hello from laptop

---

Live Demo

Backend deployed on Render

Live URL will be added after deployment.

Source Code

https://github.com/baggashivansh/InkSync

Open the same document link in multiple browser tabs to see realtime synchronization in action.

---

Why This Project Exists

Most note taking tools save content locally and synchronize slowly between devices. When multiple users attempt to edit the same document, conflicts can occur or changes may appear delayed.

InkSync approaches the problem differently by treating documents as shared collaborative spaces. Every edit is sent to the backend and broadcast instantly to other connected users.

The goal of this project was to understand how realtime collaborative systems work and to implement a simplified backend architecture similar to modern collaborative editors.

---

How InkSync Works

The system follows a realtime communication model using WebSockets.

1 A user opens a document in the browser
2 The client connects to the server through a WebSocket connection
3 When the user edits the document, the update is sent to the backend
4 The backend broadcasts the update to other connected users editing the same document

Because each document has its own communication channel, only users working on the same document receive those updates.

This approach allows edits to appear almost instantly across multiple clients.

---

System Architecture

InkSync follows a layered backend architecture.

Client Browser
↓
Spring Boot REST Controller
↓
WebSocket Messaging Layer
↓
Service Layer
↓
Repository Layer
↓
Database

Each component has a specific responsibility.

Controller layer
Handles HTTP requests and WebSocket message mappings.

Service layer
Contains the core logic responsible for handling document updates.

Repository layer
Manages persistence and retrieval of document data.

WebSocket messaging layer
Broadcasts edits to connected clients in realtime.

---

Realtime Synchronization

InkSync uses document scoped communication channels.

Example

/topic/notes/{docId}

When a user edits a document, the update is sent to

/app/edit/{docId}

The server then broadcasts the update to

/topic/notes/{docId}

Only clients subscribed to that document receive the change.

This prevents unnecessary global broadcasts and keeps the system efficient.

---

Features

Realtime collaborative editing
Multiple users can edit the same document simultaneously.

Document specific WebSocket channels
Each document has its own realtime communication room.

Debounced updates
Typing events are grouped before sending updates to reduce network traffic.

Shareable document links
Users can share document URLs for collaborative editing.

Simple browser based editor
Frontend served directly from the backend.

---

Running Locally

Clone the repository

git clone https://github.com/baggashivansh/InkSync.git
cd InkSync

Run the Spring Boot application

./mvnw spring-boot:run

Once the server starts, open

http://localhost:8080/editor/1

Open the same URL in multiple browser tabs to test realtime synchronization.

---

Deployment

InkSync can be deployed using Docker and cloud platforms such as Render.

Deployment workflow

1 The GitHub repository is connected to Render
2 Render builds the Docker image
3 Maven compiles the Spring Boot project
4 A JAR file is generated
5 The container starts the application
6 Render assigns a public URL

Render provides the port dynamically, so the application binds to the environment port instead of a fixed port.

---

Tech Stack

Backend

Java
Spring Boot
Spring Web
Spring Data JPA

Realtime Communication

WebSockets
STOMP Messaging

Build Tool

Maven

Deployment

Docker
Render

---

Project Structure

InkSync

src
└─ main
├─ java
│   └─ com/shivansh/inksync
│       ├─ controller
│       ├─ service
│       ├─ repository
│       └─ model
│
└─ resources
└─ static
└─ index.html

Dockerfile
pom.xml
README.md

---

Author

Built by Shivansh Bagga
