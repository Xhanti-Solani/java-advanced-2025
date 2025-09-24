package Chapter7.inheritance;

/**
 * @author Xhanti Solani
 *
 */

public class StudentRunner {
    public static void main(String[] args) {


        Student student = new Student("123456", "Andile", "Smith", "Java");
        student.displaydetails();


        PartTimeStudent partTimeStudent = new PartTimeStudent("123456", "Andile", "Smith", "Java", true);
        partTimeStudent.displaydetails();


    }

}
