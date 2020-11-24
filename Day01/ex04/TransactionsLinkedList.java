import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node first;
    private Node last;
    private int size;

    public TransactionsLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void addTransaction(Transaction transaction) {
        if (first == null) {
            Node node = new Node(null, transaction, null);
            first = node;
            last = node;
        }
        else {
            Node node = new Node(last, transaction, null);
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeTransaction(UUID ID) throws TransactionNotFoundException {
        if (first != null) {
            Node tmp = first;
            if (tmp.isFind(ID)) {
                if (tmp.next == null) {
                    tmp.transaction = null;
                    first = null;
                    last = null;
                    size = 0;
                    return;
                } else {
                    tmp.transaction = null;
                    first = tmp.next;
                    first.prev = null;
                    size--;
                    return;
                }
            }
            while (tmp.next != null) {
                tmp = tmp.next;
                if (tmp.isFind(ID)) {
                    tmp.removeNode();
                    size--;
                    return;
                }
            }
        }
        throw new TransactionNotFoundException("Transaction not found!");
    }

    public Transaction[] toArray() {

        Transaction[] array = new Transaction[size];
        if (first != null) {
            Node tmp = first;
            int i = 0;
            while (tmp != null) {
                array[i++] = tmp.transaction;
                tmp = tmp.next;
            }
        }
        return array;
    }

    private class Node {
        Transaction transaction;
        Node next;
        Node prev;

        Node(Node prev, Transaction transaction, Node next)
        {
            this.transaction = transaction;
            this.next = next;
            this.prev = prev;
        }

        boolean isFind(UUID ID) {
            return (transaction.getID().equals(ID));
        }

        public void removeNode() {
            transaction = null;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
        }
    }
}
