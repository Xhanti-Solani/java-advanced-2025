package Chapter7.interfaces;

/**
 * Represents a geometric shape with methods
 * to calculate area, perimeter, and display details.
 */
public interface IShape {

    /**
     * Calculate the area of the shape
     * @return the calculated area
     */
    int getArea();

    /**
     * Calculate the perimeter of the shape
     * @return the calculated perimeter
     */
    int getPerimeter();

    /**
     * Display the details of the shape
     */
    void display();
}
