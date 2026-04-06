package super_market;

import java.util.*;

class Bill {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product p, int qty) {
        if (qty > p.getStock()) {
            System.out.println("Insufficient stock!");
            return;
        }
        items.add(new CartItem(p, qty));
        p.reduceStock(qty);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printBill() {
        System.out.println("\n----- BILL -----");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() +
                    " x " + item.getQuantity() +
                    " = ₹" + item.getTotalPrice());
        }
        System.out.println("Total: ₹" + calculateTotal());
    }
}