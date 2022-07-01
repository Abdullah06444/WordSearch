import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class People extends Word implements IFile{


    public int wordLength()
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
        Scanner scanner = new Scanner(System.in);
        String line3 = scanner.nextLine();

        // read each line from text file
        while(line3.length() == size && (line = s.readLine()) != null) {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            // girdiğimiz kelime text dosyasında var mı
            if (line3.equals(line2[0]))
                return line3;
        }
        file.close();

        System.out.println("Belirlediğiniz kelime uzunluğu farklı ya da kelime sözlükte bulunamadı.");
        return null;
    }

    @Override
    public String findWord(@NotNull String str) throws StringIndexOutOfBoundsException {

        String guessing = "-".repeat(str.length());
        System.out.println(guessing);

        int i = -1, j = 9;
        StringBuilder line4 = new StringBuilder();
        do {

            System.out.print("Harf tahmin edin: ");

            Scanner scanner = new Scanner(System.in);
            char ch = Character.toLowerCase(scanner.nextLine().charAt(0));

            // aynı harf girince kalan hak sayımızdan düşmemesi için
            if(line4.toString().contains(Character.toString(ch))) {
                System.out.println("Bu harfi daha önce girdiniz.");
                continue;
            }
            // add all characters that the player choose already
            line4.append(ch);

            // bildikçe indislerin açılışı
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

            //System.out.println("Daha önce girdiğimiz harf stringi => " + line4);
            System.out.println(guessing);

            if(str.equals(guessing))
                return "Oyunu kazandınız.";

        }while (j>=0);

        return "Oyunu kaybettiniz.";
    }
}
