import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.IndexOutOfBoundsException;

abstract class Word {

    private String word;

    abstract int wordLength();

    public String getWord() {
        return word;
    }

    public void  setWord(String str) {
        this.word = str;
    }


}
