package Chapter7.inheritance;

/**
 * @author Xhanti Solani
 * Protected attributes are accessible within the parent class
 * and any other child classes that inherits from the parent class
 *
 */

public class MyShape {

    protected int length;
    protected int width;

    public  MyShape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double calcArea() {
        return length * width;
    }

    public void display(String shape) {
        System.out.println("*********** "+ shape +" **************");
        System.out.println("Lenght: " + this.length);
        System.out.println("Width: " + this.width);
        System.out.println("Area: " + calcArea());

    }
}
