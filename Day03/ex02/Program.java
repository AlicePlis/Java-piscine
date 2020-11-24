
import java.util.concurrent.ThreadLocalRandom;

public class Program {

    public static void main(String[] Args) throws InterruptedException {

        if (Args.length != 2) {
            System.err.println("Invalid number of arguments");
            System.exit(-1);
        }

        String[] split1 = Args[0].split("=");
        String[] split2 = Args[1].split("=");

        if (!split1[0].equals("--arraySize") || !split2[0].equals("--threadsCount")) {
            System.err.println("Program --arraySize=//input size of arrey here// " +
                    "--threadsCount=//input threads count here//");
            System.exit(-1);
        }

        long sum = 0;
        Total total = new Total();
        int Lenght = Integer.parseInt(split1[1]);
        int CountThreads = Integer.parseInt(split2[1]);
        int count ,countLast, start, end;

        int[] Sum = new int[Lenght];

        for (int i = 0; i < Lenght; i++) {
            Sum[i] = ThreadLocalRandom.current().nextInt(-1000, 1001);
            sum += Sum[i];
        }

        System.out.println("Sum: " + sum);
        count = Lenght / CountThreads;
        countLast = Lenght - count * (CountThreads - 1);
        Thread[] threads = new Thread[CountThreads];

        for (int i = 0; i < CountThreads - 1; i++) {
            start = i * count;
            end = start + count - 1;
            int j = i + 1;
            threads[i] = new Thread(new Calculation(start, end, Sum, j, total));
        }

        threads[CountThreads - 1] = new Thread(new Calculation(Lenght - countLast, Lenght - 1, Sum, CountThreads, total));

        for (int i = 0; i < CountThreads; i++) {
            threads[i].start();
            threads[i].join();
        }

        System.out.printf("Sum by threads: %d\n", total.sum);
    }
}
