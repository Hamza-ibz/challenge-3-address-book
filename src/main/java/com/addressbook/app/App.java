package com.addressbook.app;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean Executing = true;
        loadContacts(addressBook);

        while (Executing) {
            showMenu();
            System.out.println("Enter your selection from above numbers: ");
            String userChoice = scanner.next().trim();
            switch (userChoice) {
                case "1":
                    scanner.nextLine();
                    System.out.println("Enter Contact Name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Contact Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter Contact Phone Number (e.g. 07*********): ");
                    String phoneNumber = scanner.nextLine();
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

                        System.out.println("Currently name is ('"+editContact.getName()+"') ");
                        System.out.println("Press 'Enter' key to leave it unchanged.");
                        System.out.println("Enter New Contact name:");
                        String editName = scanner.nextLine();
                        editName = editName.equalsIgnoreCase("") ? editContact.getName() : editName;

                        System.out.println("Currently Email is ('"+editContact.getEmail()+"') ");
                        System.out.println("Press 'Enter' key to leave it unchanged.");
                        System.out.println("Enter New Contact Email:");
                        String editEmail = scanner.nextLine();
                        editEmail = editEmail.equalsIgnoreCase("") ? editContact.getEmail() : editEmail;

                        System.out.println("Currently Phone number is ('"+editContact.getPhoneNumber()+"') ");
                        System.out.println("Press 'Enter' key to leave it unchanged.");
                        System.out.println("Enter New Contact Phone number:");
                        String editPhoneNumber = scanner.nextLine();
                        editPhoneNumber = editPhoneNumber.equalsIgnoreCase("") ? editContact.getPhoneNumber() : editPhoneNumber;

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
                case "3":
                    System.out.println("Enter full/partial of the name to search : ");
                    String searchName = scanner.next();
                    System.out.println("Search results: ");
                    addressBook.searchByName(searchName);
                    System.out.println("================================================");
                    enterKey();
                    break;
                case "4":
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    addressBook.removeContact(id);
                    System.out.println("================================================");
                    enterKey();
                    break;
                case "5":
                    System.out.println("View All Contacts: ");
                    System.out.println(addressBook.viewContacts());
                    System.out.println("================================================");
                    enterKey();
                    break;
                case "7":
                    System.out.println("================================================");
                    System.out.println("Thank you for using the Address Book. See you Soon!");
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
        System.out.println("3. Search Contact");
        System.out.println("4. Remove Contact");
        System.out.println("5. View All Contacts");
        System.out.println("7. Exit");
        System.out.println("================================================");
    };

    private static void enterKey() {
        System.out.println("Press the 'Enter' key to continue");

        try {
            System.in.read();
        } catch (IOException ignored) {
        }
    }

    private static void loadContacts(AddressBook addressBook) {

        Contact contact1 = new Contact("Hamza j", "aga@aga.com", "07777777777");
        Contact contact2 = new Contact("Hamza e", "don@son.com","07666666666");
        Contact contact3 = new Contact("Hamza f", "ke@mit.com", "07555555555");

        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
    }



}
