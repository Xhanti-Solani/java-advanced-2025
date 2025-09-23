package Chapter7.inheritance;

/**
 * @author Xhanti Solani
 * Parent Class with common attributes for part-time and full-time
 * students
 */

public class Student {

    private String stNumber;
    private String firstname;
    private String lastname;
    private String major;

//    public Student() {
//        stNumber = "123456";
//        firstname = "Kelvin";
//        lastname = "Smith";
//        major = "Python";
//    }

    public Student(String stNumber, String firstname, String lastname, String major) {
        setStNumber(stNumber);
        setFirstname(firstname);
        setLastname(lastname);
        setMajor(major);
    }

    // getters and setter
    public String getStNumber() {
        return stNumber;
    }
    public void setStNumber(String stNumber) {
        this.stNumber = stNumber;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public void displaydetails(){
        System.out.println("Student Number: " + getStNumber());
        System.out.println("First Name: " + getFirstname());
        System.out.println("Last Name: " + getLastname());
        System.out.println("Major: " + getMajor());
    }

}
