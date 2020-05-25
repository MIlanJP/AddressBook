package com.addressbook;

import java.util.List;

public class AddressBookBuilderFactory {

    public static IAddressBookBuilder createAddressBookControlller(){
        return new AddressBookBuilder();
    }
    public static IAddressBookBuilder accessAddressBookControlller(List<Person> list){
        return new AddressBookBuilder(list);
    }

}
