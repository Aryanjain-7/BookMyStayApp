/**
 * HotelBookingRoomsApp.java
 *
 * This class demonstrates basic room types and static availability in the Hotel Booking Management System.
 * It introduces object-oriented concepts such as abstraction, inheritance, encapsulation, and polymorphism.
 * Room availability is represented using simple variables for illustration purposes.
 *
 * Author: YourName
 * Version: 1.0
 */

abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected double pricePerNight;

    // Constructor for shared attributes
    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    // Abstract method to display room details
    public abstract void displayDetails();
}

// Concrete Room Classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 50.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 90.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 150.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

// Application Entry Point
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize rooms
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("**************************************************");
        System.out.println("Hotel Booking Management System - Room Availability");
        System.out.println("**************************************************");

        // Display room details and availability
        single.displayDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable + "\n");

        System.out.println("Application terminated successfully.");
    }
}