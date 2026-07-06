import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Vehicle {

    int slotNo;
    String vehicleNo;
    String ownerName;
    String vehicleType;

    Vehicle(int slotNo, String vehicleNo, String ownerName, String vehicleType) {
        this.slotNo = slotNo;
        this.vehicleNo = vehicleNo;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
}

class ParkingLot {

    ArrayList<Vehicle> parking = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void parkVehicle() {

        System.out.print("Enter Slot Number : ");
        int slot = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Vehicle Number : ");
        String vehicleNo = sc.nextLine();

        System.out.print("Enter Owner Name : ");
        String owner = sc.nextLine();

        System.out.print("Enter Vehicle Type : ");
        String type = sc.nextLine();

        parking.add(new Vehicle(slot, vehicleNo, owner, type));

        System.out.println("Vehicle Parked Successfully.");
    }

    void viewVehicles() {

        if (parking.isEmpty()) {
            System.out.println("Parking Lot Empty.");
            return;
        }

        System.out.println("\n------ PARKED VEHICLES ------");

        for (Vehicle v : parking) {

            System.out.println(
                    "Slot : " + v.slotNo +
                            " | Vehicle : " + v.vehicleNo +
                            " | Owner : " + v.ownerName +
                            " | Type : " + v.vehicleType
            );

        }
    }

    void searchVehicle() {

        System.out.print("Enter Vehicle Number : ");
        String number = sc.nextLine();

        for (Vehicle v : parking) {

            if (v.vehicleNo.equalsIgnoreCase(number)) {

                System.out.println("\nVehicle Found");

                System.out.println("Slot Number : " + v.slotNo);
                System.out.println("Owner       : " + v.ownerName);
                System.out.println("Type        : " + v.vehicleType);

                return;
            }

        }

        System.out.println("Vehicle Not Found.");
    }

    void removeVehicle() {

        System.out.print("Enter Vehicle Number : ");
        String number = sc.nextLine();

        Iterator<Vehicle> iterator = parking.iterator();

        while (iterator.hasNext()) {

            Vehicle v = iterator.next();

            if (v.vehicleNo.equalsIgnoreCase(number)) {

                iterator.remove();

                System.out.println("Vehicle Removed Successfully.");

                return;
            }

        }

        System.out.println("Vehicle Not Found.");
    }

}

public class ParkingManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot lot = new ParkingLot();

        int choice;

        do {

            System.out.println("\n========== PARKING MANAGEMENT ==========");

            System.out.println("1. Park Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Remove Vehicle");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    lot.parkVehicle();
                    break;

                case 2:
                    lot.viewVehicles();
                    break;

                case 3:
                    lot.searchVehicle();
                    break;

                case 4:
                    lot.removeVehicle();
                    break;

                case 5:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while (choice != 5);

    }

}