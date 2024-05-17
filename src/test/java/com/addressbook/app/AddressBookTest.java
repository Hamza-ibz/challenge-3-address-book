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
            contactTest1 = mock(Contact.class);;
            contactTest2 = mock(Contact.class);;
        }

        public void tearDown(){
            addressBookTest = null;
            contactTest1 = null;
            contactTest2 = null;
        }

        @Test
        @DisplayName("addContact() is called, the length of the contacts array should increase by 1 (in the 'AddressBook' class).")
        void testContactArrayLengthIncreasedByOne() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Test Test");
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertEquals(1, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("addContact() should add an entry to the contact arraylist<> (in the 'AddressBook' class).")
        void testContactInsertedToArrayLength() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Test Test");
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

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
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Test Test");
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

            when(contactTest2.getEmail()).thenReturn("bob@gmail.com");
            when(contactTest2.getName()).thenReturn("Bob Tom");
            when(contactTest2.getPhoneNumber()).thenReturn("07234234564");

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
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn(null);
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest1);});
        }

        @Test
        @DisplayName("The addContact() function should not allow null values for Email and throws IllegalArgumentException.")
        void testContactEmailForNullValueWhenAddContactIsCalledThrowsIllegalArgumentException() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn(null);
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest1);});
        }

        @Test
        @DisplayName("The addContact() function should not allow null values for Phone Number, throws IllegalArgumentException.")
        void testContactPhoneNumberForNullValueWhenAddContactIsCalledThrowsIllegalArgumentException() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn(null);

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest1);});
        }

        @Test
        @DisplayName("The addContact() function should not added if phone number exist in the address book (duplicate phone numbers)")
        void testContactDuplicatePhoneNumbers() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456789");
//            System.out.println(contactTest1.getId());

            when(contactTest2.getEmail()).thenReturn("Bob@gmail.com");
            when(contactTest2.getName()).thenReturn("Bob Tom");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");
//            System.out.println(contactTest2.getId());

            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest2);});
        }


    }
}
