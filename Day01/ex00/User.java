public class User {

    private String Name;
    private int Balance;
    private int ID;

    public User(String Name, int ID) {
        this.Name = Name;
        this.ID = ID;
    }

    public void setBalance(int Balance) {
        if (Balance > 0) {
            this.Balance = Balance;
        } else {
            this.Balance = 0;
        }
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
