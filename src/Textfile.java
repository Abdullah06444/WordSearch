import java.io.*;

public class Textfile {

    File file = new File("turkish_dictionary.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    public Textfile() throws FileNotFoundException {
    }

    public BufferedReader read(){

        return bufferedReader;
    }

    public void close() throws IOException {

        bufferedReader.close();
        fileReader.close();
    }
}
