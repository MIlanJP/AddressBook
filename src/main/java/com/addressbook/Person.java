package com.addressbook;

public class Person  { private String firstName;
private String lastName;
private String address;
private long pincode;
private String city;
private String state;
private long phoneNumber;

    public Person(String firstName, String lastName, String address, long pincode, String city,
                  String state, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public long getPincode() {
        return pincode;
    }


    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updatePincode(long pincode) {
        this.pincode = pincode;
    }

    public void updateCity(String city) {
        this.city = city;
    }

    public void updateState(String state) {
        this.state = state;
    }

    public void updatePhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
