package com.addressbook;

import com.addressbook.dao.AddressBookSaver;
import com.addressbook.dao.ContactSaver;
import com.addressbook.dao.Dao;
import com.addressbook.dao.UserSaver;
import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.User;

import java.util.Scanner;

public class AddressBookApplication {

    public static void main(String[] args) throws Exception {

//        Starting by cleaning all data
        Dao.resetSQL();

        System.out.println("Hello, welcome to the Address Book Application!");

//        Create a new user
        User user = new User("Ed", "Wright", "07710308733", "ed@df.com");

//        Save the user to database.
//        Returns saved object with SQL incremented id.
        User savedUser = UserSaver.saveUser(user);

//        Lets confirm our name and new id.
        System.out.println("User: " + savedUser.getFullName() + " has been saved with id: " + savedUser.getId());

        System.out.println("\n---------------------------------------------------\n");
//        Lets have a look at our address books.
        savedUser.printAddressBooks();

//        Looks like we need to create an address book.
        AddressBook addressBook = new AddressBook("My new address book", savedUser);
        AddressBook savedAddressBook = AddressBookSaver.saveAddressBook(addressBook);
        savedUser.addAddressBook(savedAddressBook);

//        Let's confirm our address book name and new SQL built id.
        System.out.println(savedAddressBook.getAddressBookName() + " has been saved with id: " + savedAddressBook.getId());

        System.out.println("\n---------------------------------------------------\n");
//        We now need to see what contacts out address book has!
        savedAddressBook.printAddressBook();

//        Here we can see the start of our address book, but it has no contacts. Let's add some.

        Contact contact = new Contact("Jeremy Wick", "07710308722", "Jeremy@gmail.com", savedAddressBook);
        Contact savedContact = ContactSaver.saveContact(contact);

        savedAddressBook.addContact(contact);
        savedAddressBook.printAddressBook();

//      Let's add some more contacts.
        Contact contact1 = new Contact("Alice Smith", "07710308734", "alice.smith@gmail.com", savedAddressBook);
        Contact savedContact1 = ContactSaver.saveContact(contact1);
        savedAddressBook.addContact(contact1);

        Contact contact2 = new Contact("Bob Johnson", "07710308735", "bob.johnson@gmail.com", savedAddressBook);
        Contact savedContact2 = ContactSaver.saveContact(contact2);
        savedAddressBook.addContact(contact2);

        Contact contact3 = new Contact("Charlie Brown", "07710308736", "charlie.brown@gmail.com", savedAddressBook);
        Contact savedContact3 = ContactSaver.saveContact(contact3);
        savedAddressBook.addContact(contact3);

        Contact contact4 = new Contact("Diana Williams", "07710308737", "diana.williams@gmail.com", savedAddressBook);
        Contact savedContact4 = ContactSaver.saveContact(contact4);
        savedAddressBook.addContact(contact4);


        savedAddressBook.printAddressBook();

        System.out.println("\n---------------------------------------------------\n");
//        What if we need another address book?
        AddressBook wordAddressBook = new AddressBook("Work contacts", savedUser);
        AddressBook savedWorkAddressBook = AddressBookSaver.saveAddressBook(wordAddressBook);
        savedUser.addAddressBook(savedWorkAddressBook);

//        Lets add some contacts
        Contact workContact1 = new Contact("Ethan Taylor", "07710308738", "ethan.taylor@work.com", savedWorkAddressBook);
        Contact savedWorkContact1 = ContactSaver.saveContact(workContact1);
        savedWorkAddressBook.addContact(savedWorkContact1);

        Contact workContact2 = new Contact("Fiona Davis", "07710308739", "fiona.davis@work.com", savedWorkAddressBook);
        Contact savedWorkContact2 = ContactSaver.saveContact(workContact2);
        savedWorkAddressBook.addContact(savedWorkContact2);

        Contact workContact3 = new Contact("George Miller", "07710308740", "george.miller@work.com", savedWorkAddressBook);
        Contact savedWorkContact3 = ContactSaver.saveContact(workContact3);
        savedWorkAddressBook.addContact(savedWorkContact3);

        Contact workContact4 = new Contact("Hannah Wilson", "07710308741", "hannah.wilson@work.com", savedWorkAddressBook);
        Contact savedWorkContact4 = ContactSaver.saveContact(workContact4);
        savedWorkAddressBook.addContact(savedWorkContact4);

        Contact workContact5 = new Contact("Ian Moore", "07710308742", "ian.moore@work.com", savedWorkAddressBook);
        Contact savedWorkContact5 = ContactSaver.saveContact(workContact5);
        savedWorkAddressBook.addContact(savedWorkContact5);

        Contact workContact6 = new Contact("Julia Thomas", "07710308743", "julia.thomas@work.com", savedWorkAddressBook);
        Contact savedWorkContact6 = ContactSaver.saveContact(workContact6);
        savedWorkAddressBook.addContact(savedWorkContact6);

        Contact workContact7 = new Contact("Kevin Jackson", "07710308744", "kevin.jackson@work.com", savedWorkAddressBook);
        Contact savedWorkContact7 = ContactSaver.saveContact(workContact7);
        savedWorkAddressBook.addContact(savedWorkContact7);


        System.out.println("\n---------------------------------------------------\n");
//        Great! Lets have a look at the work address book.
        savedWorkAddressBook.printAddressBook();


//        We have successfully created a user, 2 address books, and separate contacts for each.
//        We can view our address books.
        System.out.println("\n---------------------------------------------------\n");
        savedUser.printAddressBooks();

        System.out.println("\n---------------------------------------------------\n");
//        Address books are added to users addressBooks array lists allowing access to all the users content.
        savedUser.getAddressBookArrayList().get(0).printAddressBook();





        }
}

