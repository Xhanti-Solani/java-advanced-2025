package Chapter7.abstraction;

public class MyRectangle extends MyShape {
    private int length, width;

    /**
     * Calculate the perimeter
     *
     * @return the perimeter as a {@code double}
     *
     */

    public MyRectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public int calcArea() {
        return length * width;
    }

    @Override
    public int calcPerimeter() {
        return (length + width) *2;
    }

    @Override
    public void display() {
        System.out.println("===== " + this.getClass().getSimpleName() + " =====");
        System.out.format("""
        Length   : %d
        Width    : %d
        Area     : %d
        Perimeter: %d
        """, length, width, calcArea(), calcPerimeter());
    }

    @Override
    public void draw() {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

}
