# Domain Models, Class Diagrams and Test Plan

## Task 2 and Task 3

### User Stories and Domain Models

#### User story 1:-

As a user, <br>
I want to be able to add a contact to the address book (name, phone number and email address), <br>
So that I can save the contact for future use. <br>

|   Object    |          Properties          |     Messages     | Output  |
| :---------: | :--------------------------: | :--------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> |   addContact()   |  @void  |
|   Contact   |         name @String         |    setName()     | @String |
|             |        email @String         |    setEmail()    | @String |
|             |     phoneNumber @String      | setPhoneNumber() | @String |

#### User story 2:-

As a user, <br>
I want to be able to search for a contact by name, <br>
So that I can save time finding the contact. <br>

|   Object    |          Properties          |     Messages     | Output  |
| :---------: | :--------------------------: | :--------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> |  searchByName()  | @String |
|   Contact   |         name @String         |    getName()     | @String |
|             |        email @String         |    getEmail()    | @String |
|             |     phoneNumber @String      | getPhoneNumber() | @String |

#### User story 3:-

As a user, <br>
I want to be able to remove a contact from the address book, <br>
So that I can the address book does not contain unnecessary contacts. <br>

|   Object    |          Properties          |     Messages     | Output  |
| :---------: | :--------------------------: | :--------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> | removeContact()  |  @void  |
|   Contact   |         name @String         |    getName()     | @String |
|             |        email @String         |    getEmail()    | @String |
|             |     phoneNumber @String      | getPhoneNumber() | @String |

#### User story 4:-

As a user, <br>
I want to be able to edit contact details, <br>
So that I can keep the contact information up to date. <br>

|   Object    |          Properties          |     Messages     | Output  |
| :---------: | :--------------------------: | :--------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> |  editContact()   |  @void  |
|   Contact   |         name @String         |    setName()     | @String |
|             |        email @String         |    setEmail()    | @String |
|             |     phoneNumber @String      | setPhoneNumber() | @String |

#### User story 5:-

As a user, <br>
I want the software to prevent me from adding contacts that already exists in the address book, <br>
So that I can avoid having duplicate contacts. <br>

|   Object    |          Properties          |        Messages        |  Output  |
| :---------: | :--------------------------: | :--------------------: | :------: |
| AddressBook | contacts @ArrayList<Contact> |      addContact()      |  @void   |
|             |                              | doesPhoneNumberExist() | @boolean |
|             |                              |    doesEmailExist()    | @boolean |
|   Contact   |         name @String         |       getName()        | @String  |
|             |        email @String         |       getEmail()       | @String  |
|             |     phoneNumber @String      |    getPhoneNumber()    | @String  |

#### User story 6:-

As a user, <br>
I want to be able to view all contacts in the address book, <br>
So that I can view all saved contacts. <br>

|   Object    |          Properties          |    Messages    | Output  |
| :---------: | :--------------------------: | :------------: | :-----: |
| AddressBook | contacts @ArrayList<Contact> | viewContacts() | @String |

#### User story 7:-

As a user, <br>
I want to be able to use the console interface to interact with the software, <br>
So that I can see my results by using the software. <br>

|  Object  | Properties |   Messages    | Output |
| :------: | :--------: | :-----------: | :----: |
| software |            | runSoftware() | @void  |

### Additional Features

