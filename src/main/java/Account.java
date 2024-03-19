import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private double balance;
    private Customer customer;
    List<Transaction> transactionHistory;

    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.transactionHistory = new ArrayList<>();
    }

    public void performTransaction(String transactionId, TransactionType type, double amount) {
        if (type == TransactionType.DEBIT && amount > balance) {
            System.out.println("Недостаточно средств для дебетовой транзакции.");
            return;
        }
        if (type == TransactionType.CREDIT) {
            balance += amount;
        } else {
            balance -= amount;
        }
        Transaction transaction = new Transaction(transactionId, type, amount);
        transactionHistory.add(transaction);
    }

    public void displayTransactionHistory() {
        System.out.println("История транзакций по счету " + accountNumber + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
