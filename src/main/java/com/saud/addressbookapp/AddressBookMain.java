package com.saud.addressbookapp;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Contact contact = new Contact(
                "Saud",
                "Saud",
                "Bhopal",
                "Bhopal",
                "MP",
                "462022",
                "9876543210",
                "saud@gmail.com"
        );

        contact.displayContact();
    }
}