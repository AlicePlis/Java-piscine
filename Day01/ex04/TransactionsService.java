import java.util.UUID;

public class TransactionsService {
    private UsersList userList;

    public TransactionsService() {
        userList = new UsersArrayList();
    }

    public void addUser(String Name, int balance) {
        User user = new User(Name);
        user.setBalance(balance);
        userList.addUser(user);
    }

    public String getUserName(int Id) throws UserNotFoundException {
        return (userList.findUserByID(Id).getName());
    }

    public int getUserBalance(int Id) throws UserNotFoundException {
        return (userList.findUserByID(Id).getBalance());
    }

    public void addTransaction(int Id1, int Id2, int amount) throws UserNotFoundException, IllegalTransactionException {
        User Payer = userList.findUserByID(Id1);
        User Receiver = userList.findUserByID(Id2);

        if (amount <= 0) {
            throw new IllegalTransactionException("Transaction is not possible, amount not correct!");
        }

        if (Payer.getBalance() - amount < 0) {
            throw new IllegalTransactionException("Transaction is not possible, insufficient funds!");
        }

        Transaction transaction_in = new Transaction(TranslationType.INCOME, amount, Payer, Receiver);
        Receiver.addTransaction(transaction_in);
        Receiver.setBalance(Receiver.getBalance() + amount);

        Transaction transaction_out = new Transaction(TranslationType.OUTCOME, -amount, Receiver, Payer);
        transaction_out.setID(transaction_in.getID());
        Payer.addTransaction(transaction_out);
        Payer.setBalance(Payer.getBalance() - amount);
    }

    public void removeTransaction(int userId, UUID transactionId) throws UserNotFoundException, TransactionNotFoundException {
        userList.findUserByID(userId).removeTransaction(transactionId);
    }

    public Transaction[] getUserTransaction(int Id) throws UserNotFoundException {
        return (userList.findUserByID(Id).getTransactionsArrey());
    }

    public Transaction[] getUnpairedTransactions() throws UserNotFoundException, TransactionNotFoundException {
        boolean flag;
        TransactionsList unpairedList = new TransactionsLinkedList();
        TransactionsList inc_list = new TransactionsLinkedList();
        TransactionsList out_list = new TransactionsLinkedList();
        int inc_count = 0;
        int out_count = 0;

        for (int i = 0; i < userList.getUserCount(); i++) {
            User user = userList.findUserByIndex(i);
            Transaction[] transaction = user.getTransactionsArrey();

            for (int j = 0; j < transaction.length; j++) {
                if (transaction[j].getType() == TranslationType.INCOME) {
                    inc_list.addTransaction(transaction[j]);
                    inc_count++;
                } else {
                    out_list.addTransaction(transaction[j]);
                    out_count++;
                }
            }
        }

        for (int i = 0; i < inc_count; i++) {
            flag = false;
            for (int j = 0; j < out_count; j++) {
                if (inc_list.toArray()[i].getID().equals(out_list.toArray()[j].getID())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                unpairedList.addTransaction(inc_list.toArray()[i]);
            }
        }
        for (int i = 0; i < out_count; i++) {
            flag = false;
            for (int j = 0; j < inc_count; j++) {
                if (out_list.toArray()[i].getID().equals(inc_list.toArray()[j].getID())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                unpairedList.addTransaction(out_list.toArray()[i]);
            }
        }
        return unpairedList.toArray();
    }
}
