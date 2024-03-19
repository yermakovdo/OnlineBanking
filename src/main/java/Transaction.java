import java.util.Date;

public class Transaction {
    private String transactionId;
    private TransactionType type;
    private double amount;
    private Date date;

    public Transaction(String transactionId, TransactionType type, double amount) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Идентификатор транзакции: " + transactionId +
                ", Дата: " + date +
                ", Тип: " + type +
                ", Сумма: " + amount;
    }
}
