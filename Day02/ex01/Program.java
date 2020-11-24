import java.io.*;

public class Program {
    public static void main(String[] Args) throws IOException {
        Similarity dict = new Similarity();
        if (Args.length != 2) {
            System.err.println("usage: Program file1 file2");
            System.exit(-1);
        }
        for (int i = 0 ; i < 2 ; i++) {
            try (FileReader fr = new FileReader(Args[i])) {
               try (BufferedReader br = new BufferedReader(fr)) {
                   String line;
                   while ((line = br.readLine()) != null) {
                       String[] words = line.split(" ");
                       for (int j = 0; j < words.length; j++) {
                           dict.putword(words[j], i);
                       }
                   }
               }
               catch (IOException ex) {
                   System.err.println(ex.getMessage());
                   System.exit(-1);
               }
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        }
        System.out.printf("Similarity = %.2f", dict.getSimilarity());
    }
}