package com.addressbook.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook addContact tests")
    class AddressBookAddContactTests {
        AddressBook addressBookTest;
        Contact contactTest1;
        Contact contactTest2;

        @BeforeEach
        void setUp() {
            addressBookTest = new AddressBook();
            contactTest1 = new Contact("Bob Tom", "Bob@test.com", "07777777777");
            contactTest2 = new Contact("Adam Smith", "Adam@test.com", "07666666666");
        }

        @Test
        @DisplayName("addContact() is called, the length of the contacts array should increase by 1 (in the 'AddressBook' class).")
        void testContactArrayLengthIncreasedByOne() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getEmail()).thenReturn("test@test.com");
            when(contact.getName()).thenReturn("Test Test");
            when(contact.getPhoneNumber()).thenReturn("077777777777");

            // Act
            addressBook.addContact(contact);

            // Assert
            assertEquals(1, addressBook.getContacts().size());
        }

        @Test
        @DisplayName("addContact() should add an entry to the contact arraylist<> (in the 'AddressBook' class).")
        void testContactInsertedToArrayLength() {
            // Arrange
            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertEquals(1, addressBookTest.getContacts().size());
            assertTrue(addressBookTest.getContacts().contains(contactTest1));
        }

        @Test
        @DisplayName("After adding a contact, the latest contact in the arraylist<> should be the one you just added.")
        void testContactAddedIsLastElementInArrayLength() {
            // Arrange
            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);

            // Assert
            assertEquals(contactTest2, addressBookTest.getContacts().get(addressBookTest.getContacts().size() - 1));
        }

        @Test
        @DisplayName("The addContact() function should not allow null values for Name and throws IllegalArgumentException.")
        void testContactNameForNullValueWhenAddContactIsCalledThrowsIllegalArgumentException() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = mock(Contact.class);
            when(testContact.getEmail()).thenReturn("test@test.com");
            when(testContact.getName()).thenReturn(null);
            when(testContact.getPhoneNumber()).thenReturn("07828374928");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {testAddressBook.addContact(testContact);});
        }


    }
}
