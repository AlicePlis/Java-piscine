public class Calculation implements Runnable {

    private int[] num;
    private int start;
    private int end;
    private long sum = 0;
    private int Name;
    private Total total;

    public Calculation(int start, int end, int[] Sum, int i, Total total) {

        this.start = start;
        this.end = end;
        this.num = Sum;
        this.Name = i;
        this.total = total;
    }

    public void run() {

        for (int i = start; i <= end; i++) {
            sum += num[i];
        }

        this.total.putsum(sum);
        System.out.printf("Thread %d: from %d to %d sum is %d\n", Name, start, end, sum);
    }
}
