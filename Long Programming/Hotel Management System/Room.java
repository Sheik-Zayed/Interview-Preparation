package hotel;

public class Room {
    int roomNumber;
    String type;
    double price;
    boolean isBooked;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }
}
