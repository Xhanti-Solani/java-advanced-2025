package Chapter7;

/**
 * @author Xhanti Solani
 * Class to demonstrate different access levels
 * publi -
 * private -
 */
enum AccountType{
    CHECKING, SAVINGS,
    CREDIT, DEBIT,
    LOAN, CHEQUE
}
public class BankAccount {
    private String AccountHolder;
    private String AccountNumber;
    private AccountType AccountType;
    private double Balance;

    public BankAccount() {

    }

    public  BankAccount(String accountholder, String accountnumber, AccountType accounttype, double balance) {
        this.AccountHolder = accountholder;
        this.AccountNumber = accountnumber;
        this.AccountType = accounttype.SAVINGS;
        this.Balance = balance;
    }

    public String getAccountHolder() {
        return this.AccountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.AccountHolder = accountHolder;
    }
    public String getAccountNumber() {
        return this.AccountNumber;
    }
    public AccountType getAccountType() {
        return this.AccountType;
    }
    public double getBalance() {
        return this.Balance;
    }
    public void setBalance(double balance) {
        this.Balance = balance;
    }


    // Methods
    public  void deposit(double amount) {
        this.Balance += amount;
    }
    public void withdraw(double amount) {
        this.Balance += - amount;
    }
    public void transfer(double amount, BankAccount destination) {
        this.Balance += - amount;
        destination.deposit(amount);
    }


    // display method
    public  void displaydetails(){
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Number: " + AccountNumber);
        System.out.println("Account Type: " + AccountType);
        System.out.println("Balance: " + Balance);
    }
}
