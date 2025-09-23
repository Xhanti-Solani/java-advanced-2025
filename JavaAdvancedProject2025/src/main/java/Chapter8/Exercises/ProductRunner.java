package Chapter8.Exercises;

import java.util.Scanner;

public class ProductRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double price;
        int quantityInStock;


        try {
            System.out.print("Enter price:");
            price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter quantity in stock:");
            quantityInStock = Integer.parseInt(scanner.nextLine());


            Product product = new Product("#50540687020", "Coke Zero", price, quantityInStock);
            product.sell(5);
            product.increasePrice(5);

            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (LowStockException ex) {
            System.err.println(ex.getMessage());
        } catch (HighPriceIncreaseException e) {
            System.err.println(e.getMessage());
        }
        finally {
            scanner.close();
        }

    }
}
