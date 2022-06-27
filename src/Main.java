import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int select, size;

        Computer computer = new Computer();
        People people = new People();

        System.out.println("1) Bilgisayar");
        System.out.println("2) İnsan");
        System.out.println("-1) Çıkış");
        do {

            System.out.print("İlk oyuncuyu belirleyiniz: ");

            select = scanner.nextInt();

            switch (select)
            {

                case 1: // Computer

                    size = computer.wordLength();
                    System.out.println(size);
                    people.setWord(people.function(size));

                    select = -1;
                    break;
                case 2: // People

                    size = people.wordLength();
                    computer.setWord(computer.function(size));

                    select = -1;
                    break;
            }

        }while(select != -1);

    }
}