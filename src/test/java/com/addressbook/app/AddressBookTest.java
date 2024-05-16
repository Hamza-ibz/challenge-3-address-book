package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook addContact tests")
    class AddressBookAddContactTests {
        @Test
        @DisplayName("addContact() should add an entry to the contact arraylist<> (in the 'AddressBook' class).")
        void testContactArrayLengthIncreasedByOne() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getEmail()).thenReturn("test@test.com");
            when(contact.getName()).thenReturn("Test Test");
            when(contact.getPhoneNumber()).thenReturn("077777777777");

            // Act
            addressBook.addContact(contact);
            System.out.println(contact.getId());

            // Assert
            assertEquals(1, addressBook.getContacts().size());
        }


    }
}
