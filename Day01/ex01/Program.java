public class Program {

    public static void main(String[] args) {

        User Alice = new User("Alice");
        Alice.setBalance(1000);
        User Nick = new User("Nick");
        Nick.setBalance(2000);

        System.out.printf("ID %s : %d\n", Alice.getName(), Alice.getID());
        System.out.printf("Balance user %s with ID %d : %d\n", Nick.getName(), Nick.getID(), Nick.getBalance());
    }
}
