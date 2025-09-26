package Chapter9;

import Chapter9.InsufficientFundsException;


/**
 * @author Xhanti Solani
 * Class to demonstrate different access levels
 * publi -
 * private -
 */
enum AccountType{
    SAVINGS,
    CREDIT, DEBIT,
    LOAN, CHEQUE
}
public class BankAccount {
    private String AccountHolder;
    private String AccountNumber;
    private AccountType AccountType;
    private double Balance;

    public  BankAccount(String accountnumber,String accountholder, AccountType accounttype, double balance) {
        setAccountHolder(accountholder);
        setAccountType(accounttype);
        setAccountNumber(accountnumber,accounttype);
        setBalance(balance);
    }

    public String getAccountHolder() {
        return this.AccountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        if(accountHolder.length()<4){
            throw new IllegalArgumentException("Account holder length should be least 4 characters long");
        }

        this.AccountHolder = accountHolder;
    }

    /**
     * Set the account number with a prefix based on the {@code AccountType}.
     *
     * The prefix is set as follows:
     * (DEBIT = DB, SAVINGS = SV, LOAN = LN, CHEQUE = CQ, CREDIT = CR)
     *
     * @param accountNumber the account number to be prefixed
     *
     */

    public void setAccountNumber(String accountNumber, AccountType accountType) {
        String prefix;

        if (accountType == AccountType.DEBIT) {
            prefix = "DB-";
        } else if (accountType == AccountType.SAVINGS) {
            prefix = "SV-";
        } else if (accountType == AccountType.LOAN) {
            prefix = "LN-";
        } else if (accountType == AccountType.CHEQUE) {
            prefix = "CQ-";
        } else {
            prefix = "CR-";
        }

        this.AccountNumber = prefix + accountNumber;
    }




    public String getAccountNumber() {
        return this.AccountNumber;
    }
    public AccountType getAccountType() {
        return this.AccountType;
    }
    public void setAccountType(AccountType accountType) {
        this.AccountType = accountType;
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
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount >= this.Balance) {
            throw new InsufficientFundsException("Not enough funds in current account");
        }
        this.Balance += - amount;
    }
    public void transfer(double amount, BankAccount targetAccount) throws  InsufficientFundsException {
        if(amount >= this.Balance) {
            throw new InsufficientFundsException("Not enough funds in current account");
        }
        this.Balance += - amount;
        targetAccount.deposit(amount);
    }


    // display method
    public String displaydetails(){
        return "\nAccount Holder: " + getAccountHolder() +
               "\nAccount Number: " + getAccountNumber() +
               "\nAccount Type: " + getAccountType() +
               "\nBalance: " + getBalance();
    }
}
