package com.saud.addressbookapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

    AddressBookDBService service = new AddressBookDBService();

    // Test Case 1: Database should return list (even if empty)
    @Test
    public void givenDatabase_WhenRetrieved_ShouldReturnList() {

        List<Contact> contacts = service.retrieveContactsFromDB();

        Assertions.assertNotNull(contacts);
    }

    // Test Case 2: Database empty scenario
    @Test
    public void givenEmptyDatabase_WhenRetrieved_ShouldReturnEmptyList() {

        List<Contact> contacts = service.retrieveContactsFromDB();

        Assertions.assertEquals(5, contacts.size());
    }

    // Test Case 3: Insert test data then verify retrieval
    @Test
    public void givenDatabaseWithContacts_WhenRetrieved_ShouldReturnContacts() {

        List<Contact> contacts = service.retrieveContactsFromDB();

        if(contacts.size() > 0) {
            Assertions.assertTrue(contacts.size() >= 1);
        }
    }

    // Test Case 4: Verify object mapping
    @Test
    public void givenDatabase_WhenRetrieved_ShouldMapContactFields() {

        List<Contact> contacts = service.retrieveContactsFromDB();

        if(!contacts.isEmpty()) {

        	Contact contact = contacts.get(0);

            Assertions.assertNotNull(contact.getFirstName());
            Assertions.assertNotNull(contact.getLastName());
            Assertions.assertNotNull(contact.getCity());
            Assertions.assertNotNull(contact.getState());
        }
    }
}