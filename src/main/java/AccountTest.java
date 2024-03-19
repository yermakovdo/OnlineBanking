import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void performTransaction_withDebitAndEnoughBalance_shouldUpdateBalanceAndAddTransaction() {
        Customer customer = new Customer(1, "Вова");
        Account account = new Account(101, 1000, customer);

        account.performTransaction("1", TransactionType.DEBIT, 500);

        assertEquals(500, account.getBalance());
        assertEquals(1, account.transactionHistory.size());
    }

    @Test
    void performTransaction_withDebitAndInsufficientBalance_shouldNotUpdateBalanceAndNotAddTransaction() {
        Customer customer = new Customer(1, "Вова");
        Account account = new Account(101, 1000, customer);

        account.performTransaction("1", TransactionType.DEBIT, 1500);

        assertEquals(1000, account.getBalance());
        assertEquals(0, account.transactionHistory.size());
    }

    @Test
    void performTransaction_withCredit_shouldUpdateBalanceAndAddTransaction() {
        Customer customer = new Customer(1, "Вова");
        Account account = new Account(101, 1000, customer);

        account.performTransaction("1", TransactionType.CREDIT, 500);

        assertEquals(1500, account.getBalance());
        assertEquals(1, account.transactionHistory.size());
    }
}
