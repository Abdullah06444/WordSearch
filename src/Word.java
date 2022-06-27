import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.IndexOutOfBoundsException;

abstract class Word {

    private String word;

    abstract int wordLength();
    abstract String findWord();

    public String getWord() {
        return word;
    }

    public void  setWord(String str) {
        this.word = str;
    }

    // get the words that the length is equal to determining size
    String function(int size) throws IOException {

        File file = new File("turkish_dictionary.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        ArrayList<String> line3 = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null)
        {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            if(size == line2[0].length())
                line3.add(line2[0]);
        }
        System.out.println(line3);
        fileReader.close();

        Random random = new Random();
        return line3.get(random.nextInt(line3.size()));
    }
}
