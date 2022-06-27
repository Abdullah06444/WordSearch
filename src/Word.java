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
    String function(int size) {

        return "";
    }
}
