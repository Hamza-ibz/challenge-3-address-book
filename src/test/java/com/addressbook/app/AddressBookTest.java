package com.addressbook.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        @DisplayName("The addContact() function should not add if phone number exist in the address book (duplicate phone numbers), throws IllegalArgumentException")
        void testContactDuplicatePhoneNumbers() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456789");

            when(contactTest2.getEmail()).thenReturn("Bob@gmail.com");
            when(contactTest2.getName()).thenReturn("Bob Tom");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest2);});
        }

        @Test
        @DisplayName("The addContact() function should not add if Email exist in the address book (duplicate email), throws IllegalArgumentException")
        void testContactDuplicateEmail() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("test@test.com");
            when(contactTest2.getName()).thenReturn("Bob Tom");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest2);});
        }

        @Test
        @DisplayName("The addContact() function should not add if the Email has the same letters but different capitalization in the address book (duplicate email), throws IllegalArgumentException")
        void testContactDuplicateEmailCapitalization() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("test");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("Test@test.com");
            when(contactTest2.getName()).thenReturn("Bob Tom");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {addressBookTest.addContact(contactTest2);});
        }


    }
    @Nested
    @DisplayName("AddressBook Search for contact test")
    class AddressBookSearchContactTests {
        private ByteArrayOutputStream outContent;
        AddressBook addressBookTest;
        Contact contactTest1;
        Contact contactTest2;

        @BeforeEach
        void setUp() {
            addressBookTest = new AddressBook();
            contactTest1 = mock(Contact.class);
            contactTest2 = mock(Contact.class);

//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
        }


        public void tearDown(){
            addressBookTest = null;
            contactTest1 = null;
            contactTest2 = null;
        }

        @Test
        @DisplayName("searchByName() should display the correct contact when the name is entered.")
        void testSearchContactsByNameDisplaysContact() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Jon Smith");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("Bob@Gmail.com");
            when(contactTest2.getName()).thenReturn("Bob Beck");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);
            addressBookTest.searchByName("Bob");


            // Assert
//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            assertEquals("Name: Bob Beck, Email: Bob@Gmail.com, Phone Number: 07123456789\n", outContent.toString());
            assertEquals(2, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("searchByName() should display message (no contact shown) when name doesn't match any contact.")
        void testSearchContactsByUnknownNameDisplaysMessage() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Jon Smith");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("Bob@Gmail.com");
            when(contactTest2.getName()).thenReturn("Bob Beck");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);
            addressBookTest.searchByName("zzz");


            // Assert
//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            assertEquals("Incorrect name. Please check value entered.\n", outContent.toString());
            assertEquals(2, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("searchByName() should display the correct contact when the name is entered regardless of whether the name is in uppercase or lowercase.")
        void testSearchContactsByCapitalizationNameStateDisplaysContact() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Jon Smith");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("bob@Gmail.com");
            when(contactTest2.getName()).thenReturn("bob beck");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);
            addressBookTest.searchByName("BOB");


            // Assert
//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            assertEquals("Name: bob beck, Email: bob@Gmail.com, Phone Number: 07123456789\n", outContent.toString());
            assertEquals(2, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("searchByName() should display message (no contact shown) when empty string entered as name.")
        void testSearchContactsByEmptyNameDisplaysMessage() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Jon Smith");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("bob@Gmail.com");
            when(contactTest2.getName()).thenReturn("bob beck");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);
            addressBookTest.searchByName("");


            // Assert
//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            assertEquals("Incorrect name. Please check value entered.\n", outContent.toString());
            assertEquals(2, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("searchByName() should still display contacts if user only type in part of a name.")
        void testSearchContactsByPartialNameDisplaysContact() {
            // Arrange
            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Jon Smith");
            when(contactTest1.getPhoneNumber()).thenReturn("07123456734");

            when(contactTest2.getEmail()).thenReturn("bob@Gmail.com");
            when(contactTest2.getName()).thenReturn("bob beck");
            when(contactTest2.getPhoneNumber()).thenReturn("07123456789");

            // Act
            addressBookTest.addContact(contactTest1);
            addressBookTest.addContact(contactTest2);
            addressBookTest.searchByName("jo");


            // Assert
//            https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
            assertEquals("Name: Jon Smith, Email: test@test.com, Phone Number: 07123456734\n", outContent.toString());
            assertEquals(2, addressBookTest.getContacts().size());
        }


    }

    @Nested
    @DisplayName("AddressBook remove form contact test")
    class AddressBookRemoveFromContact{
        AddressBook addressBookTest;
        Contact contactTest1;
        Contact contactTest2;

        @BeforeEach
        void setUp() {
            addressBookTest = new AddressBook();
            contactTest1 = mock(Contact.class);

            when(contactTest1.getEmail()).thenReturn("test@test.com");
            when(contactTest1.getName()).thenReturn("Test Test");
            when(contactTest1.getPhoneNumber()).thenReturn("077777777777");

            addressBookTest.addContact(contactTest1);

        }

        public void tearDown(){
            addressBookTest = null;
            contactTest1 = null;
            contactTest2 = null;
        }

        @Test
        @DisplayName("When removeContact() is called, The length of the contacts array should decrease by 1")
        void testRemoveContactByPhoneNumberArrayLengthDecreasedByOne() {
            // Arrange
            // Act
            addressBookTest.removeContact("077777777777");

            // Assert
            assertEquals(0, addressBookTest.getContacts().size());
        }

        @Test
        @DisplayName("Once contact is deleted, should not be able to find it when searching for contacts.")
        void testSearchingForARemovedContact() {
            // Arrange
            ByteArrayOutputStream outContent;
            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            // Act
            addressBookTest.removeContact("077777777777");
            addressBookTest.searchByName("Test");

            // Assert
            assertEquals(0, addressBookTest.getContacts().size());
            assertEquals("Incorrect name. Please check value entered.\n", outContent.toString());
        }
    }

}
