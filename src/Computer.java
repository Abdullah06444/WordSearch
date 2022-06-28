import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Word implements IFile{

    int wordLength()
    {

        System.out.print("Harf sayısını giriniz: ");
        Random random = new Random();
        return random.nextInt(22) + 1;
    }

    // get the words that the length is equal to determining size
    @Override
    public String readFile(int size) throws IOException {

        File file = new File("turkish_dictionary.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String line;
        ArrayList<String> line3 = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null) {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            if(size == line2[0].length())
                line3.add(line2[0]);
        }
        System.out.println(line3);
        fileReader.close();

        Random random = new Random();
        return line3.get(random.nextInt(line3.size()));
    }

    public String findWord(String str)
    {
        Scanner scanner = new Scanner(System.in);
        String guessing = "-".repeat(str.length());
        System.out.println(guessing);

/*        int i = -1, j = 9;
        do {

            System.out.print("Harf tahmin ediyorum: ");
            Random random = new Random();
            char ch = random.toString();

            while(str.contains(Character.toString(ch)))
            {

                i = str.indexOf(Character.toString(ch), i+1);
                if(i == -1)
                    break;

                guessing = guessing.substring(0,i) + ch + guessing.substring(i+1);
            }
            if(!str.contains(Character.toString(ch)))
                System.out.println("Bilemediniz. " + j-- + " hakkınız kaldı.");
            else
                System.out.println("Bildiniz!");
            System.out.println(guessing);

            if(str.equals(guessing))
                return "Oyunu kazandınız.";

        }while (j>=0);*/

        return "Oyunu kaybettiniz.";
    }
}
