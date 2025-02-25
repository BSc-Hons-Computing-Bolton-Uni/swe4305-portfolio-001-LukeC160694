package Logbook.Week5;
import java.util.ArrayList;

/**
 * Create the Product class with attributes for id, name, and quantity.
 */
class Product {
    private int id;
    private String name;
    private int quantity;

    // Constructor
    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Print method to display product details
    public void print() {
        System.out.println("Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}

/**
 * Create the StockList class to manage a collection of products.
 */
class StockList {
    private ArrayList<Product> products;

    // Constructor initializes the ArrayList
    public StockList() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the stock list
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    // Method to remove a product from the stock list by ID
    public void removeProduct(int id) {
        Product product = findProduct(id);
        if (product != null) {
            products.remove(product);
            System.out.println("Removed: " + product.getName());
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    // Method to find a product by ID
    public Product findProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Returns null if not found
    }

    // Method to print all products in stock
    public void printStock() {
        System.out.println("\nStock List:");
        for (Product product : products) {
            product.print();
        }
    }
}

/**
 * Define the StockDemo class to test StockList operations.
 */
class StockDemo {
    private StockList stockList;

    // Constructor initializes StockList
    public StockDemo() {
        stockList = new StockList();
    }

    // Method to test adding products
    public void testAddProducts() {
        Product p1 = new Product(101, "Laptop", 10);
        Product p2 = new Product(102, "Smartphone", 15);
        Product p3 = new Product(103, "Headphones", 20);

        stockList.addProduct(p1);
        stockList.addProduct(p2);
        stockList.addProduct(p3);
    }

    // Method to test removing a product
    public void testRemoveProduct() {
        stockList.removeProduct(102); // Attempt to remove Smartphone (ID: 102)
    }

    // Method to test searching for a product
    public void testFindProduct() {
        Product found = stockList.findProduct(101);
        if (found != null) {
            System.out.println("Found product: " + found.getName());
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to print all products in stock
    public void testPrintStock() {
        stockList.printStock();
    }

    // Run method calls all test methods
    public void run() {
        testAddProducts();
        testPrintStock();
        testRemoveProduct();
        testPrintStock();
        testFindProduct();
    }
}

/**
 * Define the main method to run the tests.
 */
public class main {
    public static void main(String[] args) {
        StockDemo demo = new StockDemo();
        demo.run();
    }
}