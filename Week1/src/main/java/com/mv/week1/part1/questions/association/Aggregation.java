package com.mv.week1.part1.questions.association;

class Driver {

    String name;
    String drivingLicense;

    public Driver(String name, String drivingLicense) {
        this.name = name;
        this.drivingLicense = drivingLicense;
    }
}

class Car {

    String model;
    Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

}


public class Aggregation {

    // Aggregation is "has-a" relationship between two objects of different class
    // Car has a driver
    // Even if the car is not present driver would still exist
    // Both the objects can exist independently
    Driver driver = new Driver("John Doe", "HG123456");
    Car car = new Car(driver);


}
