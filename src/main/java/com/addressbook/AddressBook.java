package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    public enum SearchUpdateAndDeleteBy {
        SORT_BY_FIRST_NAME,SORT_BY_LAST_NAME,SORT_BY_CITY,SORT_BY_STATE,SORT_BY_PHONENUMBER,
        SORT_BY_PINCODE,
        UPDATE_LAST_NAME, UPDATE_CITY, UPDATE_STATE, UPDATE_PHONENUMBER,
        UPDATE_PINCODE,UPDATE_ADDRESS,
        UPDATE,SEARCH,DELETE,SORT
    }

    List<Person> addressBook=new ArrayList<Person>();
    AddContact addContact=null;

    public AddressBook() {
       addContact=new AddContact();
    }

    public void addPerson(String firstName, String lastName, String address, long pincode, String city,
                          String state, long phoneNumber){
        addressBook=addContact.addContact(firstName, lastName, address,pincode,city,state,phoneNumber,addressBook);
    }

    public String printAll(AddressBook.SearchUpdateAndDeleteBy search){
       return SortContact.sortBy(search,addressBook);
    }

    public int getNoOfRecordsInTheAddressBook(){
        return addressBook.size();
    }

    public void deleteContact(String firstName){
        addressBook=new  DeleteContact().delete(addressBook,firstName);
    }

    public void updateContact(SearchUpdateAndDeleteBy updateBy,String firstName,Object modify){
        addressBook= new UpdateContact().update(addressBook,updateBy,firstName,modify);
    }

    public List<Person> searchPersonDetails(String firstName){
        SearchContact searchContact=new SearchContact();
    return searchContact.search(addressBook,firstName);
    }



}
