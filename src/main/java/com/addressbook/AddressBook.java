package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    public enum modifyBy{
        SEARCH_BY_FIRST_NAME,SEARCH_BY_LAST_NAME,SEARCH_BY_CITY,SEARCH_BY_STATE,SEARCH_BY_PHONENUMBER,SEARCH_BY
    }

    List<Person> personDetails=null;

    public AddressBook() {
        personDetails= new ArrayList<>();
    }

    public void addPerson(String firstName, String lastName, String address, long pincode, String city,
                          String state, long phoneNumber){
        Person person = new Person(firstName, lastName, address,pincode,city,state,phoneNumber);
        personDetails.add(person);
    }

    public String printAll(){
        List<Person> sortedList=personDetails.stream().sorted(Comparator.comparing(Person::getFirstName)
                .reversed()).collect(Collectors.toList());
       return sortedList.toString();
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
