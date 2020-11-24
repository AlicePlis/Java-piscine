import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        String week;
        int grade, j, i = 0;
        long tmp, gradeArrey = 0;
        Scanner in = new Scanner(System.in);

        while (++i <= 18) {
            week = in.next();

            if (week.equals("42")) {
                break;
            }

            if (!week.equals("Week") || i != in.nextInt()) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            j = 0;
            tmp = 9;

            while (++j <= 5) {
                grade = in.nextInt();

                if (grade < 1 || grade > 9) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }

                if (grade < tmp) {
                    tmp = grade;
                }
            }
            j = i;

            while (--j != 0) {
                tmp *= 10;
            }
            gradeArrey += tmp;
        }
        j = 0;

        while (--i != 0) {
            j++;
            tmp = gradeArrey;
            tmp %= 10;
            gradeArrey /= 10;

            if (j > 9) {
                System.out.print("week" + " " + j + " ");
            } else {
                System.out.print("week" + " " + j + "  ");
            }

            while (--tmp != 0) {
                System.out.print("=");
            }
            System.out.println("=>");
        }
        in.close();
    }
}