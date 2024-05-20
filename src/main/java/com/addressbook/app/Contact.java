package com.addressbook.app;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Contact {
    private int id = 0;  // Unique identifier for each contact
    private String email;
    private String name;
    private String phoneNumber;
    private static AtomicInteger idUnique = new AtomicInteger(1);  // Ensures unique ID across all instances

    // Constructor that validates and sets the contact's properties
    public Contact(String name, String email, String phoneNumber) {
        validateName(name);  // Validate the name
        validatePhoneNumber(phoneNumber);  // Validate the phone number
        validateEmail(email);  // Validate the email
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = idUnique.getAndIncrement();  // Assign a unique ID
    }

    // Default constructor
    public Contact() {}

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email with validation
    public void setEmail(String email) {
        validateEmail(email);  // Validate the email
        this.email = email;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String name) {
        validateName(name);  // Validate the name
        this.name = name;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phone number with validation
    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);  // Validate the phone number
        this.phoneNumber = phoneNumber;
    }

    // Validation for name
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
    }

    // Validation for email
    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be empty or null");
        }

        //https://www.akto.io/tools/email-regex-Java-tester
        // Validate email format using regex
        if (!email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email address must match email address standard format");
        }
    }

    // Validation for phone number
    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty or null");
        }
//    https://stackoverflow.com/questions/11518035/regular-expression-for-gb-based-and-only-numeric-phone-number
        // Validate UK phone number format using regex
        if (!phoneNumber.trim().matches("^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$")) {
            throw new IllegalArgumentException("Phone number must match UK phone number format");
        }
    }
}
