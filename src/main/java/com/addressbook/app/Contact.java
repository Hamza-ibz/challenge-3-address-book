package com.addressbook.app;

import java.util.Arrays;
import java.util.Objects;

public class Contact {
    private int id = 0;
    private String email;
    private String name;
    private String phoneNumber;
    private static int idUnique = 1;

    public Contact(String name, String email, String phoneNumber) {
        validateName(name);
        validatePhoneNumber(phoneNumber);
        validateEmail(email);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = idUnique;
        idUnique++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be empty or null");
        }

//        https://www.akto.io/tools/email-regex-Java-tester
        if (!email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email address must match email address standard format");
        }
    }

//    https://stackoverflow.com/questions/11518035/regular-expression-for-gb-based-and-only-numeric-phone-number
    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty or null");
        }

        if (!phoneNumber.trim().matches("^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$")) {
            throw new IllegalArgumentException("Phone number must match UK phone number format");
        }
    }
}
