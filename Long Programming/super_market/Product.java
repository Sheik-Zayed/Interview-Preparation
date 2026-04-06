package super_market;

class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        if (price <= 0 || stock < 0) {
            throw new IllegalArgumentException("Invalid price or stock");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Invalid price");
            return;
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Invalid stock");
            return;
        }
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            System.out.println("Not enough stock!");
        } else {
            stock -= quantity;
        }
    }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price + " | Stock: " + stock;
    }
}