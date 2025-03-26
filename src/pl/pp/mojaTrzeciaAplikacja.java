package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj liczbę dni: ");
            int dni = scanner.nextInt();
            if (dni <= 0) {
                System.out.println("Liczba nie jest większa od 0, program przechodzi do drugiej części.");
                break;
            }
            int x = dni / 7;
            int y = dni % 7;

            System.out.println(dni + " dni to " + x + " tygodnie i " + y + " dni");

        }
        while (true) {

            System.out.print("Podaj temperaturę w stopniach Fahrenheit'a (lub -1, aby zakończyć): ");
            double fahren = scanner.nextDouble();

            if (fahren == -1) {
                System.out.println("Wyjście");
                break;
            }
            double celsj = (fahren - 32.0) / 1.8;
            double kelvin = celsj + 273.16;

            System.out.printf("Temperatura w Fahrenheit'cie: " + fahren + "\n");
            System.out.printf("Temperatura w Celsjuszu: " + celsj + "\n");
            System.out.printf("Temperatura w Kelvinie: " + kelvin + "\n");


        }

        scanner.close();
    }
}