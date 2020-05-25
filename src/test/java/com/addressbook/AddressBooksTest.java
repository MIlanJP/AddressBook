package com.addressbook;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class AddressBooksTest {
    @Test
    public void Added2Contacts_shouldReturnContactinString() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        Assert.assertEquals("[{\"firstName\":\"Milan\",\"lastName\":\"gowda\",\"address\":\"\",\"pincode\":\"" +
                        "77667\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"phoneNumber\":\"78945613\"}]" ,
                addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME));
    }

    @Test
    public void given2Contacts_whenAdded_shouldReturncountAs2() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        Assert.assertEquals(4,addressBook.getNoOfRecordsInTheAddressBook());
    }

    @Test
    public void givenContacts_WhenSorted_shouldReturnFirstNameAlphabetically() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        String sortedListByFirstName = addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] sortedData=new Gson().fromJson(sortedListByFirstName, Person[].class);
        sortedData[0].updatePhoneNumber("123456879");
        Assert.assertEquals("Anand",sortedData[0].getFirstName());
    }

    @Test
    public void deletingaContactAfterAddind_MustDeleteThatContact() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.deleteContact("Anand");
        String sortedListByFirstName = addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] sortedData=new Gson().fromJson(sortedListByFirstName, Person[].class);

        Assert.assertEquals("Milan",sortedData[0].getFirstName());
    }

    @Test
    public void searchMatches() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.deleteContact("Anand");
        String sortedListByFirstName = addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Ra").toArray(new Person[0]);
        Assert.assertEquals("Rahul", personDetails[1].getFirstName());
        Assert.assertEquals("Rakesh", personDetails[0].getFirstName());
    }

    @Test
    public void givenContactsInfo_whenUpdatedCity_shouldReturnCorrectCity() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(AddressBook.SearchUpdateAndDeleteBy.UPDATE_CITY,"Anand","Mysore");
        String sortedListByFirstName = addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Mysore", personDetails[0].getCity());
    }

    @Test
    public void givenContactsInfo_whenUpdatedState_shouldReturnCorrectState() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(AddressBook.SearchUpdateAndDeleteBy.UPDATE_STATE,"Anand","Karnataka");
        String sortedListByFirstName = addressBook.printAll(AddressBook.SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Karnataka", personDetails[0].getState());
    }

}
