package com.saud.addressbookapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Dictionary of AddressBookName -> AddressBook
        Map<String, AddressBook> addressBooks = new HashMap<>();
        

        System.out.println("Welcome to Address Book System");

        while (true) {

            System.out.println("\n1. Create New Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Search Person By City");
            System.out.println("7. Search Person By State");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("Enter Address Book Name:");
                    String bookName = sc.nextLine();

                    if(addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists");
                    } else {
                        addressBooks.put(bookName, new AddressBook());
                        System.out.println("Address Book created successfully");
                    }

                    break;

                case 2:

                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();

                    AddressBook book = addressBooks.get(bookName);

                    if(book == null) {
                        System.out.println("Address Book not found");
                        break;
                    }

                    System.out.println("Enter First Name:");
                    String firstName = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String lastName = sc.nextLine();

                    System.out.println("Enter Address:");
                    String address = sc.nextLine();

                    System.out.println("Enter City:");
                    String city = sc.nextLine();

                    System.out.println("Enter State:");
                    String state = sc.nextLine();

                    System.out.println("Enter Zip:");
                    String zip = sc.nextLine();

                    System.out.println("Enter Phone:");
                    String phone = sc.nextLine();

                    System.out.println("Enter Email:");
                    String email = sc.nextLine();

                    Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);

                    book.addContact(contact);

                    break;

                case 3:

                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();

                    book = addressBooks.get(bookName);

                    if(book != null)
                        book.displayContacts();
                    else
                        System.out.println("Address Book not found");

                    break;

                case 4:

                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();

                    book = addressBooks.get(bookName);

                    if(book == null) {
                        System.out.println("Address Book not found");
                        break;
                    }

                    System.out.println("Enter name to edit:");
                    String editName = sc.nextLine();

                    book.editContact(editName);

                    break;

                case 5:

                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();

                    book = addressBooks.get(bookName);

                    if(book == null) {
                        System.out.println("Address Book not found");
                        break;
                    }

                    System.out.println("Enter name to delete:");
                    String deleteName = sc.nextLine();

                    book.deleteContact(deleteName);

                    break;
                
                case 6:

                    System.out.println("Enter City:");
                    String cityName = sc.nextLine();

                    AddressBook.searchPersonByCity(addressBooks, cityName);
                    break;    

                case 7:

                    System.out.println("Enter State:");
                    String stateName = sc.nextLine();

                    AddressBook.searchPersonByState(addressBooks, stateName);

                    break;
                    
                case 8:

                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}