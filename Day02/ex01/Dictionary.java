import java.io.*;

public class Dictionary {
    File dictionary;

    public Dictionary() throws IOException {
        dictionary = new File("dictionary.txt");
        Writer fos = new OutputStreamWriter(new FileOutputStream(dictionary, false));
        fos.write("");
        fos.close();
    }

    public void createDictionary(String[] words) {
        for (int i = 0 ; words[i] != null ; i++) {
            try (BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dictionary, true)))) {
                fos.append(words[i]);
                fos.append("\n");
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }
}
