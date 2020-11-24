public class Program {

    public static void main(String[] args) throws UserNotFoundException {

        User Alice = new User("Alice");
        Alice.setBalance(1000);
        User Nick = new User("Nick");
        Nick.setBalance(500);
        UsersList usersList = new UsersArrayList();

        usersList.addUsers(Alice);
        usersList.addUsers(Nick);
        System.out.printf("User ID 1 : %s\n", usersList.findUserByID(1).getName());
        System.out.printf("User ID 2 : %s\n", usersList.findUserByID(2).getName());
        User[] a = new User[100];

        for (int i = 0; i < 99; i++) {
            a[i] = new User("User" + i);
            usersList.addUsers(a[i]);
        }

        System.out.println("List of user:");
        for (int i = 1; i < usersList.getUserCount(); i++) {
            System.out.printf("ID %d %s\n", i, usersList.findUserByID(i).getName());
        }
        System.out.printf("User Index 1 balance: %d", usersList.findUserByIndex(1).getBalance());
    }
}
