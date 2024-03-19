import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Вова");
        Customer customer2 = new Customer(2, "Настя");

        customer1.createAccount(101, 1000);
        customer1.createAccount(102, 2000);
        customer2.createAccount(201, 1500);

        customer1.createAccount(103, 0);
        customer1.createAccount(104, 0);
        customer1.accounts.get(0).performTransaction("1", TransactionType.DEBIT, 500);
        customer1.accounts.get(1).performTransaction("2", TransactionType.CREDIT, 1000);
        customer1.accounts.get(2).performTransaction("3", TransactionType.DEBIT, 200);
        customer1.accounts.get(3).performTransaction("4", TransactionType.DEBIT, 1500);

        customer1.accounts.get(0).displayTransactionHistory();
        customer1.displayAccountDetails();
        System.out.println("Общий баланс для клиента 1: " + customer1.getTotalBalance());

        customer2.displayAccountDetails();
        System.out.println("Общий баланс для клиента 2: " + customer2.getTotalBalance());

        runTests();
    }

    // Тесты
    @Test
    public static void runTests() {
        org.junit.runner.JUnitCore.main(
                "AccountTest",
                "CustomerTest"
        );
    }
}
