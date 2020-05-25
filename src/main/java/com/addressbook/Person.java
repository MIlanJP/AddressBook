package com.addressbook;

public class Person {

private String firstName;
private String lastName;
private String address;
private String pincode;
private String city;
private String state;
private String phoneNumber;

    public Person(String firstName, String lastName, String address, String pincode, String city,
                  String state, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updatePincode(String pincode) {
        this.pincode = pincode;
    }

    public void updateCity(String city) {
        this.city = city;
    }

    public void updateState(String state) {
        this.state = state;
    }

    public Person updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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
