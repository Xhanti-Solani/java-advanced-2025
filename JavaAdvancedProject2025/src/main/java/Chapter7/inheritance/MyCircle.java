package Chapter7.inheritance;

/**
 * @author Xhanti Solani
 * This Class inherits from the MyShape Class and
 * Calculates the area of a Circle
 *
 */

public class MyCircle extends MyShape {

    public MyCircle(int radius) {
        super(radius, 0);
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(this.length, 2);
    }

    @Override
    public void display(String shape) {
        System.out.println("*********** "+ shape +" **************");
        System.out.println("Radius: " + this.length);
        System.out.println("Area: " + calcArea());

    }
}
