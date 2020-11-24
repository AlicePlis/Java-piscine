
public class Program {

    public static void main(String[] args) {

        User Alice = new User("Alice", 1);
        Alice.setBalance(1000);
        User Nick = new User("Nick", 2);
        Nick.setBalance(-100);

        System.out.printf("Баланс пользователя %s - %d\n", Alice.getName(), Alice.getBalance());
        System.out.printf("Баланс пользователя %s - %d\n", Nick.getName(), Nick.getBalance());
        Transaction From = new Transaction(TranslationType.INCOME, 500, Alice, Nick);
        Transaction To = new Transaction(TranslationType.OUTCOME, -500, Nick, Alice);
        System.out.printf("%s перевел %s %d\n",
                From.getPayer().getName(), From.getReceiver().getName(), From.getAmount());
        System.out.printf("%s получил перевод от %s %d\n",
                To.getPayer().getName(), To.getReceiver().getName(), To.getAmount());
    }
}

enum TranslationType {
    INCOME,
    OUTCOME;
}
