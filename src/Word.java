import java.io.*;

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

        File file = new File("deneme.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while((line = bufferedReader.readLine()) != null)
        {

            String[] line2 = line.split("\\s+"); // take only first split from specific line

            if(size == line2[0].length())
                System.out.println(line2[0] + " " + line2[0].length());
        }
        fileReader.close();

        return line;
    }
}
