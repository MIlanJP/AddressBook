package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBooksTest {
    @Test
    public void Added2Contacts_shouldReturnContactinString() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","",77667l,
                "Bangalore","Karnataka",78945613L);
        addressBook.addPerson("Min","qwety",
                "HSRLayout",12896l,"Bangalore","Karnataka",4561327891L);

        Assert.assertEquals("[Person{firstName='Milan', lastName='gowda', address='', pincode=77667, " +
                "city='Bangalore', state='Karnataka', phoneNumber=78945613}, Person{firstName='Min', lastName='qwety', " +
                "address='HSRLayout', pincode=12896, city='Bangalore', state='Karnataka', " +
                "phoneNumber=4561327891}]",addressBook.printAll());
    }

    @Test
    public void added2Contacts_shouldReturncountAs2() {
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","",77667l,
                "Bangalore","Karnataka",78945613L);
        addressBook.addPerson("Min","qwety",
                "HSRLayout",12896l,"Bangalore","Karnataka",4561327891L);
        Assert.assertEquals(2,addressBook.getNoOfRecordsInTheAddressBook());
    }
    @Test
    public void givenContactsInfo_whenSearched_shouldReturnDetails(){
        AddressBook addressBook= new AddressBook();
        addressBook.addPerson("Milan","gowda","",77667l,
                "Bangalore","Karnataka",78945613L);
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout",12896l,"Bangalore","Karnataka",4561327891L);
        addressBook.addPerson("Rakesh","kumar",
                "HSRLayout",12896l,"Mangaore","Goa",4561327l);
        System.out.println(addressBook.searchPersonDetails("Rakesh"));
    }



}
