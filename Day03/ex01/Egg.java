public class Egg implements Runnable {

    private int count;
    private Say say;

    public Egg(int Count, Say say) {

        this.count = Count;
        this.say = say;
    }

    public void run() {

        for (int i = 0; i < count; i++) {
            say.sayEgg();
        }
    }
}
