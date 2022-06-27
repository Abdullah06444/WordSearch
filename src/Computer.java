import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Computer extends Word{

    int wordLength()
    {

        System.out.print("Harf sayısını giriniz: ");
        Random random = new Random();
        return random.nextInt(21) + 1;
    }

    // get the words that the length is equal to determining size
    String function(int size) throws IOException {

        File file = new File("turkish_dictionary.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        ArrayList<String> line3 = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null)
        {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            if(size == line2[0].length())
                line3.add(line2[0]);
        }
        System.out.println(line3);
        fileReader.close();

        Random random = new Random();
        return line3.get(random.nextInt(line3.size()));
    }

    String findWord()
    {


        return null;
    }
}
