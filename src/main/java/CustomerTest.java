import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void createAccount_shouldAddNewAccountToCustomer() {
        Customer customer = new Customer(1, "Вова");

        customer.createAccount(101, 1000);

        assertEquals(1, customer.accounts.size());
        assertEquals(101, customer.accounts.get(0).getAccountNumber());
    }

    @Test
    void getTotalBalance_shouldReturnSumOfAllAccountBalances() {
        Customer customer = new Customer(1, "Вова");
        customer.createAccount(101, 1000);
        customer.createAccount(102, 2000);

        double totalBalance = customer.getTotalBalance();

        assertEquals(3000, totalBalance);
    }
}
