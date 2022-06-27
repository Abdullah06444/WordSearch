import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class People extends Word{

    int wordLength()
    {

        System.out.print("Harf sayısını belirliyorum: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // get the words that the length is equal to determining size
    String function(int size) throws IOException {

        File file = new File("deneme.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine(), line3;
        while(line.length() == size && (line3 = bufferedReader.readLine()) != null) {
            String[] line2 = line3.split("\\s+");
            if (line.equals(line2[0])) {
                return line;
            }
        }

        System.out.println("Belirlediğiniz kelime uzunluğu farklı ya da kelime sözlükte bulunamadı. " +
                "Lütfen tekrar giriniz: ");
        function(size);
        return "";
    }

    String findWord()
    {


        return null;
    }
}
