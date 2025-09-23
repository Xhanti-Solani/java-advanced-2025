package Chapter8.Exercises;

/**
 * @author Xhanti Solani
 * Thrown when there is a high price increase on a {@code Product}
 *
 */

public class HighPriceIncreaseException extends RuntimeException {

    /**
     * Cintructs an {@code LowStockException} with a specified detail message
     * @param message The detail message
     */

    public HighPriceIncreaseException(String message) {
        super(message);
    }
}
