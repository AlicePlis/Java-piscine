import java.util.UUID;

public class Transaction {

    private TranslationType type;
    private int amount;
    private UUID ID;
    private User Payer;
    private User Receiver;

    public Transaction(TranslationType Type, int amount, User Payer, User Receiver) {
        this.ID = UUID.randomUUID();
        setPayer(Payer);
        setReceiver(Receiver);
        setType(Type);
        setAmount(amount);
    }

    public void setAmount(int amount) {
        if (type == TranslationType.INCOME) {
            if (amount > 0) {
                this.amount = amount;
            } else {
                this.amount = 0;
            }
        }
        else {
            if (amount < 0) {
                this.amount = amount;
            } else {
                this.amount = 0;
            }
        }
    }

    public void setID(UUID Id) {
        this.ID = Id;
    }

    public void setPayer(User payer) {
        Payer = payer;
    }

    public void setReceiver(User receiver) {
        Receiver = receiver;
    }

    public void setType(TranslationType type) {
        this.type = type;
    }

    public TranslationType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public UUID getID() {
        return ID;
    }

    public User getPayer() {
        return Payer;
    }

    public User getReceiver() {
        return Receiver;
    }
}
