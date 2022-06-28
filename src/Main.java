import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int select, size;
        String str;

        Computer computer = new Computer();
        People people = new People();

        System.out.println("1) Bilgisayar");
        System.out.println("2) İnsan");
        System.out.println("-1) Çıkış");
        do {

            System.out.print("İlk oyuncuyu belirleyiniz: ");

            select = scanner.nextInt();

            switch (select) {
                case 1 -> { // Computer

                    size = computer.wordLength();
                    System.out.println(size);
                    str = people.readFile(size);
                    computer.setWord(str);
                    //System.out.println(computer.readFile(size));
                    computer.findWord(computer.getWord());

                    select = -1;
                }
                case 2 -> { // People

                    size = people.wordLength();
                    str = computer.readFile(size);
                    people.setWord(str);
                    System.out.println(str);
                    System.out.println(people.findWord(people.getWord()));

                    select = -1;
                }
            }

        }while(select != -1);

    }
}
