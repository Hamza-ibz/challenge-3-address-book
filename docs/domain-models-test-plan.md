# Domain Models, Class Diagrams and Test Plan

## Task 2 and Task 3

### User Stories and Domain Models

#### User story 1:-

As a user, <br>
I want to be able to add a contact to the address book (name, phone number and email address), <br>
So that I can save the contact for future use. <br>

|   Object    |                          Properties                           |     Messages     | Output  |
| :---------: | :-----------------------------------------------------------: | :--------------: | :-----: |
| AddressBook |                 contacts @ArrayList<Contact>                  |   addContact()   |  @void  |
|   Contact   |                         name @String                          |    setName()     | @String |
|             |                         email @String                         |    setEmail()    | @String |
|             |                      phoneNumber @String                      | setPhoneNumber() | @String |
|             |                            id @int                            |                  |  @int   |
|             | constructor(name @String, email @String, phoneNumber @String) |                  |  @void  |

##### Test Cases:-
- addContact() should add an entry to the contact arraylist<>.
- When addContact() is called, the length of the contacts array should increase by 1.
- After adding a contact, the latest contact in the array should be the one you just added.
- The addContact() function should not allow null values.
- If a phone number already exist in the address book, you can't add the contact.
- If an email address already exist in the address book, you can't add the contact.
- Even if the email address has the same letters but different capitalization, you still can't add the contact.


#### User story 2:-

As a user, <br>
I want to be able to search for a contact by name, <br>
So that I can save time finding the contact. <br>

|   Object    |                          Properties                           |     Messages     | Output  |
| :---------: | :-----------------------------------------------------------: | :--------------: | :-----: |
| AddressBook |                 contacts @ArrayList<Contact>                  |  searchByName()  | @String |
|   Contact   |                         name @String                          |    getName()     | @String |
|             |                         email @String                         |    getEmail()    | @String |
|             |                      phoneNumber @String                      | getPhoneNumber() | @String |
|             |                            id @int                            |                  |  @int   |
|             | constructor(name @String, email @String, phoneNumber @String) |                  |  @void  |

##### Test Cases:-
- searchContacts() should display the correct contact when the name is entered.
- If you type in a name that doesn't match any contact, it will give an error message.
- It should find contacts regardless of whether the name is in uppercase or lowercase.
- If you enter empty string, it will give an error message.
- Even if you only type in part of a name, it should still find the right contacts.


#### User story 3:-

As a user, <br>
I want to be able to remove a contact from the address book, <br>
So that I can the address book does not contain unnecessary contacts. <br>

|   Object    |                          Properties                           |     Messages     | Output  |
| :---------: | :-----------------------------------------------------------: | :--------------: | :-----: |
| AddressBook |                 contacts @ArrayList<Contact>                  | removeContact()  |  @void  |
|   Contact   |                         name @String                          |    getName()     | @String |
|             |                         email @String                         |    getEmail()    | @String |
|             |                      phoneNumber @String                      | getPhoneNumber() | @String |
|             |                            id @int                            |                  |  @int   |
|             | constructor(name @String, email @String, phoneNumber @String) |                  |  @void  |

##### Test Cases:-
- The length of the contacts array should decrease by 1 (When removeContact() is called).
- Every contact in the list should have its own special ID.
- Once you delete a contact, you shouldn't be able to find it anymore when searching for contacts.
- If you try to delete a contact with an ID that doesn't exist, you'll get an error message.
- The contact that was removed should no longer be in the contacts array (When removeContact() is called).

#### User story 4:-

As a user, <br>
I want to be able to edit contact details, <br>
So that I can keep the contact information up to date. <br>

|   Object    |                          Properties                           |     Messages     | Output  |
| :---------: | :-----------------------------------------------------------: | :--------------: | :-----: |
| AddressBook |                 contacts @ArrayList<Contact>                  |  editContact()   |  @void  |
|   Contact   |                         name @String                          |    setName()     | @String |
|             |                         email @String                         |    setEmail()    | @String |
|             |                      phoneNumber @String                      | setPhoneNumber() | @String |
|             |                            id @int                            |                  |  @int   |
|             | constructor(name @String, email @String, phoneNumber @String) |                  |  @void  |

##### Test Cases:-
- Use editContact() to modify contact details by specifying the contact's ID.
- If you try to edit a contact with an ID that doesn't exist, you'll receive an error message.
- The function should reject any changes that don't meet the required format.
- If a null value is passed as the name parameter to editContact, the contact should not be updated.
- If the phone number provided to editContact already exists in the address book, the contact should not be updated.
- Similarly, if the email passed to editContact already exists in the address book, the contact should not be updated.
- You can use editContact() to update various fields of the contact, including name, email, and phone number.
- The editContact() function should work properly even if you edit multiple contacts in a row.

#### User story 5:-

As a user, <br>
I want the software to prevent me from adding contacts that already exists in the address book, <br>
So that I can avoid having duplicate contacts. <br>

|   Object    |                          Properties                           |        Messages        |  Output  |
| :---------: | :-----------------------------------------------------------: | :--------------------: | :------: |
| AddressBook |                 contacts @ArrayList<Contact>                  |      addContact()      |  @void   |
|             |                                                               |     editContact()      |  @void   |
|             |                                                               | doesPhoneNumberExist() | @boolean |
|             |                                                               |    doesEmailExist()    | @boolean |
|   Contact   |                         name @String                          |       getName()        | @String  |
|             |                         email @String                         |       getEmail()       | @String  |
|             |                      phoneNumber @String                      |    getPhoneNumber()    | @String  |
|             |                            id @int                            |                        |   @int   |
|             | constructor(name @String, email @String, phoneNumber @String) |                        |  @void   |

##### Test Cases:-
- In addContact(), if the provided phone number or email already exists in the address book, the entry should be rejected.
- Additionally, if both the phone number and email already exist in the address book, the entry should also be rejected.
- addContact() should still accept an entry that matches a previous entry that was deleted from the address book.
- When using editContact(), any changes that would result in a duplicate email or phone number in the address book should be rejected.


#### User story 6:-

As a user, <br>
I want to be able to view all contacts in the address book, <br>
So that I can view all saved contacts. <br>

|   Object    |          Properties          |    Messages    | Output  |
| :---------: | :--------------------------: | :------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> | viewContacts() | @String |

##### Test Cases:-
-  getAllContacts() should retrieve and return all contacts currently stored in the address book.
-  Whenever a contact is added, removed, or edited, getAllContacts() should update accordingly to reflect the changes.
-  If there are no contacts in the address book, getAllContacts() should return an error message.

#### User story 7:-

As a user, <br>
I want to be able to use the console interface to interact with the software, <br>
So that I can see my results by using the software. <br>

|  Object  | Properties |   Messages    | Output |
| :------: | :--------: | :-----------: | :----: |
| software |            | runSoftware() | @void  |

##### Test Cases:-
- When the user chooses to add a contact from the menu, the addContact() function should be triggered.
- If the user opts to search for a contact from the menu and inputs the name, the searchByName() function should be invoked.
- When the user selects to remove a contact from the menu and inputs the name, the removeContact() function should be invoked.
- If the user selects to edit a contact from the menu and inputs the new details, the editContact() function should be called.
- When the user selects to view contacts from the menu, the viewContacts() function should be executed.

### Additional Features
Generative AI has been used to help write the following user stories and domain models.




