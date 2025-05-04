package pl.pp;
import java.util.Scanner;
public class mojaOsmaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imię i nazwisko właściciela konta: ");
        String wlasciciel = scanner.nextLine();

        System.out.print("Podaj numer konta: ");
        String numerKonta = scanner.nextLine();

        System.out.print("Podaj początkowe saldo konta: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Podaj numer telefonu: ");
        String telefon = scanner.nextLine();


        System.out.print("Podaj adres email: ");
        String email = scanner.nextLine();


        Konto konto = new Konto(numerKonta, saldo, wlasciciel, telefon, email );

        while (true) {
            System.out.println("\n____MENU____");
            System.out.println("1. Wpłata");
            System.out.println("2. Wypłata");
            System.out.println("3. Pokaż dane konta");
            System.out.println("4. Zakończ");
            System.out.print("Wybierz opcję: ");

            int wybor = scanner.nextInt();

            if (wybor == 1) {
                System.out.print("Ile chcesz wpłacić? ");
                double wplata = scanner.nextDouble();
                konto.wplata(wplata);
            }
            else if (wybor == 2) {
                System.out.print("Ile chcesz wypłacić? ");
                double wyplata = scanner.nextDouble();
                konto.wyplata(wyplata);
            }
            else if (wybor == 3) {
                System.out.println("____Informacje o koncie____");
                System.out.println("Właściciel: " + konto.getWlasciciel());
                System.out.println("Numer konta: " + konto.getNumerKonta());
                System.out.println("Saldo: " + konto.getSaldo() + " PLN");
                System.out.println("Telefon: " + konto.getTelefon());
                System.out.println("Email: " + konto.getEmail());

            }
            else if (wybor == 4) {
                System.out.println("Koniec programu.");
                break;
            }
            else {
                System.out.println("Nie ma takiej opcji. Spróbuj ponownie.");
            }
        }
    }
}






