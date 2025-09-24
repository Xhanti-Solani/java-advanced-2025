package Chapter8.Exercises;

import java.util.Scanner;

public class ProductRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = null;

        boolean validProductCreated = false;

        while (!validProductCreated) {
            try {
                // Ask for product details
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter quantity in stock: ");
                int quantityInStock = Integer.parseInt(scanner.nextLine());

                // Create product (may throw IllegalArgumentException if bad data)
                product = new Product("#50540687020", "Coke Zero", price, quantityInStock);

                // Try selling and increasing price (may throw your custom exceptions)
                product.sell(5);              // could throw LowStockException
                product.increasePrice(5);     // could throw HighPriceIncreaseException

                System.out.println("\n✅ Product created successfully!");
                System.out.println(product);

                validProductCreated = true; // exit loop when all succeeded
            } catch (NumberFormatException e) {
                // If user types letters instead of numbers
                System.out.println("❌ Invalid number format. Please try again.");
            } catch (IllegalArgumentException e) {
                // For validation failures inside Product setters
                System.out.println("❌ Invalid product setup: " + e.getMessage());
            } catch (LowStockException e) {
                // Custom checked exception
                System.out.println("❌ Not enough stock: " + e.getMessage());
            } catch (HighPriceIncreaseException e) {
                // Custom unchecked exception
                System.out.println("❌ Price increase too high: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("\nProgram finished successfully ✅");
    }
}
