import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        String str;
        int j, i, l;
        int nameCount = 0;
        String[] names = new String[10];
        int[] hours = new int[7];
        int[] Factor = new int[10];
        int[][] month = new int[30][7];

        for (i = 9; i >= 0; i--) {
            j = i;
            Factor[i] = 1;
            while (j-- > 0) {
                Factor[i] *= 10;
            }
        }

        Scanner in = new Scanner(System.in);
        for (str = in.next(); !str.equals(".") && nameCount < 10; str = in.next()) {
            names[nameCount++] = str;
        }

        while (in.hasNextInt()) {
            i = in.nextInt();
            str = in.next();
            if (str.equals("TU")) {
                hours[0] += Factor[i - 1];
            } else if (str.equals("WE")) {
                hours[1] += Factor[i - 1];
            } else if (str.equals("TH")) {
                hours[2] += Factor[i - 1];
            } else if (str.equals("FR")) {
                hours[3] += Factor[i - 1];
            } else if (str.equals("SA")) {
                hours[4] += Factor[i - 1];
            } else if (str.equals("SU")) {
                hours[5] += Factor[i - 1];
            } else if (str.equals("MO")) {
                hours[6] += Factor[i - 1];
            }
        }

        in.next();
        str = in.next();
        while (!str.equals(".")) {
            i = in.nextInt();
            j = in.nextInt();
            for (l = 0; l < nameCount; l++) {
                if (names[l].equals(str)) {
                    break;
                }
            }
            str = in.next();
            if (str.equals("HERE")) {
                month[j - 1][i - 1] += Factor[l];
            } else if (str.equals("NOT_HERE")) {
                month[j - 1][i - 1] += 2 * Factor[l];
            }
            str = in.next();
        }
        in.close();

        String[] days = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};
        System.out.print("          ");
        for (i = 1; i < 31; i++) {
            j = (i - 1) % 7;
            for (int n = 0; n < 6; n++) {
                if ((hours[j] / Factor[n]) % 10 != 0) {
                    System.out.printf("%1d:00%3s%3d", n + 1, days[j], i);
                    System.out.print("|");
                }
            }
        }

        System.out.println();
        for (i = 0; i < nameCount; i++) {
            System.out.printf("%10s", names[i]);
            for (int m = 0; m < 30; m++) {
                j = m % 7;
                for (int n = 0; n < 6; n++) {
                    if ((hours[j] / Factor[n]) % 10 != 0) {
                        if ((month[m][n] / Factor[i]) % 10 == 1) {
                            System.out.print("         1|");
                        } else if ((month[m][n] / Factor[i]) % 10 == 2) {
                            System.out.print("        -1|");
                        } else {
                            System.out.print("          |");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
