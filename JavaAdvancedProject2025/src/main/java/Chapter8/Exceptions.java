package Chapter8;

import Chapter8.Exercises.LowStockException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Xhanti Solani
 */

public class Exceptions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = "";
        int numerator, denominator;
        double quotient = 0;

        try {
            System.out.print("Enter the name of your person: ");
            name = scan.nextLine();
            System.out.print("The last letter of your name is: (" + name + ") '" + name.substring(5) + "'") ;
            System.out.print("\nEnter the numerator: ");
            numerator = scan.nextInt();
            System.out.print("\nEnter the denominator: ");
            denominator = scan.nextInt();

            quotient = numerator / denominator;

            System.out.printf("Your name is: ", name);
            System.out.printf("Quetient: %.2f", quotient);
        } catch (InputMismatchException e) {
            System.err.println("Incorrect input type");
        } catch (ArithmeticException e) {
            System.err.println("Cannot divide by zero");
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("The last letter of (" + name + ") Should be at position: " + name.lastIndexOf(name.length()-1));
        }




    }
}
