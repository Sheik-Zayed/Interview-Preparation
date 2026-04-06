package super_market;

import java.util.*;

public class BillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Create Bill");
            System.out.println("5. Exit");

            int choice = getIntInput(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = getIntInput(sc);

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Price: ");
                    double price = getDoubleInput(sc);

                    System.out.print("Enter Stock: ");
                    int stock = getIntInput(sc);

                    try {
                        inventory.addProduct(new Product(id, name, price, stock));
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;

                case 2:
                    inventory.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    inventory.deleteProduct(getIntInput(sc));
                    break;

                case 4:
                    Bill bill = new Bill();
                    while (true) {
                        System.out.print("Enter Product ID (0 to stop): ");
                        int pid = getIntInput(sc);
                        if (pid == 0) break;

                        Product p = inventory.searchProduct(pid);
                        if (p == null) {
                            System.out.println("Product not found!");
                            continue;
                        }

                        System.out.print("Enter Quantity: ");
                        int qty = getIntInput(sc);

                        bill.addItem(p, qty);
                    }

                    bill.printBill();

                    double total = bill.calculateTotal();
                    System.out.print("Enter Payment: ");
                    double payment = getDoubleInput(sc);

                    if (payment < total) {
                        System.out.println("Insufficient payment!");
                    } else {
                        System.out.println("Balance: ₹" + (payment - total));
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔥 Input Validation Methods
    public static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Enter valid number:");
            sc.next();
        }
        return sc.nextInt();
    }

    public static double getDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Enter valid amount:");
            sc.next();
        }
        return sc.nextDouble();
    }
}