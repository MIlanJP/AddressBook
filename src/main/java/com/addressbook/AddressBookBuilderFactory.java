package com.addressbook;

public class AddressBookBuilderFactory {

    public static IAddressBookBuilder createAddressBookControlller(){
        return new AddressBookBuilder();
    }

}
