package com.addressbook;

import java.util.List;

public class IAddressBook {
    IAddressBookBuilder iAddressBookBuilder;

    public IAddressBook() {
        IAddressBookBuilder iAddressBookBuilder =AddressBookBuilderFactory.createAddressBookControlller();
    }

    List<Person> addressBook=null;


    public void addPerson(String firstName, String lastName, String address, String pincode, String city,
                          String state, String phoneNumber){
       iAddressBookBuilder.addPerson(firstName, lastName, address,pincode,city,state,phoneNumber);
    }

    public String printAll(SearchUpdateAndDeleteBy search){
       return iAddressBookBuilder.printAll(search);
    }

    public int getNoOfRecordsInTheAddressBook(){
        return iAddressBookBuilder.getNoOfRecordsInTheAddressBook().size();
    }

    public void deleteContact(String firstName){
        iAddressBookBuilder.deleteContact(firstName);
    }

    public void updateContact(SearchUpdateAndDeleteBy updateBy,String firstName,String modify){
        iAddressBookBuilder.updateContact(updateBy,firstName,modify);
    }

    public List<Person> searchPersonDetails(String firstName){
    return iAddressBookBuilder.searchPersonDetails(firstName);
    }

}
