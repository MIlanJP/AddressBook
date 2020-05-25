package com.addressbook;

import java.util.List;

public class UpdateContact {

    public static List<Person> update(List<Person> addressBook,
                                      SearchUpdateAndDeleteBy updateBy ,
                                      String firstName, String modify) {
        for (int i = 0; i < addressBook.size(); i++) {
            Person person = addressBook.get(i);
            if (firstName.equals(person.getFirstName())) {
                if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_LAST_NAME)) {
                    person.updateLastName(modify);
                } else if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_PHONENUMBER)) {
                    person.updatePhoneNumber(modify);
                } else if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_PINCODE)) {
                    person.updatePincode( modify);
                } else if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_CITY)) {
                    person.updateCity( modify);
                } else if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_STATE)) {
                    person.updateState( modify);
                } else if (updateBy.equals(SearchUpdateAndDeleteBy.UPDATE_ADDRESS)) {
                    person.updateAddress( modify);
                }
            }
        }
        return addressBook;
    }


}