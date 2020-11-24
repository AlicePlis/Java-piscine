public class Program {

    public static void main(String[] Args) {

        if (Args.length != 1) {
            System.err.println("Program --count=//input count here//");
            System.exit(-1);
        }

        String[] split = Args[0].split("=");
        if (!split[0].equals("--count") || !split[1].matches("\\d+")) {
            System.err.println("Program --count=//input count here//");
            System.exit(-1);
        }

        int count = Integer.parseInt(split[1]);

        Thread m1 = new Thread(new Egg(count));
        Thread m2 = new Thread(new Hen(count));
        m1.start();
        m2.start();
        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
