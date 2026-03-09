package com.saud.addressbookapp;

import java.util.ArrayList;
import java.util.Map;

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();

    
    // Add contact
    public void addContact(Contact contact) {

        boolean duplicate = contactList
                .stream()
                .anyMatch(existingContact -> existingContact.equals(contact));

        if (duplicate) {
            System.out.println("Duplicate Contact! Person already exists.");
            return;
        }

        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Display contact
    public void displayContacts() {

        if (contactList.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        contactList.forEach(contact -> {
            contact.displayContact();
            System.out.println("-------------------");
        });
    }

    // Edit contact
    public void editContact(String name) {

        contactList.stream()
                .filter(contact -> contact.firstName.equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(contact -> {

                    System.out.println("Contact found. Updating details...");

                }, () -> System.out.println("Contact not found"));
    }

    // Delete contact
    public void deleteContact(String name) {

        boolean removed = contactList.removeIf(contact ->
                contact.firstName.equalsIgnoreCase(name));

        if (removed)
            System.out.println("Contact deleted successfully");
        else
            System.out.println("Contact not found");
    }
    
    
    
}