package Chapter8.Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfusionDemo {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("=== Condition vs Exception Demo ===\n");

        // Example 1: Using if/else (manual error checking)
        usingConditionStatements();

        // Example 2: Using exceptions (letting Java signal the problem)
        usingExceptions();
    }

    // =======================================
    // 1. Condition statements (manual checks)
    // =======================================
    private static void usingConditionStatements() throws FileNotFoundException {
        System.out.println("Condition Statements Approach:");

        File file = new File("missing.txt");

        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist, cannot proceed.");
        }

        if (!file.canRead()) {
            System.out.println("❌ File cannot be read, cannot proceed.");
            return; // manually stop
        }

        // This code only runs if all checks pass
        System.out.println("✅ File exists and is readable.");
    }

    // =======================================
    // 2. Exceptions (automatic propagation)
    // =======================================
    private static void usingExceptions() {
        System.out.println("\nException Approach:");

        try {
            // Try to open a file that does not exist
            FileReader reader = new FileReader("missing.txt");

            System.out.println("✅ File opened successfully.");
            reader.close();

        } catch (FileNotFoundException e) {
            // Java reports the problem automatically
            System.out.println("❌ Caught exception: " + e);
        } catch (Exception e) {
            // Catch-all (not usually best practice, but for demo)
            System.out.println("❌ Some other exception: " + e);
        }
    }
}
