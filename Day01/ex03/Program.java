public class Program {
    public static void main(String[] args) throws TransactionNotFoundException, UserNotFoundException {
        User Alice = new User("Alice");
        Alice.setBalance(1000);
        User Nick = new User("Nick");
        Nick.setBalance(5000);
        UsersList usersList = new UsersArrayList();

        Transaction one = new Transaction(TranslationType.INCOME, 500, Nick, Alice);
        Transaction two = new Transaction(TranslationType.OUTCOME, -100, Nick, Alice);
        Transaction three = new Transaction(TranslationType.INCOME, 500, Nick, Alice);

        Transaction one_c = new Transaction(TranslationType.OUTCOME, -500, Alice, Nick);
        Transaction two_c = new Transaction(TranslationType.INCOME, 100, Alice, Nick);
        Transaction three_c = new Transaction(TranslationType.OUTCOME, -500, Alice, Nick);

        Alice.getTransaction().addTransaction(one);
        Alice.getTransaction().addTransaction(two);
        Alice.getTransaction().addTransaction(three);

        Nick.getTransaction().addTransaction(one_c);
        Nick.getTransaction().addTransaction(two_c);
        Nick.getTransaction().addTransaction(three_c);

        Alice.getTransaction().removeTransaction(three.getID());

        usersList.addUsers(Alice);
        usersList.addUsers(Nick);

        for (int i = 1 ; i <= usersList.getUserCount() ; i++) {
            User user = usersList.findUserByID(i);
            System.out.printf("%s's Transactions:\n", user.getName());
            for (int j = 0 ; j < user.getTransaction().toArray().length ; j++) {
                Transaction tmp = user.getTransaction().toArray()[j];
                System.out.print(tmp.getID() + " ");
                System.out.print(tmp.getPayer().getName() + " ");
                System.out.println(tmp.getAmount() + " " + tmp.getType());
            }
        }

    }
}

enum TranslationType {
    INCOME,
    OUTCOME;
}