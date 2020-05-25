package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBookBuilder implements IAddressBookBuilder {

    static List<Person> addressBook=null;

    public AddressBookBuilder() {
        this.addressBook = new ArrayList<Person>();
    }

    public AddressBookBuilder(List<Person> list) {
        this.addressBook = list;
    }

    public List<Person> addPerson(String firstName, String lastName, String address, String pincode, String city,
                                  String state, String phoneNumber){
        addressBook=AddContact.addContact(firstName, lastName, address,pincode,city,state,phoneNumber,addressBook);
        return addressBook;
    }

    @Override
    public String printAll(SearchUpdateAndDeleteBy search){
        return SortContact.sortBy(search,addressBook);
    }

    public List<Person> getNoOfRecordsInTheAddressBook(){
        return addressBook;
    }

    public void deleteContact(String firstName){
        addressBook=DeleteContact.delete(addressBook,firstName);
    }

    public void updateContact(SearchUpdateAndDeleteBy updateBy, String firstName, String modify){
        addressBook= UpdateContact.update(addressBook,updateBy,firstName,modify);
    }

    public List<Person> searchPersonDetails(String firstName){
        return SearchContact.search(addressBook,firstName);
    }



}
