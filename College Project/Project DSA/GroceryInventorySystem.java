import java.util.*;

class Product {
    String id;
    String name;
    String category;
    int quantity;
    double price;

    Product(String id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t" + category
                + "\t" + quantity + "\t" + price);
    }
}

public class GroceryInventorySystem {

    static ArrayList<Product> products = new ArrayList<>();
    static HashMap<String, Product> productMap = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Add Product
    static void addProduct() {

        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();

        if (productMap.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        if (quantity < 0 || price < 0) {
            System.out.println("Quantity and price cannot be negative!");
            return;
        }

        Product p = new Product(id, name, category, quantity, price);

        products.add(p);
        productMap.put(id, p);

        System.out.println("Product added successfully!");
    }

    // View All Products
    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\nID\tName\tCategory\tQuantity\tPrice");

        for (Product p : products) {
            p.display();
        }
    }

    // Search Product
    static void searchProduct() {

        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();

        Product p = productMap.get(id);

        if (p != null) {
            System.out.println("\nProduct Found:");
            System.out.println("ID: " + p.id);
            System.out.println("Name: " + p.name);
            System.out.println("Category: " + p.category);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Price: " + p.price);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Update Product
    static void updateProduct() {

        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();

        Product p = productMap.get(id);

        if (p != null) {

            System.out.print("Enter New Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            System.out.print("Enter New Price: ");
            double price = Double.parseDouble(sc.nextLine());

            if (quantity < 0 || price < 0) {
                System.out.println("Invalid quantity or price!");
                return;
            }

            p.quantity = quantity;
            p.price = price;

            System.out.println("Product updated successfully!");

        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete Product
    static void deleteProduct() {

        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();

        Product p = productMap.remove(id);

        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Sort Products by Price
    static void sortProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        products.sort(Comparator.comparingDouble(p -> p.price));

        System.out.println("\nProducts Sorted by Price:");

        viewProducts();
    }

    // Main Method
    public static void main(String[] args) {

        int choice = 0;

        do {

            System.out.println("\n===== GROCERY INVENTORY SYSTEM =====");

            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Sort Products by Price");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    sortProducts();
                    break;

                case 7:
                    System.out.println("Thank you for using Grocery Inventory System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 7);

        sc.close();
    }
}