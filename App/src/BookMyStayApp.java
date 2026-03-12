

import java.util.*;

class RoomSearchService {

    private RoomInventory inventory;
    private List<Room> roomList;

    public RoomSearchService(RoomInventory inventory, List<Room> roomList) {
        this.inventory = inventory;
        this.roomList = roomList;
    }

    // Display available rooms with details
    public void displayAvailableRooms() {
        System.out.println("************ Available Rooms ************");
        boolean anyAvailable = false;

        for (Room room : roomList) {
            int availableCount = inventory.getAvailability(room.getRoomType());
            if (availableCount > 0) {
                room.displayDetails();
                System.out.println("Available: " + availableCount + "\n");
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            System.out.println("No rooms are currently available.");
        }

        System.out.println("****************************************");
    }
}

// Example Room classes with getter for roomType
abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected double pricePerNight;

    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    public abstract void displayDetails();

    public String getRoomType() {
        return roomType;
    }
}

class SingleRoom extends Room {
    public SingleRoom() { super("Single Room", 1, 50.0); }
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double Room", 2, 90.0); }
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite Room", 3, 150.0); }
    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + numberOfBeds + " | Price: $" + pricePerNight);
    }
}

// Demo Application
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 0); // Suite is fully booked

        // Initialize rooms
        List<Room> rooms = Arrays.asList(new SingleRoom(), new DoubleRoom(), new SuiteRoom());

        // Search Service
        RoomSearchService searchService = new RoomSearchService(inventory, rooms);

        // Display available rooms (read-only)
        searchService.displayAvailableRooms();
    }
}