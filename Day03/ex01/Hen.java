public class Hen implements Runnable {

    private int count;
    private Say say;

    public Hen(int Count, Say say) {

        this.count = Count;
        this.say = say;
    }

    public void run() {

        for (int i = 0; i < count; i++) {
            say.SayHen();
        }
    }
}
