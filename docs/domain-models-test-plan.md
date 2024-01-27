# Domain Models, Class Diagrams and Test Plan

![img.png](img.png)

```mermaid
---
title: Address Book
---
classDiagram
%%    User <-- AddressBook
%%    AddressBook <-- Contact
    
    class User{
        -int id
        -String fName
        -String lName
        -Long phoneNumber
        -String email
        -ArrayList<AddressBook> AddressBooks
        
        +User(fName, lName, phoneNumber, email)
        +User(id, fName, lName, phoneNumber, email)
        +getId() int
        +getFName() String
        +getLName() String
        +getFullName() String
        +getPhoneNumber() Long
        +getEmail() String
        +getAddressBooks() AddressBook[]
        +setFName() void
        +setLName() void
        +setPhoneNumber() void
        +setEmail() void
        +AddAddressBook() void
    }
    
    class AddressBook{
        -int id
        -String addressBookName
        -int userId
        -ArrayList<Contact> contacts
        
        +AddressBook(AddressBookName, userId)
        +AddressBook(id, AddressBookName, userId)
        +getAddressBookName() String
        +setAddressBookName() void
        +addContact() void
        +removeContact(name) void
        +searchByName(name) Contact
        +viewAllContacts() ArrayList<Contacts>
        +deleteAllContacts() void
        +setContactAddressBookId() void
        
 }
 
    class Contact{
        -int id
        -String name
        -Long phoneNumber
        -String email
        -int addressBookId
        
        +Contact(name, phoneNumber, email, addressBookId)
        +Contact(id, name, phoneNumber, email, addressBookId)
        +setName() void
        +setPhoneNumber() void
        +setEmail() void
        +getName() String
        +getPhoneNumber() Long
        +getEmail() String
        
    }
    
    class Validators{
        <<abstract>>
        +validateName()$ String
        +validatePhoneNumber()$ Long
        +validateEmail()$ String
    }
    
    class Saver{
        <<abstract>>
        +saveContact()$ void
        +saveAddressBook()$ void
        +getUser()$ User
        +getAddressBook()$ AddressBook
    }
    
    class consoleInterface{
        
    }
    
    
    

```