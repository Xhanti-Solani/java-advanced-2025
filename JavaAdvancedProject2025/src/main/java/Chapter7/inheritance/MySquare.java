package Chapter7.inheritance;

public class MySquare extends MyShape {

    public MySquare(int side) {
        super(side,0);
    }

    @Override
    public double calcArea() {
        return this.length * this.length;
    }

    @Override
    public void display(String side) {
        System.out.println("************ " + side + " *************");
        System.out.println("side length = " + this.length);
        System.out.println("side area = " + this.calcArea());
        System.out.println("side area = " + width);
    }

}
