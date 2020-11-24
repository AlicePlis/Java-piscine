import java.io.*;
import java.util.Scanner;

public class Program {

    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];

        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public static void main(String[] Args) throws IOException {

        Scanner in = new Scanner(System.in);
        String str;
        Signatures sig = new Signatures();

        for (String filename = in.nextLine(); !filename.equals("42"); filename = in.nextLine()) {
            str = " ";
            try (FileInputStream fin = new FileInputStream(filename)) {
                for (int j = 0; j <= 7; j++) {
                    int i = fin.read();
                    str = str + byteToHex((byte) i) + " ";
                }

                if (sig.isProcessed(str.toUpperCase())) {
                    System.out.println("PROCESSED");
                } else {
                    System.out.println("UNDEFiNED");
                }
            }
        }
    }
}
