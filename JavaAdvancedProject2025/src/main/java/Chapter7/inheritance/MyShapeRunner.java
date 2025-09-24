package Chapter7.inheritance;

public class MyShapeRunner {
    public static void main(String[] args) {

        MyShape myShape = new MyShape(10, 10);
        myShape.display("Shape");

        MyRectangle rectangle = new MyRectangle(10, 10);
        rectangle.display("rectangle");



        MySquare square = new MySquare(10);
        square.display("Square");


        MyCircle circle = new MyCircle(10);
        circle.display("Circle");


        MyTriangle triangle = new MyTriangle(10, 10);
        triangle.display("triangle");


        MyPentagon pentagon = new MyPentagon(10);
        pentagon.display("Pentagon");


    }
}
