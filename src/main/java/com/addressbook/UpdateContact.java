package com.addressbook;

import java.util.List;

public class UpdateContact {

    public static List<Person> update(List<Person> addressBook,
                                      AddressBook.SearchUpdateAndDeleteBy updateBy ,
                                      String firstName, Object modify) {
        for (int i = 0; i < addressBook.size(); i++) {
            Person person = addressBook.get(i);
            if (firstName.equals(person.getFirstName())) {
                if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_LAST_NAME)) {
                    person.updateLastName((String) modify);
                } else if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_PHONENUMBER)) {
                    person.updatePhoneNumber((long) modify);
                } else if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_PINCODE)) {
                    person.updatePincode((long) modify);
                } else if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_CITY)) {
                    person.updateCity((String) modify);
                } else if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_STATE)) {
                    person.updateState((String) modify);
                } else if (updateBy.equals(AddressBook.SearchUpdateAndDeleteBy.UPDATE_ADDRESS)) {
                    person.updateAddress((String) modify);
                }
            }
        }
        return addressBook;
    }


}