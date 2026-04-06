package hotel;

class Booking {
    Room room;
    Customer customer;
    int days;
    double totalAmount;

    Booking(Room room, Customer customer, int days) {
        this.room = room;
        this.customer = customer;
        this.days = days;
        this.totalAmount = days * room.price;
    }
}