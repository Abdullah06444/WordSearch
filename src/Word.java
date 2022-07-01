public abstract class Word {

    private String word;
    // determine length of the word
    public abstract int wordLength();
    // encapsulation
    public String getWord() {
        return word;
    }

    public void  setWord(String str) {
        this.word = str;
    }

}
