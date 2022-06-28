import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int select, size;
        String str;

        Computer computer = new Computer();
        People people = new People();

        System.out.println("1) Bilgisayar");
        System.out.println("2) İnsan");

        System.out.print("İlk oyuncuyu belirleyiniz: ");
        select = scanner.nextInt();

        switch (select) {
            case 1 -> { // Computer

                size = computer.wordLength();
                System.out.println(size);
                str = people.readFile(size);
                computer.setWord(str);
                System.out.println(computer.findWord(computer.getWord()));


            }
            case 2 -> { // People

                size = people.wordLength();
                str = computer.readFile(size);
                people.setWord(str);
                System.out.println(str);
                System.out.println(people.findWord(people.getWord()));


            }
            default -> throw new IllegalStateException("Yanlış seçim yaptınız.");
        }

    }
}
