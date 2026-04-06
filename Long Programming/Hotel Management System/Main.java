package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Initial rooms
        hotel.addRoom(101, "Single", 1000);
        hotel.addRoom(102, "Double", 2000);
        hotel.addRoom(103, "Deluxe", 3000);

        while (true) {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.viewRooms();
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int roomNo = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter days: ");
                    int days = sc.nextInt();

                    hotel.bookRoom(roomNo, name, phone, days);
                    break;

                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelRoom = sc.nextInt();
                    hotel.cancelBooking(cancelRoom);
                    break;

                case 4:
                    hotel.viewBookings();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
