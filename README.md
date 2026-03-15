# InkSync

InkSync is a realtime collaborative notes platform built with Spring Boot and WebSockets.

The project explores how modern collaborative systems work under the hood. Instead of notes being stored only on a single device, InkSync keeps documents synchronized in the backend so multiple users can edit the same content and instantly see updates.

The goal of this project is to design and implement the backend architecture behind realtime editing systems while keeping the system simple, scalable, and understandable.

---

## What InkSync Does

InkSync allows users to open a document in the browser and start typing. As edits happen, those updates are immediately sent to the backend and broadcast to other connected users.

If two people open the same document link, they will see each other's changes appear in real time.

This creates a collaborative editing experience where the document stays synchronized across devices and users without requiring page refreshes.

---

## Core Features

Realtime Collaborative Editing
Multiple users can edit the same document simultaneously and see updates appear instantly.

Document Based Sync Rooms
Each document uses its own WebSocket channel. This ensures that updates are only sent to users who are currently editing that specific document.

Efficient Update Broadcasting
Typing events are debounced before being sent to the server which reduces unnecessary network traffic and improves performance.

Shareable Document Links
Every document has a unique URL that can be shared with others to allow collaborative editing.

Cloud Stored Notes
All notes are stored in the backend so they remain accessible and consistent across devices.

---

## How It Works

InkSync uses a combination of REST APIs and WebSockets.

The REST layer is responsible for loading and storing documents, while the WebSocket layer handles realtime communication between clients.

A simplified flow looks like this:

User edits document
↓
Browser sends update to backend
↓
Spring Boot processes the change
↓
WebSocket broadcasts update
↓
All connected clients receive the update

This architecture allows multiple users to stay synchronized with minimal delay.

---

## Architecture Overview

InkSync follows a layered backend structure.

Client (Browser)
↓
REST API
↓
Spring Boot Application
↓
Database

For realtime communication:

Client
↓
WebSocket Connection
↓
Spring Message Broker
↓
Broadcast to document channel

Each document has its own communication channel.

Example:

/topic/notes/{docId}

This prevents unnecessary global broadcasts and allows the system to scale as more documents and users are added.

---

## Project Structure

src/main/java/com/shivansh/inksync

controller
Handles HTTP requests and WebSocket message mappings

service
Contains the core application logic

repository
Handles database access through Spring Data JPA

model
Entity classes representing database tables

config
Application configuration including WebSocket setup

resources/static
Frontend files used for the editor interface

---

## Running the Project Locally

Clone the repository

git clone https://github.com/baggashivansh/InkSync.git

Navigate to the project folder

cd InkSync

Run the application

./mvnw spring-boot:run

Once the server starts, open the application in the browser and create or access a document.

Opening the same document in multiple browser tabs will demonstrate realtime synchronization.

---

## What This Project Demonstrates

InkSync focuses on several important backend engineering concepts.

Designing realtime systems using WebSockets
Handling concurrent edits from multiple clients
Structuring a layered Spring Boot application
Building scalable event driven communication
Designing backend systems for collaborative applications

---

## Author

Shivansh Bagga
Computer Science Student | Backend Developer

InkSync was built as part of a learning journey focused on backend architecture and distributed systems.

---

## License

MIT License
