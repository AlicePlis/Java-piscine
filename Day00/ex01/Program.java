import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();
        int div;
        int iter = 0;
        boolean isFlag = false;

        if (number <= 1) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        } else {
            if (number % 2 == 0) {
                System.out.println(isFlag + " " + ++iter);
            } else if (number == 3 || number == 5 || number == 7) {
                isFlag = true;
                System.out.println(isFlag + " " + ++iter);
            } else {
                div = 3;

                while (div * div <= number) {
                    iter++;
                    if (number % div == 0) {
                        isFlag = false;
                        System.out.println(isFlag + " " + iter);
                        break;
                    } else {
                        isFlag = true;
                    }
                    div += 2;
                }

                if (isFlag) {
                    System.out.println(isFlag + " " + iter);
                }
            }
        }
    }
}
