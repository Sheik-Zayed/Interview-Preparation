package hotel;

import java.util.*;

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    // Add room
    void addRoom(int number, String type, double price) {
        rooms.add(new Room(number, type, price));
    }

    // View rooms
    void viewRooms() {
        for (Room r : rooms) {
            System.out.println("Room: " + r.roomNumber + " | Type: " + r.type + " | Price: " + r.price +
            		" | Status: " + (r.isBooked ? "Booked" : "Available"));
        }
    }

    // Find room
    Room findRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) return r;
        }
        return null;
    }

    // Book room
    void bookRoom(int roomNumber, String name, String phone, int days) {
        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (room.isBooked) {
            System.out.println("Room already booked!");
            return;
        }

        Customer customer = new Customer(name, phone);
        Booking booking = new Booking(room, customer, days);

        room.isBooked = true;
        bookings.add(booking);

        System.out.println("Booking successful! Total: " + booking.totalAmount);
    }

    // Cancel booking
    void cancelBooking(int roomNumber) {
        Iterator<Booking> it = bookings.iterator();

        while (it.hasNext()) {
            Booking b = it.next();
            if (b.room.roomNumber == roomNumber) {
                b.room.isBooked = false;
                it.remove();
                System.out.println("Booking cancelled.");
                return;
            }
        }

        System.out.println("Booking not found!");
    }

    // View bookings
    void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println("Room: " + b.room.roomNumber + " | Customer: " + b.customer.name +
            		" | Days: " + b.days + " | Total: " + b.totalAmount);
        }
    }
}