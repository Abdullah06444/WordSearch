import java.util.Random;

class Computer extends Word{

    int wordLength()
    {

        System.out.print("Harf sayısını giriniz: ");
        Random random = new Random();
        return random.nextInt(21) + 1;
    }

    String findWord()
    {


        return null;
    }
}
