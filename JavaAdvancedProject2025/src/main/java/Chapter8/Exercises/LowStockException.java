package Chapter8.Exercises;

/**
 * @author Xhanti Solani
 * Thrown when a {@code Product} has a low quantoty on stco
 *
 */

public class LowStockException extends Exception {

    /**
     * @code
     * @param message
     *
     */

    public LowStockException(String message) {
        super(message);
    }
}
