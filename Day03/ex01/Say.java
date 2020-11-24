public class Say {

    public String Who = "Egg";

    public synchronized void sayEgg() {

        while (Who.equals("Hen")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Egg");
        this.Who = "Hen";
        notify();
    }

    public synchronized void SayHen() {

        while (Who.equals("Egg")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hen");
        this.Who = "Egg";
        notify();
    }
}
