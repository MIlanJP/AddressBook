package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddContact{


    public List<Person> addContact(String firstName, String lastName, String address, long pincode, String city,
                           String state, long phoneNumber,List<Person> addressBook){
        Person person = new Person(firstName, lastName, address,pincode,city,state,phoneNumber);
        addressBook.add(person);
        return addressBook;
    }


}
