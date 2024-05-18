package com.addressbook.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if(contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(contact.getPhoneNumber() == null || contact.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(phoneNumberAlreadyExists(contact.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is a duplicate");
        }
        if(emailAlreadyExists(contact.getEmail())) {
            throw new IllegalArgumentException("Email is a duplicate");
        }
        this.contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public boolean phoneNumberAlreadyExists(String phoneNumber) {
        for(Contact contact : contacts) {
            if(contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailAlreadyExists(String email) {
        for(Contact contact : contacts) {
            if(contact.getEmail().toLowerCase().equals(email.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void searchByName(String name) {
        ArrayList<Contact> contactsMatch = SortByName(name);
        printContactsSorted(contactsMatch);
    }

    private ArrayList<Contact> SortByName(String name) {
        String nameLowerCase = name.toLowerCase();
        ArrayList<Contact> contactsMatch = new ArrayList<>();
        for (Contact contact : contacts) {
            boolean containsName = contact.getName().toLowerCase().contains(nameLowerCase);
            if (containsName) {
                contactsMatch.add(contact);
            }
        }
        if(contactsMatch.isEmpty()){
            System.out.println("No name found.");
        }
//        https://stackoverflow.com/questions/19471005/sorting-an-arraylist-of-objects-alphabetically
        Collections.sort(contactsMatch, new Comparator<Contact>() {
            public int compare(Contact v1, Contact v2) {
                return v1.getName().compareTo(v2.getName());
            }
        });
        return contactsMatch;
    }

    private void printContactsSorted(ArrayList<Contact> contactsMatch) {
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }
}
