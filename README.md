InkSync

A Collaborative Notes and Knowledge Sync Platform

---

Overview

InkSync is a backend driven collaborative notes platform where users can create, edit, and synchronize notes across multiple devices in real time.

The goal of InkSync is to design a backend system capable of storing, syncing, and managing knowledge while handling multiple users editing and accessing the same content.

Instead of notes being stored locally on one device, InkSync keeps everything in the cloud and synchronizes updates across devices instantly.

Example scenario:

A user writes notes on their laptop.

Within seconds the same note appears on their phone or tablet.

This system introduces real world backend challenges such as:

- data synchronization
- concurrent updates
- version control
- real time communication
- conflict resolution

InkSync is designed as a backend heavy system similar to simplified versions of Notion, Google Docs, or Evernote.

---

Problem Statement

Many note taking applications store data locally or sync slowly between devices.

Problems users face:

• Notes not updated across devices
• Conflicts when editing the same note
• Losing data after crashes
• Difficulty sharing notes with others

InkSync solves these issues by creating a centralized synchronization service.

---

Core Features

Create and Manage Notes

Users can create notes containing:

- plain text
- markdown
- code snippets
- lists

Example note

Title: Backend System Design

Topics:
- Load Balancer
- Redis Caching
- Database Sharding

Each note is stored securely in the backend database.

---

Real Time Synchronization

Whenever a note is edited, the update is synchronized across all devices connected to the user's account.

Example flow:

User edits note
↓
Client sends update to server
↓
Server stores change
↓
Server broadcasts update to other devices

This allows seamless editing between multiple devices.

---

Multi Device Support

A user can access notes from:

• phone
• laptop
• tablet

All notes remain consistent and synchronized.

---

Note Sharing

Users can share notes with others.

Example:

Owner: Shivansh
Shared with: Team Members
Permission: Read / Edit

This feature allows collaborative note writing.

---

Version History

Every update to a note creates a new version.

Example:

Version 1
Created note

Version 2
Added system design section

Version 3
Added Redis explanation

Users can restore older versions if needed.

---

Offline Editing and Sync

Users can edit notes even without internet access.

Once the device reconnects, changes are synchronized with the server.

---

System Architecture

InkSync follows a distributed backend architecture.

Client Applications
(Web / Mobile)
       |
       v
API Gateway
       |
       v
Application Services
       |
       v
Database

For real time updates, a WebSocket layer can be used.

Client
   |
WebSocket Connection
   |
Realtime Sync Server

---

Technology Stack

Backend

Java
Spring Boot
Spring Web
Spring Data JPA

Database

MySQL

Optional Technologies

Redis (caching)
WebSockets (real time updates)
Docker (containerization)
Kafka (event streaming)

---

Database Design

Users Table

Field| Type| Description
id| BIGINT| Primary key
name| VARCHAR| User name
email| VARCHAR| Unique email
password_hash| VARCHAR| Secure password

---

Notes Table

Field| Type| Description
id| BIGINT| Primary key
title| VARCHAR| Note title
content| TEXT| Note content
owner_id| BIGINT| User reference
created_at| TIMESTAMP| Creation time
updated_at| TIMESTAMP| Last update

---

Note Versions Table

Field| Type| Description
id| BIGINT| Primary key
note_id| BIGINT| Reference to note
content| TEXT| Snapshot of content
version_number| INT| Version index
created_at| TIMESTAMP| Version timestamp

---

Shared Notes Table

Field| Type| Description
id| BIGINT| Primary key
note_id| BIGINT| Reference to note
user_id| BIGINT| Shared user
permission| VARCHAR| Read or Edit

---

API Endpoints

Create Note

POST /api/notes

Request

{
  "title": "System Design",
  "content": "Notes about distributed systems"
}

Response

{
  "noteId": 101,
  "message": "Note created successfully"
}

---

Get Notes

GET /api/notes

Returns all notes belonging to the user.

---

Update Note

PUT /api/notes/{id}

Request

{
  "content": "Updated content"
}

Each update also creates a new version entry.

---

Share Note

POST /api/notes/{id}/share

Request

{
  "userEmail": "teammate@email.com",
  "permission": "EDIT"
}

---

Get Version History

GET /api/notes/{id}/versions

Returns all saved versions of the note.

---

Example Project Structure

inksync
 ├── controller
 │     └── NoteController.java
 │
 ├── service
 │     └── NoteService.java
 │
 ├── repository
 │     └── NoteRepository.java
 │
 ├── model
 │     ├── Note.java
 │     ├── User.java
 │     └── NoteVersion.java
 │
 ├── sync
 │     └── SyncService.java
 │
 └── websocket
       └── NoteSyncHandler.java

This layered structure ensures maintainable and scalable backend code.

---

Synchronization Strategy

InkSync must handle multiple devices updating the same note.

Possible approaches:

Last Write Wins

The most recent update overwrites older ones.

Simple but may cause data loss.

---

Version Based Updates

Each note has a version number.

Client sends update with version
Server checks version
If mismatch → conflict detected

---

Operational Transform (Advanced)

Used by systems like Google Docs.

Allows merging concurrent edits in real time.

---

Performance Considerations

Database Indexing

Indexes should exist on:

user_id
note_id
created_at

This improves query speed.

---

Caching

Frequently accessed notes can be cached in Redis.

This reduces database load.

---

Event Driven Sync

Using Kafka or message queues allows scalable synchronization across services.

---

Future Enhancements

InkSync can grow into a much larger platform.

Possible features:

• Markdown rendering
• AI powered note summarization
• Full text search
• Tag based organization
• Graph based knowledge linking
• End to end encryption
• Multi workspace collaboration

---

Learning Outcomes

Building InkSync teaches important backend concepts such as:

- collaborative systems
- synchronization logic
- database modeling
- version control
- distributed architecture
- event driven systems

It is a strong intermediate to advanced backend project.

---

License

MIT License

---

Author

Built by Shivansh Bagga
