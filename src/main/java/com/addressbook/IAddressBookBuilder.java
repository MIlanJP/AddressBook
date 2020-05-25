package com.addressbook;

import java.util.List;

public  interface IAddressBookBuilder {

    public List<Person> addPerson(String firstName, String lastName, String address, String pincode, String city,
                                  String state, String phoneNumber);

    public String printAll(AddressBook.SearchUpdateAndDeleteBy search);

    public int getNoOfRecordsInTheAddressBook();

    public void deleteContact(String firstName);

    public void updateContact(AddressBook.SearchUpdateAndDeleteBy updateBy, String firstName, String modify);

    public List<Person> searchPersonDetails(String firstName);


}
