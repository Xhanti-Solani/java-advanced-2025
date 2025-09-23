package Chapter7.inheritance;

public class MyPentagon extends MyShape {
    public MyPentagon(int length) {
        super(length, length);
    }

    @Override
    public double calcArea() {
        double a = this.length; // side length of pentagon
        return (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(a, 2);
    }

    @Override
    public void display(String shape) {
        System.out.println("*********** " + shape + " **************");
        System.out.println("Side Length: " + this.length);
        System.out.println("Area: " + calcArea());
    }
}
