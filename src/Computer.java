import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Word implements IFile{

    Random random = new Random();

    public int wordLength()
    {

        System.out.print("Harf sayısını giriniz: ");
        return random.nextInt(21) + 1;
    }

    // get the words that the length is equal to determining size
    @Override
    public String readFile(int size) throws IOException, IllegalArgumentException {

        Textfile file = new Textfile();
        BufferedReader s = file.read();

        String line;
        ArrayList<String> line3 = new ArrayList<>();

        // read each file from text file
        while((line = s.readLine()) != null) {

            String[] line2 = line.split("\\s+"); // take only first split from specific line
            // girdiğimiz size değerine eşit olan tüm lineları getir
            if(size == line2[0].length())
                line3.add(line2[0]);
        }
        file.close();

        if(!line3.isEmpty())
            return line3.get(random.nextInt(line3.size()));
        return null;
    }

    @Override
    public String findWord(@NotNull String str) throws IOException, InterruptedException {

        String guessing = "-".repeat(str.length());
        System.out.println(guessing);

        int i = -1, j = 9, k, m;
        StringBuilder line4 = new StringBuilder();
        do {

            Textfile file = new Textfile();
            BufferedReader s = file.read();

            String line;
            ArrayList<String> line3 = new ArrayList<>();

            while((line = s.readLine()) != null) {

                String[] line2 = line.split("\\s+"); // take only first split from specific line
                if(str.length() == line2[0].length())
                {

                    for (k = 0; k < str.length(); k++)
                    {

                        // ya belirsiz ve önceki seçtiğimiz kelimelerden farklı
                        // ya da belirli ve ilgili indisler ile aynı
                        // böylelikle guessing için string liste elemanları azalır
                        if(guessing.charAt(k) == '-' && !line4.toString().contains(Character.toString(line2[0].charAt(k)))
                        || guessing.charAt(k) == line2[0].charAt(k))
                            continue;
                        break;
                    }
                    if(k == str.length())
                        line3.add(line2[0]);
                }
            }
            //System.out.println("Aynı uzunluktaki kelimeler dizisi => " + line3);
            //System.out.println("Daha önce girilen harf stringi => " + line4);
            file.close();



            Node root = null;
            for(k = 0; k < line3.size(); k++){

                for(m = 0; m < line3.get(k).length(); m++){

                    // böylelikle bildiği indislerdeki harfleri almıyor
                    if(guessing.charAt(m) == '-' && line3.get(k).charAt(m) != '-' /*herhangi bir kelimede tire '-' karakteri varsa*/)
                        if(root == null)
                            root = new Node(line3.get(k).charAt(m));
                        else
                            root = root.add(root, line3.get(k).charAt(m));
                }
            }



            if(root != null){

                char ch = root.ch;/* what am I doing. How can the computer choose a specific word. */

                System.out.print("Harf tahmin ediyorum: ");
                System.out.println(ch);

                // add all characters that it choose already
                line4.append(ch);

                // bildikçe indislerin açılması
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
                Thread.sleep(2000);

                if(str.equals(guessing))
                    return "Oyunu kazandınız.";

            }

        }while (j>=0);

        return "Oyunu kaybettiniz.";
    }
}
