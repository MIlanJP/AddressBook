package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    public enum SearchUpdateAndDeleteBy {
        SORT_BY_FIRST_NAME,SORT_BY_LAST_NAME,SORT_BY_CITY,SORT_BY_STATE,SORT_BY_PHONENUMBER,
        SORT_BY_PINCODE,
    }

    List<Person> personDetails=null;
    AddContact addContact=null;
    public AddressBook() {
        AddContact addContact=new AddContact();
      //  personDetails=addContact.contactDetails;
    }

    public void addPerson(String firstName, String lastName, String address, long pincode, String city,
                          String state, long phoneNumber){
        personDetails=addContact.addContact(firstName, lastName, address,pincode,city,state,phoneNumber);
    }

    public String printAll(AddressBook.SearchUpdateAndDeleteBy search){
       return SortContact.searchBy(search,personDetails);
    }

    public int getNoOfRecordsInTheAddressBook(){
        return personDetails.size();
    }

    public String searchPersonDetails(String firstName){
        Person personList= personDetails.stream().filter(searchByFirstName->firstName.equals(searchByFirstName.getFirstName()))
            .findAny().orElse(null);
    return personList.toString();
    }



}
