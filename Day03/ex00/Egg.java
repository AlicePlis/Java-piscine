public class Egg implements Runnable{

    private int count;

    public Egg(int Count) {
        this.count = Count;
    }

    public void run() {

        for (int i = 0 ; i < count ; i++) {
            System.out.println("Egg");
        }
    }
}
