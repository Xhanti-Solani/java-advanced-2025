package Chapter8.Exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Xhanti
 *
 */

public class CityNotFound {

    static String[] arrCities = {
            "Cape Town", "Johannesburg", "Durban", "Pretoria",
            "Port Elizabeth", "Bloemfontein", "East London", "Polokwane"
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Enter a number between 0 and 7 to select a city: ");
            int index = scan.nextInt();

            System.out.println("The city in that position is: " + arrCities[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: You entered a number outside the valid range (0–7).");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            scan.close();
        }
    }
}
