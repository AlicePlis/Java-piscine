import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException, UserNotFoundException, IllegalTransactionException {
        TransactionsService service = new TransactionsService();
        String[] name = {"Alice", "Mary", "Nick", "Lili", "Harry"};

        for (int i = 0; i < 5; i++) {
            service.addUser(name[i], 5000);
        }

        for (int i = 1; i < 5; i++) {
            service.addTransaction(i, i + 1, 20 * i);
        }

        for (int i = 1; i < 6; i++) {
            Transaction[] arr = service.getUserTransaction(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%s  %s  %d %s \n", arr[j].getID(), arr[j].getPayer().getName(), arr[j].getAmount(), arr[j].getType());
            }
        }
        UUID id = service.getUserTransaction(1)[0].getID();
        service.removeTransaction(1, id);

        System.out.println();
        for (int i = 1; i < 6; i++) {
            Transaction[] arr = service.getUserTransaction(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%s  %s  %d %s \n", arr[j].getID(), arr[j].getPayer().getName(), arr[j].getAmount(), arr[j].getType());
            }
        }
        System.out.println();
        Transaction[] unpairedTransactions = service.getUnpairedTransactions();
        for (int i = 0; i < unpairedTransactions.length; i++) {
            System.out.printf("%s  %s  %d %s \n", unpairedTransactions[i].getID(),
                    unpairedTransactions[i].getPayer().getName(), unpairedTransactions[i].getAmount(), unpairedTransactions[i].getType());
        }
    }
}

enum TranslationType {
    INCOME,
    OUTCOME;
}
