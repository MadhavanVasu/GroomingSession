package com.mv.week1.part1.questions.association;

class Employee {
    String name;
    Integer age;
    Address address;

    public Employee(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

class Address {

    int doorNo;
    String street;

    public Address(int doorNo, String street, String city, int pincode) {
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    String city;
    int pincode;

}

public class OneToOneAssociation {

    public static void main(String[] args) {

        // One-to-One relationship -> An employee can be associated with only one address
        // An address can be associated with only one employee
        Address address = new Address(26, "Ganapathy Nagar", "Chennai", 603210);
        Employee human = new Employee("Maddy", 22, address);

    }

}
