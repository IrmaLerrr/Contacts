# ContactsCLI - Phone Book Application
![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)
![Architecture](https://img.shields.io/badge/Architecture-OOP-blue)

## Overview
ContactsCLI is a command-line telephone book application that allows you to manage contacts of two types: **Person** and **Organization**. The application provides a simple interface to add, list, search, edit, and delete contacts.
This project was completed as part of the [Hyperskill](https://hyperskill.org/projects/43) educational project.

## Features

- **Two Contact Types:**
  - **Person** - Stores personal contacts with name, surname, birth date, gender, and phone number
  - **Organization** - Stores organization contacts with name, address, and phone number

- **Core Operations:**
  - **Add** - Create new person or organization contacts
  - **List** - Display all contacts with pagination
  - **Search** - Find contacts by name, phone, or other fields
  - **Edit** - Modify existing contact information
  - **Delete** - Remove contacts from the phone book
  - **Count** - Show total number of contacts
  - **Exit** - Close the application

## Project Structure

```
ContactsCLI/
├── src/contacts/
│   ├── ClientLogic.java     # Main application logic and menu handling
│   ├── Contact.java         # Abstract base class for contacts
│   ├── InputHandler.java    # User input processing
│   ├── Main.java           # Application entry point
│   ├── Organization.java    # Organization contact implementation
│   ├── Person.java         # Person contact implementation
│   ├── PhoneBook.java      # Phone book data management
│   └── Type.java          # Enum for contact types (PERSON, ORGANIZATION)
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compilation & Execution

1. **Navigate to the project directory:**
```bash
cd ContactsCLI
```

2. **Compile the Java files:**
```bash
javac src/contacts/*.java
```

3. **Run the application:**
```bash
java src/contacts/Main
```

## 🎮 How to Use

### Main Menu Options:
```
[menu] Enter action (add, list, search, count, exit):
```

### Adding a Contact:
1. Choose `add` from the main menu
2. Select contact type: `person` or `organization`
3. Fill in the required information

### Listing Contacts:
1. Choose `list` from the main menu
2. Contacts are displayed with indices
3. Select a contact by number or return with `back`
4. For selected contacts: choose `edit`, `delete`, or `menu`

### Searching:
1. Choose `search` from the main menu
2. Enter search query
3. Results are displayed with indices
4. Select a contact by number or return with `back`
5. For selected contacts: choose `edit`, `delete`, or `menu`

## Contact Information

### Person Contact Fields:
- Name
- Surname
- Birth Date (format: YYYY-MM-DD)
- Gender (M/F)
- Phone Number

### Organization Contact Fields:
- Organization Name
- Address
- Phone Number

## Technical Details

- **Design Pattern:** Uses inheritance with `Contact` as abstract base class
- **Data Persistence:** Contacts are stored in memory during runtime
- **Input Validation:** Includes validation for phone numbers, dates, and other fields
- **Error Handling:** User-friendly error messages for invalid inputs
**Note:** This application runs in the command line/terminal. Make sure your terminal supports UTF-8 encoding for proper display of special characters.
