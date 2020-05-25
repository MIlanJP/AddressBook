package com.addressbook;

import java.util.List;

public class AddContact {



    public static List<Person> addContact(String firstName, String lastName, String address, String pincode, String city,
                                   String state, String phoneNumber, List<Person> addressBook){
        Person person = new Person(firstName, lastName, address,pincode,city,state,phoneNumber);
        addressBook.add(person);
        return addressBook;
    }


}
