package Chapter8.Demo;

import Chapter8.Exercises.HighPriceIncreaseException;
import Chapter8.Exercises.LowStockException;

public class DemoExceptions {

    public static void main(String[] args) {
        System.out.println("********** Exception Demo **********");

        // 1. Using conditions (no exceptions)
        usingCondition();

        // 2. Checked exception example
        try {
            sellProduct(20, 5); // request > stock
        } catch (LowStockException e) {
            System.out.println("❌ Caught LowStockException: " + e.getMessage());
        }

        // 3. Unchecked exception example
        try {
            increasePrice(100); // too high
        } catch (HighPriceIncreaseException e) {
            System.out.println("❌ Caught HighPriceIncreaseException: " + e.getMessage());
        }

        // 4. Error (system-level, usually not caught)
        try {
            causeError();
        } catch (Error e) {
            System.out.println("⚠️ Caught an Error (but usually you don’t): " + e);
        }

        try {
            int x = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught the error: " + e.getMessage());
        }

        System.out.println("Program continues here ✅");
    }

    // 1. Just using if/else
    private static void usingCondition() {
        int stock = 5;
        int request = 10;

        if (request > stock) {
            System.out.println("❌ Not enough stock (using if). Requested " + request + ", available " + stock);
            return;
        }
        System.out.println("✅ Sale completed (using if).");
    }

    // 2. Checked exception
    private static void sellProduct(int stock, int request) throws LowStockException {
        if (request > stock) {
            throw new LowStockException("Requested " + request + " but only " + stock + " left.");
        }
        System.out.println("✅ Sold " + request + " items. Remaining: " + (stock - request));
    }

    // 3. Unchecked exception
    private static void increasePrice(double percent) {
        if (percent > 50) {
            throw new HighPriceIncreaseException("Increase too high: " + percent + "%");
        }
        System.out.println("✅ Price increased by " + percent + "%");
    }

    // 4. Error example
    private static void causeError() {
        throw new OutOfMemoryError("Simulated JVM error");
    }
}