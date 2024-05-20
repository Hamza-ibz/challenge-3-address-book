package com.addressbook.app;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBook {

    // List to store contact objects
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Adds a new contact to the address book after performing validations
    public void addContact(Contact contact) {
        // Check if the contact's name is null or empty
        if (contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        // Check if the contact's email is null or empty
        if (contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Email.");
        }
        // Check if the contact's phone number is null or empty
        if (contact.getPhoneNumber() == null || contact.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Phone Number.");
        }
        // Check if the phone number already exists
        if (phoneNumberAlreadyExists(contact.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is a duplicate");
        }
        // Check if the email already exists
        if (emailAlreadyExists(contact.getEmail())) {
            throw new IllegalArgumentException("Email is a duplicate");
        }
        // Add the contact to the contacts list
        this.contacts.add(contact);
    }

    // Returns the list of contacts
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    // Retrieves a contact by ID
    public Contact getContactId(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        // If no contact found, return a new empty Contact object
        return new Contact();
    }

    // Checks if a phone number already exists in the contacts list, excluding a specific ID
    public boolean phoneNumberAlreadyExists(int id, String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getId() != 0 && contact.getId() == id) {
                continue;
            }
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Checks if an email already exists in the contacts list, excluding a specific ID
    public boolean emailAlreadyExists(int id, String email) {
        for (Contact contact : contacts) {
            if (contact.getId() != 0 && contact.getId() == id) {
                continue;
            }
            if (contact.getEmail().toLowerCase().equals(email.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Checks if a phone number already exists in the contacts list
    public boolean phoneNumberAlreadyExists(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Checks if an email already exists in the contacts list
    public boolean emailAlreadyExists(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().toLowerCase().equals(email.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Removes a contact by ID
    public void removeContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                System.out.println("Contact with ID " + id + " successfully removed.");
                return;
            }
        }
        System.out.println("Contact not found. Please check the ID input.");
    }

    // Search contacts by name
    public void searchByName(String name) {
        ArrayList<Contact> contactsMatch = SortByName(name);
        for (Contact contact : contactsMatch) {
            System.out.println("Id: " + contact.getId() + " | " + " Name: " + contact.getName() + " | " + " Email: " + contact.getEmail() + " | " + " Phone Number: " + contact.getPhoneNumber());
        }
    }

    // Searches contacts by phone number
    public void searchByPhoneNumber(String phoneNumber) {
        ArrayList<Contact> contactsMatch = SortByName(phoneNumber);
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }

    // Searches contacts by email
    public void searchByEmail(String email) {
        ArrayList<Contact> contactsMatch = SortByName(email);
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }

    // Helper method to sort and filter contacts by name
    private ArrayList<Contact> SortByName(String name) {
        String nameLowerCase = name.toLowerCase();
        ArrayList<Contact> contactsMatch = new ArrayList<>();
        for (Contact contact : contacts) {
            boolean containsName = contact.getName().toLowerCase().trim().contains(nameLowerCase.trim());
            if (nameLowerCase == "") {
                containsName = false;
            }
            if (containsName) {
                contactsMatch.add(contact);
            }
        }
        if (contactsMatch.isEmpty()) {
            System.out.println("Incorrect name. Please check value entered.");
        }
        // Sort the contacts by name alphabetically
        contactsMatch.sort(Comparator.comparing(Contact::getName));
        return contactsMatch;
    }

    // Edits a contact's details by ID
    public void editContact(int id, String newName, String newEmail, String newPhoneNumber) {
        boolean idFound = false;
        boolean phoneNumberOrEmailAlreadyExists = false;
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                idFound = true;
                if (!(emailAlreadyExists(id, newEmail) || phoneNumberAlreadyExists(id, newPhoneNumber))) {
                    phoneNumberOrEmailAlreadyExists = false;
                    contact.setName(newName);
                    contact.setEmail(newEmail);
                    contact.setPhoneNumber(newPhoneNumber);
                    System.out.println("Successfully Completed:-");
                    System.out.println("Name: " + newName + ", Email: " + newEmail + ", Phone Number: " + newPhoneNumber);
                    return;
                }
                phoneNumberOrEmailAlreadyExists = true;
            }
        }
        if (!idFound) {
            System.out.println("Contact not found. Please check ID.");
        }
        if (phoneNumberOrEmailAlreadyExists) {
            System.out.println("Phone number or email already exist. Please check details.");
        }
    }

    // Returns a string representation of all contacts
    public String viewContacts() {
        // Sort contacts by ID
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact a, Contact b) {
                return a.getId() - b.getId();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============================================================================\n");
        for (Contact contact : contacts) {
            String contactInfo = "ID: " + contact.getId() + ", Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail();
            stringBuilder.append(contactInfo).append("\n");
        }
        if (contacts.isEmpty()) {
            System.out.println("There are no contacts stored.");
        }
        stringBuilder.append("============================================================================\n");
        return stringBuilder.toString();
    }

    // Clears all contacts from the address book
    public void deletionService() {
        contacts.clear();
        System.out.println("All contacts are deleted. Address book is empty.");
    }
}
