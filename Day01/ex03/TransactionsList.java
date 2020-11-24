import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction transaction);
    public void removeTransaction(UUID ID) throws TransactionNotFoundException;
    public Transaction[] toArray();
}
