import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int sum;
        int count = 0;
        int div;
        Scanner in = new Scanner(System.in);

        for (int number = in.nextInt(); number != 42; number = in.nextInt()) {
            count++;
            sum = 0;
            div = 2;

            while (number > 10) {
                sum += number % 10;
                number /= 10;
            }
            sum += number;

            if (sum <= 1) {
                count--;
            }

            if (sum != 2 && sum != 3) {
                while (div < sum) {
                    if (sum % div == 0) {
                        count--;
                        break;
                    }
                    div += 1;
                }
            }
        }
        in.close();
        System.out.println("Count of coffe-request - " + count);
    }
}