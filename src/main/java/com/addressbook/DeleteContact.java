package com.addressbook;

import java.util.List;

public class DeleteContact {

    public static List<Person>  delete(List<Person> addressBook, String firstName){
        for(int i=0;i<addressBook.size();i++){
                Person person = addressBook.get(i);
            if(firstName.equals(person.getFirstName())){
                addressBook.remove(i);
            }
        }
        return addressBook;
    }

}
