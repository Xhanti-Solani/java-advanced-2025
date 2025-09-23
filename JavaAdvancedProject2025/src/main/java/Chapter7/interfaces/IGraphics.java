package Chapter7.interfaces;

/**
 * Represents graphics operations such as painting and drawing a shape.
 */
public interface IGraphics {
    /**
     * Apply paint in the shape
     *
     * @param colour the colour of the paint as a String
     */
    void applyPaint(String colour);

    /**
     * Draw the shape
     */
    void draw();
}
