public class Hen implements Runnable {

    private int count;

    public Hen(int Count) {
        this.count = Count;
    }

    public void run() {

        for (int i = 0 ; i < count ; i++) {
            System.out.println("Hen");
        }
    }
}
