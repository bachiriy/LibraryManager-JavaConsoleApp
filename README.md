# LibraryManager | Java Console Application for Library Management

## Project Overview

This project involves the development of a console-based application in Java 8 to manage a municipal library's inventory and loan system. The goal is to automate library tasks, such as adding, borrowing, returning, and searching for books and magazines, using a layered architecture.

## Project Structure

### Layered Architecture

- **Presentation Layer:**
  - `ConsoleUI`: Handles the user interface.

- **Business Layer:**
  - `Document` (Abstract Class): Represents a generic library document.
  - `Book` (Class): Represents a book, inherits from `Document`.
  - `Magazine` (Class): Represents a magazine, inherits from `Document`.
  - `Library` (Class): Manages the collection of documents.

- **Utility Layer:**
  - `DateUtils`: Manages date-related operations.

### Class Details

- **Document (Abstract Class):**
  - Attributes: `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`
  - Abstract Methods: `emprunter()`, `retourner()`, `afficherDetails()`

- **Book (Inherits from Document):**
  - Additional Attribute: `isbn`
  - Implements abstract methods.

- **Magazine (Inherits from Document):**
  - Additional Attribute: `numero`
  - Implements abstract methods.

## Key Features

- **Document Management:**
  - Add a document (book or magazine)
  - Borrow a document
  - Return a document
  - Display all documents
  - Search for a document

- **Technical Specifications:**
  - Use `ArrayList` for document storage
  - Implement a quick search with `HashMap<String, Document>`
  - Integrate Java Time API for date management
  - Apply lambda expressions

- **User Interface:**
  - Interactive menu with options to:
    1. Add a document
    2. Borrow a document
    3. Return a document
    4. Display all documents
    5. Search for a document
    6. Quit

## Project Constraints

- Data persists only in memory until the application is closed.


## Installation and Usage

### Prerequisites

- Java 8
- Git

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/JavaAura/med_elBachiri_S1_B1_gestionBiblio.git

2. Navigate to the project directory:
    ```bash
    cd app

3. Compile the project and Run the application:
    ```bash
    javac -d bin src/**/*.java

    java -cp bin ConsoleUI

3. Or simply run the command: 
    ```bash
      & 'C:\Program Files\Java\jdk-22\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\moham\AppData\Roaming\Code\User\workspaceStorage\8fa2ba723ae0dfee18a1dc5e309b25ea\redhat.java\jdt_ws\LibraryManager-JavaConsoleApp_69e95885\bin' 'Main'

### Usage
- Follow the interactive console menu to manage the library's inventory.



#### License
- This project is licensed under the MIT License - see the LICENSE file for details.

---

This `README.md` file outlines the project structure, features, and installation instructions in a clear and organized manner. 
Enjoy!
