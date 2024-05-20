package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Nested class for testing the constructor of the Contact class
    @Nested
    @DisplayName("Constructor Test for Contact")
    class ContactConstructorTest {

        // Test method to verify if the constructor correctly sets values when valid input is provided
        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void testConstructorSetsCorrectValue() {
            // Arrange (setup any preconditions or inputs)

            // Act (call the method under test)
            Contact contact = new Contact("Kevin D", "kevin@gmail.com", "07348290000");

            // Assert (verify the results)
            assertAll("Constructor sets correct values",
                    () -> assertEquals("Kevin D", contact.getName()),
                    () -> assertEquals("kevin@gmail.com", contact.getEmail()),
                    () -> assertEquals("07348290000", contact.getPhoneNumber())
            );
        }
    }

    // Nested class for testing the validation logic in the Contact class
    @Nested
    @DisplayName("Tests validation for name, phone number and email")
    class ContactValidationTest {

        // Test to ensure an exception is thrown for empty name
        @Test
        @DisplayName("Test for validation on name, should throw Exception")
        public void testValidationOnNameThrowsExceptionForEmptyName() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateName(""));
            assertEquals("Name cannot be empty or null", exception.getMessage());
        }

        // Test to ensure an exception is thrown for invalid email format
        @Test
        @DisplayName("Test for validation on Email should throw Exception")
        public void testValidationOnEmailShouldThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("ThereIsNoEmailSymbolHere"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for invalid phone number format
        @Test
        @DisplayName("Test for validation on phone number should throw Exception")
        public void testValidationOnPhoneNumberShouldThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("12345678909"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        //**

        // Test to ensure an exception is thrown for email addresses containing only the domain portion
        @Test
        @DisplayName("Test for exception for email addresses containing only the domain portion.")
        public void testExceptionForEmailAddressesContainingOnlyTheDomainPortion() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("@gmail.com"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for null email addresses
        @Test
        @DisplayName("Test for an exception for a null email address.")
        public void testExceptionForNullEmailAddress() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail(null));
            assertEquals("Email address cannot be empty or null", exception.getMessage());
        }

        // Test to ensure an exception is thrown for email addresses without a domain part
        @Test
        @DisplayName("Test for an exception for an email address that lacks a domain part.")
        public void testExceptionForEmailAddressNoDomainPart() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("captain@"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for empty email addresses
        @Test
        @DisplayName("Test for an exception for an empty email address.")
        public void testForAnExceptionForAnEmptyEmailAddress() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail(""));
            assertEquals("Email address cannot be empty or null", exception.getMessage());
        }

        // Test to ensure an exception is thrown for email addresses without 'com' or 'co.uk'
        @Test
        @DisplayName("Test for an exception for an email address without 'com' or 'co.uk'.")
        public void testForAnExceptionForAnEmailAddressWithoutEndPart() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("captain@gmail"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        //**

        // Test to ensure an exception is thrown for phone numbers containing more than 11 digits
        @Test
        @DisplayName("Test for an exception for a phone number containing more than 11 digits.")
        public void testForAnExceptionForPhoneNumberContainingMoreThan11Digits() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("073456789101112"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for phone numbers containing non-digit characters
        @Test
        @DisplayName("Test for an exception for a phone number containing non-digit characters.")
        public void testForAnExceptionForPhoneNumberContainingNonDigitCharacters() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("076-246-246"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for empty phone numbers
        @Test
        @DisplayName("Test for an exception for an empty phone number.")
        public void testForAnExceptionForAnEmptyPhoneNumber() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber(""));
            assertEquals("Phone number cannot be empty or null", exception.getMessage());
        }

        // Test to ensure an exception is thrown for phone numbers containing fewer than 11 digits
        @Test
        @DisplayName("Test for an exception for a phone number containing fewer than 11 digits.")
        public void testForAnExceptionForPhoneNumberContainingFewerThan11Digits() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("0712345"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        // Test to ensure an exception is thrown for phone numbers that do not start with the UK format
        @Test
        @DisplayName("Test for an exception for a phone number that does not start with UK format.")
        public void testForAnExceptionForPhoneNumberDoesNotStartWithUkFormat() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("45989878765"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }
    }
}
