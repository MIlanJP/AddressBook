package com.addressbook;

import java.util.List;

public  interface IAddressBookBuilder {

    public List<Person> addPerson(String firstName, String lastName, String address, String pincode, String city,
                                  String state, String phoneNumber);

    public String printAll(SearchUpdateAndDeleteBy search);

    public List<Person> getNoOfRecordsInTheAddressBook();

    public void deleteContact(String firstName);

    public void updateContact(SearchUpdateAndDeleteBy updateBy, String firstName, String modify);

    public List<Person> searchPersonDetails(String firstName);


}
