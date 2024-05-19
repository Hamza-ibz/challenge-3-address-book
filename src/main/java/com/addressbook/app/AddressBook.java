package com.addressbook.app;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if(contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Name.");
        }
        if(contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Email.");
        }
        if(contact.getPhoneNumber() == null || contact.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Null or empty value given to Phone Number.");
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

    public void removeContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId()==id) {
                contacts.remove(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchByName(String name) {
        ArrayList<Contact> contactsMatch = SortByName(name);
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }
    public void searchByPhoneNumber(String phoneNumber) {
        ArrayList<Contact> contactsMatch = SortByName(phoneNumber);
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }
    public void searchByEmail(String email) {
        ArrayList<Contact> contactsMatch = SortByName(email);
        for (Contact contact : contactsMatch) {
            System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }



    private ArrayList<Contact> SortByName(String name) {
        String nameLowerCase = name.toLowerCase();
        ArrayList<Contact> contactsMatch = new ArrayList<>();
        for (Contact contact : contacts) {
            boolean containsName = contact.getName().toLowerCase().trim().contains(nameLowerCase.trim());

            if(nameLowerCase==""){
                containsName=false;
            }
            if (containsName) {
                contactsMatch.add(contact);
            }
        }
        if(contactsMatch.isEmpty()){
            System.out.println("Incorrect name. Please check value entered.");
        }
//        https://stackoverflow.com/questions/19471005/sorting-an-arraylist-of-objects-alphabetically
        Collections.sort(contactsMatch, new Comparator<Contact>() {
            public int compare(Contact v1, Contact v2) {
                return v1.getName().compareTo(v2.getName());
            }
        });
        return contactsMatch;
    }


    public void editContact(int id, String newName, String NewEmail, String newPhoneNumber) {
        boolean idFound = false;
        boolean phoneNumberOrEmailAlreadyExists = false;

        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                idFound = true;
                if(!(emailAlreadyExists(NewEmail) || phoneNumberAlreadyExists(newPhoneNumber))) {
                    phoneNumberOrEmailAlreadyExists = false;
                    contact.setName(newName);
                    contact.setEmail(NewEmail);
                    contact.setPhoneNumber(newPhoneNumber);
                    System.out.println("Name: " + newName + ", Email: " + NewEmail + ", Phone Number: " + newPhoneNumber);
                    return;
                }
                phoneNumberOrEmailAlreadyExists = true;
            }

        }
        if(!idFound) {
            System.out.println("contact not found. Please check ID.");
        }

        if(phoneNumberOrEmailAlreadyExists) {
            System.out.println("Phone number or email already exist. Please check details.");
        }
    }

    public String viewContacts(){
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact a, Contact b) {
                return a.getId() - b.getId();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============================================================================\n");
        for (Contact contact : contacts) {
            String contactInfo = "ID: " + contact.getId() +  " Name: " + contact.getName()  + ", Phone: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail();
            stringBuilder.append(contactInfo).append("\n");
        }
        stringBuilder.append("============================================================================\n");
        return stringBuilder.toString();
    }

    public void deletionService() {
        contacts.clear();
        System.out.println("All contacts are deleted. Address book is empty.");
    }
}
