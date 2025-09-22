package Chapter7;

public class StudentRunner {
    public static void main(String[] args) {
        // Declare
        Student st = new Student("123456", "Kelvin", "Smith", "Python");

        // display
        st.displaydetails();

        //Declare
        Student st1 = new Student("45698", "Carol", "Smith", "Java");

       //Use
        st1.displaydetails();

    }
}

