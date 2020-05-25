package com.addressbook;

public class AddressBookException extends Exception {

    enum ExceptionType {
    FILE_NOT_FOUND,FILE_READ_ERROR
    }
    ExceptionType type;

    AddressBookException(String message ,ExceptionType type) {
        super(message);
        this.type = type;
    }

}
