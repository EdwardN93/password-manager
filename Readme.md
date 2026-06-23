# Password Manager

A console-based Password Manager built with Java, Maven, JDBC, and SQLite.

This project allows users to securely store and manage login credentials through a simple command-line interface while persisting data in an SQLite database.

## Features

### Database

* SQLite integration
* Automatic database creation
* Automatic table creation
* Persistent data storage

### Password Management

* Add new password entries
* Display all saved entries
* Search entries by service name
* Update passwords by ID
* Delete entries by ID

### User Interface

* Interactive console menu
* Input-based navigation
* Password masking when displaying entries

## Technologies Used

* Java
* Maven
* JDBC
* SQLite

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

## Current Functionality

### Create

Add a new password entry:

* Service name
* Username / Email
* Password
* Notes

### Read

* Display all entries
* Search entries by service name

### Update

* Change an existing password by ID

### Delete

* Remove an entry by ID

## Example Menu

```text
1. Get all entries
2. New entry
3. Delete entry
4. Search by service name
5. Update password
0. Exit
```

## Learning Goals

This project was built to practice:

* Object-Oriented Programming (OOP)
* JDBC database connectivity
* SQLite database management
* CRUD operations
* Maven dependency management
* Java application architecture

## Future Improvements

* Master password authentication
* Password encryption (AES)
* Password generator
* Input validation improvements
* JavaFX graphical interface
* Export / Import functionality

## Author

Eduard Nedelcu
