package Chapter7.interfaces;

public class MyRectangle implements IShape, IGraphics {

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
    public void applyPaint(String colour) {

    }

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public int getPerimeter() {
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
        """, length, width, getArea(), getPerimeter());
    }

    @Override
    public void draw() {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
