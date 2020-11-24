import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Signatures {
    private Map<String, String> signatures;
    private File result;
    private int count;

    public Signatures() throws IOException {
        signatures = new HashMap<>();
        result = new File("result.txt");

        Writer fos = new OutputStreamWriter(new FileOutputStream(result, false));
        fos.write("");
        fos.close();

        Scanner line = new Scanner(new File("signatures.txt"));
        while (line.hasNext()) {
            String tmp = line.next();
            signatures.put(line.nextLine(), tmp.substring(0, tmp.length() - 1));
            count++;
        }
    }

    public void Print() {
        System.out.println(signatures.toString());
        System.out.println(count);
    }

    public boolean isProcessed(String str) {
        String form;
        for (int i = 1 ; i < str.length() ; i += 3) {
            if ((form = signatures.get(str.substring(0, str.length() - i))) != null) {
                System.out.println(form + " " + i);
                try (Writer fos = new OutputStreamWriter(new FileOutputStream(result, true))) {
                    fos.append(form);
                    fos.append("\n");
                    return (true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (false);
    }
}
