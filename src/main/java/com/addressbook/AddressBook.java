package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    public enum SearchUpdateAndDeleteBy {
        SORT_BY_FIRST_NAME,SORT_BY_LAST_NAME,SORT_BY_CITY,SORT_BY_STATE,SORT_BY_PHONENUMBER,
        SORT_BY_PINCODE,
        UPDATE_LAST_NAME, UPDATE_CITY, UPDATE_STATE, UPDATE_PHONENUMBER,
        UPDATE_PINCODE,UPDATE_ADDRESS,
    }

    IAddressBookBuilder iAddressBookBuilder =AddressBookBuilderFactory.createAddressBookControlller();

    List<Person> addressBook=null;


    public void addPerson(String firstName, String lastName, String address, String pincode, String city,
                          String state, String phoneNumber){
       iAddressBookBuilder.addPerson(firstName, lastName, address,pincode,city,state,phoneNumber);
    }

    public String printAll(AddressBook.SearchUpdateAndDeleteBy search){
       return iAddressBookBuilder.printAll(search);
    }

    public int getNoOfRecordsInTheAddressBook(){
        return iAddressBookBuilder.getNoOfRecordsInTheAddressBook();
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
