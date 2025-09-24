package Chapter7.inheritance;

/**
 * @author Xhanti Solani
 * This Class extends the MyShape Class and
 * Calculates the area of a triangle
 * then displays it
 */
public class MyTriangle extends MyShape {

    public MyTriangle(int lenght, int height) {
        super(lenght, height);
    }

    @Override
    public  double calcArea(){
        return  this.width/2 * this.length;
    }

    @Override
    public void display(String shape) {
        System.out.println("*********** "+ shape +" **************");
        System.out.println("Lenght: " + this.length);
        System.out.println("Height: " + this.width);
        System.out.println("Area: " + calcArea());
    }



}
