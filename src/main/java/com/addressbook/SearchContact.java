package com.addressbook;

import java.util.ArrayList;
import java.util.List;



public class SearchContact {
    public static List<Person> search(List<Person> addressBook, String nameMatch) {
        List <Person> matchedDetails = new ArrayList<Person>();
        for (int i = 0; i < addressBook.size(); i++) {
            Person person = addressBook.get(i);
            if (person.getFirstName().contains(nameMatch)) {
                matchedDetails.add(person);
            }
        }
        return matchedDetails;
    }
}
