import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class People extends Word implements IFile{

    Scanner scanner = new Scanner(System.in);

    int wordLength()
    {

        System.out.print("Harf sayısını belirliyorum: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // get the words that the length is equal to determining size
    @Override
    public String readFile(int size) throws IOException {

        Textfile file = new Textfile();
        BufferedReader s = file.read();

        String line;
        String line3 = scanner.nextLine();

        while(line3.length() == size && (line = s.readLine()) != null) {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            if (line3.equals(line2[0]))
                return line3;
        }
        file.close();

        System.out.println("Belirlediğiniz kelime uzunluğu farklı ya da kelime sözlükte bulunamadı.");
        return null;
    }

    @Override
    public String findWord(@NotNull String str) throws StringIndexOutOfBoundsException
    {

        String guessing = "-".repeat(str.length());
        System.out.println(guessing);

        int i = -1, j = 9;
        do {

            System.out.print("Harf tahmin edin: ");
            char ch = scanner.nextLine().charAt(0);

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

            if(str.equals(guessing))
                return "Oyunu kazandınız.";

        }while (j>=0);

        return "Oyunu kaybettiniz.";
    }
}
