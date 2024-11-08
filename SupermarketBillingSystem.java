import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    double price;
    int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> itemList = new ArrayList<>();
        
        System.out.println("Enter the number of items: ");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            itemList.add(new Item(name, price, quantity));
        }

        double totalBill = 0;
        System.out.println("\nReceipt:");
        System.out.println("==================================");
        for (Item item : itemList) {
            double itemTotal = item.getTotalPrice();
            totalBill += itemTotal;
            System.out.printf("%-15s %5d x %.2f = %.2f%n", item.name, item.quantity, item.price, itemTotal);
        }
        System.out.println("==================================");
        System.out.printf("Total Bill: %.2f%n", totalBill);
        
        scanner.close();
    }
}