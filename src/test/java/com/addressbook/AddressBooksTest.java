package com.addressbook;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class AddressBooksTest {
    @Test
    public void Added2Contacts_shouldReturnContactinString() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        Assert.assertEquals("[{\"firstName\":\"Milan\",\"lastName\":\"gowda\",\"address\":\"\",\"pincode\":\"" +
                        "77667\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"phoneNumber\":\"78945613\"}]" ,
                addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME));
    }

    @Test
    public void given2Contacts_whenAdded_shouldReturncountAs2() {
        IAddressBook addressBook= new IAddressBook();
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
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] sortedData=new Gson().fromJson(sortedListByFirstName, Person[].class);
        Assert.assertEquals("Anand",sortedData[0].getFirstName());
    }

    @Test
    public void givenContacts_WhenSortedAccorrdingtoState_shouldReturnStateAlphabetically() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","RockLineMall","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Bihar","4561327");
        String sortedListByState = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_STATE);
        Person[] sortedData=new Gson().fromJson(sortedListByState, Person[].class);
        Assert.assertEquals("Bihar",sortedData[0].getState());
    }

    @Test
    public void givenContacts_WhenSortedAccorrdingtoCity_shouldReturnCityAlphabetically() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","RockLineMall","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Chennai","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Amalapuram","Bihar","4561327");
        String sortedListByState = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_CITY);
        Person[] sortedData=new Gson().fromJson(sortedListByState, Person[].class);
        Assert.assertEquals("Amalapuram",sortedData[0].getCity());
    }

    @Test
    public void givenContacts_WhenSortedAccorrdingtoLastName_shouldReturnLastNameAlphabetically() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","RockLineMall","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Chennai","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kapoor",
                "ChikPet","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","bindra",
                "Singapore","12896","Amalapuram","Bihar","4561327");
        String sortedListByState = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_LAST_NAME);
        Person[] sortedData=new Gson().fromJson(sortedListByState, Person[].class);
        Assert.assertEquals("bindra",sortedData[0].getLastName());
    }


    @Test
    public void givenNameToDeleteAContact_whenPresent_shouldDeleteThatContact() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.deleteContact("Anand");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] sortedData=new Gson().fromJson(sortedListByFirstName, Person[].class);
        Assert.assertEquals("Milan",sortedData[0].getFirstName());
    }

    @Test
    public void givenAWord_whenSearch_shouldGiveAlistOfMatches() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.deleteContact("Anand");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Ra").toArray(new Person[0]);
        Assert.assertEquals("Rahul", personDetails[1].getFirstName());
        Assert.assertEquals("Rakesh", personDetails[0].getFirstName());
    }

    @Test
    public void givenContactInfo_whenUpdatedCity_shouldReturnUpdatedCity() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_CITY,"Anand","Mysore");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Mysore", personDetails[0].getCity());
    }

    @Test
    public void givenContactsInfo_whenUpdatedState_shouldReturnUpdatedState() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_STATE,"Anand","Karnataka");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Karnataka", personDetails[0].getState());
    }

    @Test
    public void givenContactsInfo_whenUpdatedAddress_shouldReturnUpdatedAddress() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_ADDRESS,"Anand","Yeshwanthpur");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Yeshwanthpur", personDetails[0].getAddress());
    }

    @Test
    public void givenContactsInfo_whenUpdatedLastName_shouldReturnUpdatedLastName() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_LAST_NAME,"Anand","Bindra");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("Bindra", personDetails[0].getLastName());
    }

    @Test
    public void givenContactsInfo_whenUpdatedPhoneNumber_shouldReturnUpdatedPhoneNumber() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_PHONENUMBER,"Anand","123456789");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("123456789", personDetails[0].getPhoneNumber());
    }

    @Test
    public void givenContactsInfo_whenUpdatedPincode_shouldReturnUpdatedPincode() {
        IAddressBook addressBook= new IAddressBook();
        addressBook.addPerson("Milan","gowda","","77667",
                "Bangalore","Karnataka","78945613");
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout","12896","Bangalore","Karnataka","4561327891");
        addressBook.addPerson("Rahul","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.addPerson("Anand","kumar",
                "HSRLayout","12896","Mangaore","Goa","4561327");
        addressBook.updateContact(SearchUpdateAndDeleteBy.UPDATE_PINCODE,"Anand","777777");
        String sortedListByFirstName = addressBook.printAll(SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME);
        Person[] personDetails = addressBook.searchPersonDetails("Anand").toArray(new Person[0]);
        Assert.assertEquals("777777", personDetails[0].getPincode());
    }


}
