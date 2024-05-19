package com.addressbook.app;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean Executing = true;


        while (Executing) {
            showMenu();
            System.out.println("Enter your selection from above numbers: ");
            String userChoice = scanner.next();
            switch (userChoice) {
                case "1":
                    System.out.println("Enter Contact Name : ");
                    String name = scanner.next();
                    System.out.println("Enter Contact Email: ");
                    String email = scanner.next();
                    System.out.println("Enter Contact Phone Number: ");
                    String phoneNumber = scanner.next();
                    try{
                        addressBook.addContact(new Contact(name, email, phoneNumber));
                        System.out.println("Contact successfully added.");
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("================================================");
                    enterKey();
                    break;
                case "2":
                    System.out.println("Enter Contact id: ");
                    int editId = scanner.nextInt();
                    Contact editContact = addressBook.getContactId(editId);
                    if(editContact.getId()!=0) {
                        scanner.nextLine();
                        System.out.println("Enter Contact name: ");
                        String editName = scanner.nextLine();
                        System.out.println("Enter email: ");
                        String editEmail = scanner.nextLine();
                        System.out.println("Enter phone number: ");
                        String editPhoneNumber = scanner.nextLine();
                        try {
                            addressBook.editContact(editId, editName, editEmail, editPhoneNumber);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }else {
                        System.out.println("contact not found. Please check ID.");
                    }
                    System.out.println("================================================");
                    enterKey();
                    break;
                case "7":
                    System.out.println("================================================");
                    System.out.println("Thank you for using the Address Book. Farewell!");
                    System.out.println("================================================");
                    Executing = false;
                    break;
                default:
                    System.out.println("Invalid Input, Please try again.");
                    System.out.println("================================================");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("================================================");
        System.out.println("            Address Book Application            ");
        System.out.println("================================================");
        System.out.println("Please select an option from the menu below:");
        System.out.println("================================================");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("7. Exit");
        System.out.println("================================================");
    };

    private static void enterKey() {
        System.out.println("Press the 'Enter' key to continue");
        System.out.println("================================================");

        try {
            System.in.read();
        } catch (IOException ignored) {
        }
    }



}
