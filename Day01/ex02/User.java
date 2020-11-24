public class User {

    private String Name;
    private int Balance;
    private final int ID;

    public User(String Name) {
        setName(Name);
        this.ID = UserIdsGenerator.getInstance().generateId();
    }

    public void setBalance(int Balance) {
        if (Balance > 0) {
            this.Balance = Balance;
        } else {
            this.Balance = 0;
        }
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return (Name);
    }

    public int getID() {
        return (ID);
    }

    public int getBalance() {
        return (Balance);
    }
}
