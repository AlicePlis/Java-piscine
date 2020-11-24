import java.util.Scanner;

public class Program {

    static final int MAX_LENGTH = 65535;
    static final int MAX_COUNT = 10;

    public static void main(String[] args) {
        int i, j;
        int chr, cnt, max;
        int[] AllCharsArr = new int[MAX_LENGTH];
        int[] CountArr = new int[MAX_COUNT];
        int[] CharsArr = new int[MAX_COUNT];
        int[] hashCount = new int[MAX_COUNT];

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        for (char c : str.toCharArray()) {
            if ((int) c < MAX_LENGTH) {
                AllCharsArr[c]++;
            }
        }

        for (j = 0; j < MAX_COUNT; j++) {
            cnt = 0;
            chr = 0;

            for (i = 0; i < MAX_LENGTH; i++) {
                if (AllCharsArr[i] > cnt) {
                    cnt = AllCharsArr[i];
                    chr = i;
                }
            }
            CharsArr[j] = chr;
            CountArr[j] = cnt;
            AllCharsArr[chr] = 0;
        }

        for (i = 0; i < MAX_COUNT; i++) {
            if (CountArr[0] > MAX_COUNT) {
                hashCount[i] = (CountArr[i] * MAX_COUNT) / CountArr[0];
            } else {
                hashCount[i] = CountArr[i];
            }
        }

        if (CountArr[0] > MAX_COUNT) {
            max = MAX_COUNT;
        } else {
            max = CountArr[0];
        }

        if (CountArr[0] > 0) {
            for (i = max; i >= 0; i--) {
                for (j = 0; j < MAX_COUNT; j++) {
                    if (CountArr[j] > 0) {
                        if (i > hashCount[j]) {
                            System.out.print("   ");
                        } else if (i == hashCount[j]) {
                            System.out.printf("%3d", CountArr[j]);
                        } else {
                            System.out.print("  #");
                        }
                    }
                }
                System.out.println();
            }
            for (i = 0; i < MAX_COUNT; i++) {
                System.out.print("  " + (char)CharsArr[i]);
            }
        }
    }
}
