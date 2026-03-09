package com.saud.addressbookapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

    public List<Contact> retrieveContactsFromDB() {

        List<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM contacts";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Contact contact = new Contact(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                );

                contacts.add(contact);
            }

        } catch (Exception e) {

            System.out.println("Error retrieving contacts: " + e.getMessage());
        }

        return contacts;
    }
}