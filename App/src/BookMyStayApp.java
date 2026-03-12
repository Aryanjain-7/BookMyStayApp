/**
 * RoomInventory.java
 *
 * This class centralizes room availability management for the Hotel Booking System.
 * It replaces scattered availability variables with a single HashMap-based inventory.
 *
 * Key concepts demonstrated:
 * - HashMap for fast O(1) lookups and updates
 * - Encapsulation of inventory logic
 * - Single source of truth for room availability
 * - Separation of domain (Room) and state (inventory)
 *
 * Author: YourName
 * Version: 1.0
 */

import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    // Centralized inventory mapping room type to available count
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register a room type with initial availability
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Retrieve current availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability after booking or cancellation
    public void updateAvailability(String roomType, int delta) {
        int current = inventory.getOrDefault(roomType, 0);
        int updated = current + delta;
        if (updated < 0) {
            System.out.println("Error: Cannot reduce availability below zero for " + roomType);
        } else {
            inventory.put(roomType, updated);
        }
    }

    // Display current inventory state
    public void displayInventory() {
        System.out.println("************ Current Room Inventory ************");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " | Available: " + entry.getValue());
        }
        System.out.println("************************************************");
    }
}

// Application Entry Point
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types with initial availability
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 2);

        // Display current inventory
        inventory.displayInventory();

        // Simulate a booking
        System.out.println("\nBooking 1 Double Room...");
        inventory.updateAvailability("Double Room", -1);

        // Simulate adding rooms back (cancellation)
        System.out.println("\nCancellation: 1 Suite Room returned...");
        inventory.updateAvailability("Suite Room", 1);

        // Display updated inventory
        System.out.println();
        inventory.displayInventory();
    }
}