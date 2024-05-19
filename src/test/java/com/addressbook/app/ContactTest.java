package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Nested
    @DisplayName("Constructor Test for Contact")
    class ContactConstructorTest {

        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void testConstructorSetsCorrectValue() {
            // Arrange

            // Act
            Contact Contact = new Contact("Kevin D", "kevin@gmail.com", "07348290000");

            // Assert
            assertAll("Constructor sets correct values",
                    () -> assertEquals("Kevin D", Contact.getName()),
                    () -> assertEquals("kevin@gmail.com", Contact.getEmail()),
                    () -> assertEquals("07348290000", Contact.getPhoneNumber())
            );
        }
    }

    @Nested
    @DisplayName("Tests validation for name, phone number and email")
    class ContactValidationTest {

        @Test
        @DisplayName("Test for validation on name, should throw Exception")
        public void testValidationOnNameThrowsExceptionForEmptyName() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateName(""));
            assertEquals("Name cannot be empty or null", exception.getMessage());
        }

        @Test
        @DisplayName("Test for validation on Email should throw Exception")
        public void TestForValidationOnEmailShouldThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("ThereIsNoEmailSymbolHere"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        @Test
        @DisplayName("Test for validation on phone number should throw Exception")
        public void TestForValidationOnPhoneNumberShouldThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("12345678909"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        //**

        @Test
        @DisplayName("Test for exception for email addresses containing only the domain portion.")
        public void testExceptionForEmailAddressesContainingOnlyTheDomainPortion() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("@gmail.com"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for a null email address.")
        public void testExceptionForNullEmailAddress() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail(null));
            assertEquals("Email address cannot be empty or null", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for an email address that lacks a domain part.")
        public void testExceptionForEmailAddressNoDomainPart() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("captain@"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for an empty email address.")
        public void testForAnExceptionForAnEmptyEmailAddress() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail(""));
            assertEquals("Email address cannot be empty or null", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for an email address without 'com' or 'co.uk'.")
        public void testForAnExceptionForAnEmailAddressWithoutEndPart() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validateEmail("captain@gmail"));
            assertEquals("Email address must match email address standard format", exception.getMessage());
        }

        //**

        @Test
        @DisplayName("Test for an exception for a phone number containing more than 11 digits.")
        public void testForAnExceptionForPhoneNumberContainingMoreThan11Digits() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("073456789101112"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }
        @Test
        @DisplayName("Test for an exception for a phone number containing non-digit characters.")
        public void testForAnExceptionForPhoneNumberContainingNonDigitCharacters() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("076-246-246"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for an empty phone number.")
        public void testForAnExceptionForAnEmptyPhoneNumber() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber(""));
            assertEquals("Phone number cannot be empty or null", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for a phone number containing fewer than 11 digits.")
        public void testForAnExceptionForPhoneNumberContainingFewerThan11Digits() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("0712345"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }

        @Test
        @DisplayName("Test for an exception for a phone number that does not start with uk format.")
        public void testForAnExceptionForPhoneNumberDoesNotStartWithUkFormat() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Contact.validatePhoneNumber("45989878765"));
            assertEquals("Phone number must match UK phone number format", exception.getMessage());
        }


    }
}
