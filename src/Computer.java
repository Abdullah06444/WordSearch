import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Word implements IFile{

    Random random = new Random();

    int wordLength()
    {

        System.out.print("Harf sayısını giriniz: ");
        return random.nextInt(22) + 1;
    }

    // get the words that the length is equal to determining size
    @Override
    public String readFile(int size) throws IOException {

        Textfile file = new Textfile();
        BufferedReader s = file.read();

        String line;
        ArrayList<String> line3 = new ArrayList<>();

        while((line = s.readLine()) != null) {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            if(size == line2[0].length())
                line3.add(line2[0]);
        }
        //System.out.println(line3);
        file.close();

        return line3.get(random.nextInt(line3.size()));
    }

    @Override
    public String findWord(@NotNull String str) throws IOException, InterruptedException {
        String guessing = "-".repeat(str.length());
        System.out.println(guessing);

        int i = -1, j = 9;
        do {

            System.out.print("Harf tahmin ediyorum: ");
            String line3 = readFile(str.length());

            int k = random.nextInt(line3.length());
            char ch = line3.charAt(k)/* what am I doing */;
            System.out.println(ch);
            System.out.println("line 3 => " + line3);
            /*
            * int index = random.nextInt(s.length());
            * return s.charAt(index);
            *
            */

            while(str.contains(Character.toString(ch)))
            {

                i = str.indexOf(Character.toString(ch), i+1);
                if(i == -1)
                    break;

                guessing = guessing.substring(0,i) + ch + guessing.substring(i+1);
            }
            if(!str.contains(Character.toString(ch)))
                System.out.println("Bilemediniz. " + j-- + " hakkınız kaldı.");
            else {
                System.out.println("Bildiniz!");
                j++;
            }
            System.out.println(guessing);
            Thread.sleep(2000);

            if(str.equals(guessing))
                return "Oyunu kazandınız.";

        }while (j>=0);

        return "Oyunu kaybettiniz.";
    }
}
