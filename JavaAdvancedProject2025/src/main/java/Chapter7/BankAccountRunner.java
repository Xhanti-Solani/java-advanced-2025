package Chapter7;

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Xhanti Solani", "123456789", AccountType.SAVINGS, 5000);
        BankAccount accountTwo = new BankAccount("Andile Ndlela", "987654321", AccountType.CREDIT, 800);


        account.transfer(500, accountTwo);
        accountTwo.displaydetails();

        accountTwo.deposit(1000);
        accountTwo.displaydetails();



        account.deposit(10000);
        account.displaydetails();

        account.withdraw(10000);
        account.displaydetails();

        System.out.println("Account Account: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Balance: " + account.getBalance());













    }



}
