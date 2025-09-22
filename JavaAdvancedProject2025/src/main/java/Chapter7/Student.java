package Chapter7;

public class Student {
    String stNumber;
    String firstname;
    String lastname;
    String major;

    public  Student() {
        stNumber = "123456";
        firstname = "Kelvin";
        lastname = "Smith";
        major = "Python";
    }

    public Student(String stNumber, String firstname, String lastname, String major) {
        this.stNumber = stNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
    }

    public void displaydetails(){
        System.out.println("Student Number: " + stNumber);
        System.out.println("First Name: " + firstname);
        System.out.println("Last Name: " + lastname);
        System.out.println("Major: " + major);
    }

}
