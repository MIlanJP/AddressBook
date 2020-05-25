package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBookBuilder implements IAddressBookBuilder {

    List<Person> addressBook=null;
    AddContact addContact=null;

    public AddressBookBuilder() {
        this.addressBook = new ArrayList<Person>();
    }

    public List<Person> addPerson(String firstName, String lastName, String address, String pincode, String city,
                                  String state, String phoneNumber){
        addressBook=AddContact.addContact(firstName, lastName, address,pincode,city,state,phoneNumber,addressBook);
        return addressBook;
    }

    @Override
    public String printAll(AddressBook.SearchUpdateAndDeleteBy search){
        return SortContact.sortBy(search,addressBook);
    }

    public int getNoOfRecordsInTheAddressBook(){
        return addressBook.size();
    }

    public void deleteContact(String firstName){
        addressBook=DeleteContact.delete(addressBook,firstName);
    }

    public void updateContact(AddressBook.SearchUpdateAndDeleteBy updateBy, String firstName, String modify){
        addressBook= UpdateContact.update(addressBook,updateBy,firstName,modify);
    }

    public List<Person> searchPersonDetails(String firstName){
        return SearchContact.search(addressBook,firstName);
    }



}
