package Chapter7.inheritance;

import Chapter7.BankAccount;

/**
 * @author Xhanti Solani
 * Child class that inherits from Student Class
 */
public class PartTimeStudent extends Student {

    private boolean isEmployed;

    // Constructor
    public PartTimeStudent(String stNumber, String firstname, String lastname, String major, boolean isEmployed) {
        super(stNumber, firstname, lastname, major);
        setEmployed(isEmployed);
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    @Override
    public void displaydetails(){
        System.out.println("Student Number: " + getStNumber());
        System.out.println("First Name: " + getFirstname());
        System.out.println("Last Name: " + getLastname());
        System.out.println("Major: " + getMajor());
        System.out.println("Employed: " + isEmployed);
    }
}
