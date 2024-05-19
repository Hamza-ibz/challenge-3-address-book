package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Nested
    @DisplayName("AddressBook addContact tests")
    class ContactConstructorTest {

        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void testConstructorSetsCorrectValue() {
            // Arrange

            // Act
            Contact Contact = new Contact("Kevin D","kevin@gmail.com","07348290000");

            // Assert
            assertAll("Constructor sets correct values",
                    () -> assertEquals("Kevin D", Contact.getName()),
                    () -> assertEquals("kevin@gmail.com", Contact.getEmail()),
                    () -> assertEquals("07348290000", Contact.getPhoneNumber())
            );
        }

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




    }
}
