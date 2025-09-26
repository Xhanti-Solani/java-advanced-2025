package Chapter9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class AccountTest {
    static BankAccount account;
    static BankAccount account2;

    @BeforeEach
    void setUp()
    {
        account = new BankAccount("123456789", "Xhanti Solani", AccountType.SAVINGS, 10000);
        account2 = new BankAccount("987654321", "Solani Xhanti", AccountType.LOAN, 10000);
    }

    @AfterEach
    @DisplayName("Test getCurrentAccountDetails")
    void  getCurrentAccountDetails(){
        System.out.print(account.displaydetails());
    }

    @Test
    @DisplayName("Test invalid Account Holder")
    void testInvalidAccountHolder(){
        // actual
        assertThrows(IllegalArgumentException.class, () -> account.setAccountHolder("Joe"));
    }

    @Test
    @DisplayName("Test account number prefix")
    void testAccountNumberPrefix(){
        String accountNumber = "123456789";
        String accountHolder = "Xhanti Solani";
        double balance = 1000;

        BankAccount accountLoan = new BankAccount(accountNumber, accountHolder, AccountType.LOAN, balance);
        BankAccount accountDebit = new BankAccount(accountNumber, accountHolder, AccountType.DEBIT, balance);
        BankAccount accountCheque = new BankAccount(accountNumber, accountHolder, AccountType.CHEQUE, balance);
        BankAccount accountCredit = new BankAccount(accountNumber, accountHolder, AccountType.CREDIT, balance);
        BankAccount accountSavings = new BankAccount(accountNumber, accountHolder, AccountType.SAVINGS, balance);

        assertAll(
                ()-> assertEquals("LN-" + accountNumber, accountLoan.getAccountNumber()),
                ()-> assertEquals("DB-" + accountNumber, accountDebit.getAccountNumber()),
                ()-> assertEquals("CQ-" + accountNumber, accountCheque.getAccountNumber()),
                ()-> assertEquals("CR-" + accountNumber, accountCredit.getAccountNumber()),
                ()-> assertEquals("SV-" + accountNumber, accountSavings.getAccountNumber())
        );
    }

    @Test
    @DisplayName("Test Withdrawal - Insufficient Funds")
    void testWithdrawalInsufficientFunds(){
        double amount = 10000;
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(amount));
    }
    @Test
    @DisplayName("Test Transfer - Insufficient Funds")
    void testTransferInsufficientFunds(){
        double amount = 10000;
        assertThrows(InsufficientFundsException.class, () -> account.transfer(amount,account2));
    }

    @Test
    @DisplayName("Test Account Deposit")
    void testAccountDeposit()
    {
        // Arrange
        double amountToDeposit = 2000;
        double expectedBalance = 12000;

        // Actual
        account.deposit(amountToDeposit);
        double actualBalance = account.getBalance();

        // Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test withdrawal")
    void testAccountWithdrawal()
    {
        // Arrange
        double amountToWithdraw = 1000;
        double expectedBalance = 9000;

        // Actual
        try {
            account.withdraw(amountToWithdraw);
        } catch (InsufficientFundsException e) {
            System.out.print(e.getMessage());
        }
        double actualBalance = account.getBalance();

        // Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Test Transfer")
    void testTransfer()
    {
        // Arrange
        double amountToTransfer = 5000;
        double expectedAccountBalance = 5000;
        double expectedTargetBalance = 15000;

        // Actual
        try {
            account.transfer(amountToTransfer, account2);
        } catch (InsufficientFundsException e) {
            System.out.print(e.getMessage());
        }

        double accountBalance = account.getBalance();
        double targetBalance = account2.getBalance();

        // Assert
        assertAll(
                () ->  assertEquals(expectedAccountBalance, accountBalance),
                () ->  assertEquals(expectedTargetBalance, targetBalance)
        );

    }

}
