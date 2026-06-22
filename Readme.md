# Password Manager

A simple Password Manager built with Java, Maven, JDBC, and SQLite.

## Features

* Add password entries
* Store passwords in an SQLite database
* Automatic database and table creation
* Search entries by service name
* Hide passwords when displaying entries
* Persistent storage between application runs

## Technologies Used

* Java
* Maven
* SQLite
* JDBC

## Database Schema

```sql
CREATE TABLE passwords (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    service_name TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    notes TEXT
);
```

## Current Progress

Implemented:

* SQLite database connection
* Automatic table creation
* Insert password entries into the database
* Basic PasswordEntry model
* PasswordManager service class

Planned Features:

* Display all entries from the database
* Delete entries by ID
* Update existing entries
* Master password authentication
* Password encryption
* Console menu interface
* JavaFX GUI

## Learning Objectives

This project was created to practice:

* Object-Oriented Programming (OOP)
* Maven dependency management
* JDBC
* SQLite databases
* CRUD operations
* Java application architecture

## Author

Eduard Nedelcu
