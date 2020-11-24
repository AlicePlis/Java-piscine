import java.io.IOException;

public class Similarity {
    private String[] words = new String[10];
    private int count = 0;
    private int[] similarity1 = new int[10];
    private int[] similarity2 = new int[10];
    private Dictionary dictionary;

    public Similarity() throws IOException {
        dictionary = new Dictionary();
    }

    private void checkWords() {

        if (count == words.length - 1) {
            String[] tmp = new String[words.length];
            int[] int_tmp1 = new int[words.length];
            int[] int_tmp2 = new int[words.length];

            for (int j = 0; j < words.length; j++) {
                tmp[j] = words[j];
                int_tmp1[j] = similarity1[j];
                int_tmp2[j] = similarity2[j];
            }

            words = new String[(int) (words.length * 1.5)];
            similarity1 = new int[(int) (words.length * 1.5)];
            similarity2 = new int[(int) (words.length * 1.5)];

            for (int j = 0; j < tmp.length; j++) {
                words[j] = tmp[j];
                similarity1[j] = int_tmp1[j];
                similarity2[j] = int_tmp2[j];
            }
        }
    }

    public void putword(String word, int k) {

        for (int i = 0; i < count; i++) {
            if (words[i].equals(word)) {
                if (k == 0) {
                    similarity1[i]++;
                } else {
                    similarity2[i]++;
                }
                return;
            }
        }
        this.words[count] = word;
        if (k == 0) {
            similarity1[count]++;
        } else {
            similarity2[count]++;
        }
        count++;
        checkWords();
    }

    public float getSimilarity() {
        int numerator = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        float denominator;

        for (int i = 0; i < words.length; i++) {
            numerator += similarity1[i] * similarity2[i];
            tmp1 += similarity1[i] * similarity1[i];
            tmp2 += similarity2[i] * similarity2[i];
        }

        denominator = (float) (Math.sqrt(tmp1) * Math.sqrt(tmp2));
        dictionary.createDictionary(words);

        if (similarity1[0] == 0 && similarity2[0] == 0) {
            return (1);
        }

        if (denominator == 0) {
            return (0);
        }

        return (numerator / denominator);
    }
}
