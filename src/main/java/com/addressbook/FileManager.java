package com.addressbook;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public  void createAddressBook(String fileName) throws AddressBookException {
        try {
            File jsonFile = new File("src/test/resources/" + fileName + ".json");
            if (jsonFile.exists())
                throw new AddressBookException("File doesn't exists", AddressBookException.ExceptionType.FILE_NOT_FOUND);
            else
                jsonFile.createNewFile();
        }catch(IOException e){
            throw new AddressBookException("problem with the file", AddressBookException.ExceptionType.FILE_READ_ERROR);
        }
    }


    public void openAddressBook(){

    }

}
