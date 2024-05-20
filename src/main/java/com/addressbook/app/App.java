package com.addressbook.app;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Initialize scanner for user input and AddressBook instance
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean executing = true; // Flag to keep the application running

        // Load initial contacts into the address book
        loadContacts(addressBook);

        // Main loop to keep the application running
        while (executing) {
            showMenu(); // Display menu options
            System.out.println("Enter your selection from above numbers: ");
            String userChoice = scanner.next().trim(); // Get user input and trim any extra spaces

            // Switch case to handle user choices
            switch (userChoice) {
                case "1":
                    addContact(scanner, addressBook); // Add a new contact
                    break;
                case "2":
                    editContact(scanner, addressBook); // Edit an existing contact
                    break;
                case "3":
                    searchContact(scanner, addressBook); // Search for a contact by name
                    break;
                case "4":
                    removeContact(scanner, addressBook); // Remove a contact by ID
                    break;
                case "5":
                    viewAllContacts(addressBook); // View all contacts
                    break;
                case "6":
                    deleteAllContacts(scanner, addressBook); // Delete all contacts
                    break;
                case "7":
                    executing = false; // Exit the application
                    System.out.println("================================================");
                    System.out.println("Thank you for using the Address Book. See you soon!");
                    System.out.println("================================================");
                    break;
                default:

                    System.out.println("Invalid input, please try again."); // Handle invalid input
                    System.out.println("================================================");
                    enterKey(); // Wait for user to press Enter before continuing
            }
        }
        scanner.close(); // Close the scanner
    }

    // Method to add a new contact
    private static void addContact(Scanner scanner, AddressBook addressBook) {
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Contact Name: ");
        String name = scanner.nextLine(); // Get the contact name
        System.out.println("Enter Contact Email: ");
        String email = scanner.nextLine(); // Get the contact email
        System.out.println("Enter Contact Phone Number (e.g. 07*********): ");
        String phoneNumber = scanner.nextLine(); // Get the contact phone number

        // Try to add the new contact and handle any exceptions
        try {
            addressBook.addContact(new Contact(name, email, phoneNumber));
            System.out.println("Contact successfully added.");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print any error messages
        }
        System.out.println("================================================");
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to edit an existing contact
    private static void editContact(Scanner scanner, AddressBook addressBook) {
            System.out.println("Enter Contact ID: ");

        int editId = scanner.nextInt(); // Get the contact ID to edit
        Contact editContact = addressBook.getContactId(editId); // Retrieve the contact

        if (editContact.getId() != 0) { // Check if contact exists
            scanner.nextLine(); // Consume the newline character

            // Get new name, email, and phone number, allowing for unchanged values
            System.out.println("Currently name is ('" + editContact.getName() + "') ");
            System.out.println("Press 'Enter' key to leave it unchanged.");
            System.out.println("Enter New Contact Name:");
            String editName = scanner.nextLine();
            editName = editName.equalsIgnoreCase("") ? editContact.getName() : editName;

            System.out.println("Currently Email is ('" + editContact.getEmail() + "') ");
            System.out.println("Press 'Enter' key to leave it unchanged.");
            System.out.println("Enter New Contact Email:");
            String editEmail = scanner.nextLine();
            editEmail = editEmail.equalsIgnoreCase("") ? editContact.getEmail() : editEmail;

            System.out.println("Currently Phone number is ('" + editContact.getPhoneNumber() + "') ");
            System.out.println("Press 'Enter' key to leave it unchanged.");
            System.out.println("Enter New Contact Phone number:");
            String editPhoneNumber = scanner.nextLine();
            editPhoneNumber = editPhoneNumber.equalsIgnoreCase("") ? editContact.getPhoneNumber() : editPhoneNumber;

            // Try to edit the contact and handle any exceptions
            try {
                addressBook.editContact(editId, editName, editEmail, editPhoneNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Print any error messages
            }
        } else {
            System.out.println("Contact not found. Please check ID."); // Handle case where contact ID is not found
        }
        System.out.println("================================================");
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to search for a contact by name
    private static void searchContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("Enter full/partial name to search: ");
        String searchName = scanner.next(); // Get the name to search
        System.out.println("Search results: ");
        addressBook.searchByName(searchName); // Perform the search
        System.out.println("================================================");
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to remove a contact by ID
    private static void removeContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt(); // Get the contact ID to remove
        addressBook.removeContact(id); // Remove the contact
        System.out.println("================================================");
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to view all contacts
    private static void viewAllContacts(AddressBook addressBook) {
        System.out.println("View All Contacts: ");
        System.out.println(addressBook.viewContacts()); // Display all contacts
        System.out.println("================================================");
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to delete all contacts
    private static void deleteAllContacts(Scanner scanner, AddressBook addressBook) {
        System.out.println("Are you sure you want to delete all your contacts? Enter: y(Yes) or n(No)");

        // Get user confirmation
        String deleteOption = scanner.next();
        if (deleteOption.equalsIgnoreCase("y") || deleteOption.equalsIgnoreCase("yes")) {
            addressBook.deletionService(); // Delete all contacts
        } else {
            System.out.println("Cancelling contacts deletion."); // Cancel deletion
        }
        enterKey(); // Wait for user to press Enter before continuing
    }

    // Method to show the menu options
    public static void showMenu() {
        System.out.println("================================================");
        System.out.println("            Address Book Application            ");
        System.out.println("================================================");
        System.out.println("Please select an option from the menu below:");
        System.out.println("================================================");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. Remove Contact");
        System.out.println("5. View All Contacts");
        System.out.println("6. Delete All Contacts");
        System.out.println("7. Exit");
        System.out.println("================================================");
    }

    // Method to wait for user to press Enter
    private static void enterKey() {
        System.out.println("Press the 'Enter' key to continue");
        try {
            System.in.read(); // Wait for user input
        } catch (IOException ignored) {
        }
    }

    // Method to load initial contacts into the address book
    private static void loadContacts(AddressBook addressBook) {
        // Create initial contacts
        Contact contact1 = new Contact("Hamza J", "aga@aga.com", "07777777777");
        Contact contact2 = new Contact("Hamza E", "don@son.com", "07666666666");
        Contact contact3 = new Contact("Hamza F", "ke@mit.com", "07555555555");

        // Add contacts to the address book
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
    }
}
