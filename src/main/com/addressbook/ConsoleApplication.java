//package com.addressbook;
//
//import com.addressbook.dao.AddressBookSaver;
//import com.addressbook.dao.UserSaver;
//import com.addressbook.entity.AddressBook;
//import com.addressbook.entity.User;
//
//import java.util.Scanner;
//
//public class ConsoleApplication {
//
//    public static User getUser(String firstName, String lastName, String phoneNumber, String email){
//        try {
//            User user = new User(firstName, lastName, phoneNumber, email);
//            System.out.println("User created successfully");
//            return UserSaver.saveUser(user);
//
//        } catch (Exception e) {
//            System.out.println("Error creating user: " + e.getMessage());
//        }
//        return null;
//    }
//
//    public static User getAddressBook(String addressBookName, User user){
//        System.out.println("Creating address book");
//        AddressBook addressBook = new AddressBook(addressBookName, user);
//        user.addAddressBook(AddressBookSaver.saveAddressBook(addressBook));
//        return user;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Welcome to the Address Book Application");
//        System.out.println("Lets create a demo user to get started");
//        System.out.println("Enter first name: ");
//        Scanner scanner = new Scanner(System.in);
//        String firstName = scanner.nextLine();
//        System.out.println("Enter last name: ");
//        String lastName = scanner.nextLine();
//        System.out.println("Enter phone number: ");
//        String phoneNumber = scanner.nextLine();
//        System.out.println("Enter email: ");
//        String email = scanner.nextLine();
//
//        User user = getUser(firstName, lastName, phoneNumber, email);
//
//        System.out.println("Welcome " + user.getFullName());
//
//        System.out.println("What would you like to do?");
//        System.out.println("1. Create Address Book");
//        System.out.println("2. View Address Book");
//
//        int choice = scanner.nextInt();
//        String addressBookName;
//        switch (choice){
//            case 1:
//                System.out.println("Enter address book name: ");
//                addressBookName = scanner.nextLine();
//                user = getAddressBook(addressBookName, user);
//
//                break;
//            case 2:
//                System.out.println("Viewing address book");
//                user.printAddressBooks();
//                System.out.println("Okay, looks like we should make an address book");
//                System.out.println("Enter address book name: ");
//                addressBookName = scanner.nextLine();
//                user = getAddressBook(addressBookName, user);
//                break;
//            default:
//                System.out.println("Invalid choice");
//        }
//
//        System.out.println("Lets view your address books");
//        user.printAddressBooks();
//        System.out.println("Would you like to: ");
//        System.out.println("1. Add contact");
//        System.out.println("2. View contacts");
//
//        choice = scanner.nextInt();
//        switch (choice){
//            case 1:
//                System.out.println("Enter address book name: ");
//                addressBookName = scanner.nextLine();
//                AddressBook addressBook = user.findAddressBook(addressBookName);
//                if (addressBook != null){
//                    System.out.println("Enter contact name: ");
//                    String contactName = scanner.nextLine();
//                    System.out.println("Enter contact phone number: ");
//                    String contactPhoneNumber = scanner.nextLine();
//                    System.out.println("Enter contact email: ");
//                    String contactEmail = scanner.nextLine();
//                    addressBook.addContact(new Contact(contactName, contactPhoneNumber, contactEmail));
//                } else {
//                    System.out.println("Address book not found");
//                }
//                break;
//            case 2:
//                System.out.println("Enter address book name: ");
//                addressBookName = scanner.nextLine();
//                AddressBook addressBook = user.findAddressBook(addressBookName);
//                if (addressBook != null){
//                    addressBook.printContacts();
//                } else {
//                    System.out.println("Address book not found");
//                }
//                break;
//            default:
//                System.out.println("Invalid choice");
//        }
//
//    }
//
//
//}