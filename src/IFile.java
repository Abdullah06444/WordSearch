import java.io.IOException;

public interface IFile {

    // get the words that the length is equal to determining size
    String readFile(int size) throws IOException;
    // guess the words
    String findWord(String str) throws IOException, InterruptedException;
}
