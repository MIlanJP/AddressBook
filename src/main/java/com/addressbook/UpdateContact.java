package com.addressbook;

import java.util.EnumMap;
import java.util.List;

public class UpdateContact {

    EnumMap< ,List<Person> > enumMap=
            new EnumMap(AddressBook.SearchUpdateAndDeleteBy.class);
   public void updateOptions(){

   }

    public static List<Person> update(List<Person> addressBook,AddressBook.SearchUpdateAndDeleteBy updateBy ,Person person){
        for(int i=0;i<addressBook.size();i++){
            Person person = addressBook.get(i);
            if(updatePerson.equals(person.getFirstName())){
                addressBook.remove(i);
            }
        }
        return addressBook;
    }

}
