import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    List<Account> accounts;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(int accountNumber, double balance) {
        Account account = new Account(accountNumber, balance, this);
        accounts.add(account);
    }

    public void displayAccountDetails() {
        System.out.println("Счета для клиентов " + customerId + ":");
        for (Account account : accounts) {
            System.out.println("Hомер счета: " + account.getAccountNumber() + ", Баланс: " + account.getBalance());
        }
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
