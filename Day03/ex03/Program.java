import java.io.*;

public class Program {

    public static void main(String[] Args) throws FileNotFoundException {

        if (Args.length != 1) {
            System.err.println("Program --thredsCount=//input threads count here//");
            System.exit(-1);
        }

        String[] split = Args[0].split("=");

        if (!split[0].equals("--thredsCount") || !split[1].matches("\\d+")) {
            System.err.println("Program --thredsCount=//input count here//");
            System.exit(-1);
        }

        int thredsCount = Integer.parseInt(split[1]);

        UrlsList list = new UrlsList();
        list.putUrls("files_urls.txt");
        for (int i = 0; i < thredsCount; i++) {
            Thread t = new Thread(new Download("Thread" + "-" + (i + 1) ,list));
            t.start();
        }
    }
}
