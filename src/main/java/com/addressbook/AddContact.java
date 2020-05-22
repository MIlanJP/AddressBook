package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddContact{
    List <Person> contactDetails=null;

    public AddContact() {
        contactDetails=new ArrayList<Person>();
    }

    public List<Person> addContact(String firstName, String lastName, String address, long pincode, String city,
                           String state, long phoneNumber){
        Person person = new Person(firstName, lastName, address,pincode,city,state,phoneNumber);
        contactDetails.add(person);
        return contactDetails;
    }
}
