package Chapter8.Demo;

import java.io.*;

public class ExceptionHierarchyDemo {

    public static void main(String[] args) {
        // 1. RuntimeException examples
        runtimeExceptions();

        // 2. Checked Exception examples
        checkedExceptions();

        // 3. Error examples (⚠️ these will crash if not handled carefully)
        errorExamples();
    }

    // ==============================
    // Runtime Exceptions (unchecked)
    // ==============================
    private static void runtimeExceptions() {
        System.out.println("=== Runtime Exceptions ===");

        // ArithmeticException
        try {
            int result = 10 / 0; // dividing by zero
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e);
        }

        // NumberFormatException
        try {
            int value = Integer.parseInt("abc"); // not a number
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e);
        }

        // IndexOutOfBoundsException / ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int x = arr[5]; // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        }

        // IllegalArgumentException
        try {
            Thread.sleep(-1000); // invalid argument
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e);
        } catch (InterruptedException ignored) {}
    }

    // ==============================
    // Checked Exceptions
    // ==============================
    private static void checkedExceptions() {
        System.out.println("\n=== Checked Exceptions ===");

        // FileNotFoundException
        try {
            FileReader reader = new FileReader("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e);
        }

        // IOException
        try {
            File temp = File.createTempFile("demo", ".txt");
            FileReader reader = new FileReader(temp);
            reader.close();
            reader.read(); // trying to read after closing
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e);
        }
    }

    // ==============================
    // Errors (serious problems)
    // ==============================
    private static void errorExamples() {
        System.out.println("\n=== Error Examples ===");

        try {
            // Manually throwing OutOfMemoryError
            throw new OutOfMemoryError("Simulated JVM ran out of memory");
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError: " + e);
        }

        try {
            // Manually throwing StackOverflowError
            recursiveMethod(1);
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: " + e);
        }
    }

    private static void recursiveMethod(int x) {
        recursiveMethod(x + 1); // endless recursion
    }
}
