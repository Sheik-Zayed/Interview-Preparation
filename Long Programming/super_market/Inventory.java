package super_market;

import java.util.*;

class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        for (Product prod : products) {
            if (prod.getId() == p.getId()) {
                System.out.println("Product ID already exists!");
                return;
            }
        }
        products.add(p);
    }

    public Product searchProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void deleteProduct(int id) {
        Product p = searchProduct(id);
        if (p != null) {
            products.remove(p);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }
}