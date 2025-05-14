package pl.pp;
import java.util.Scanner;
public class mojaDziewiataAplikacja {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Podaj numer magazynu: ");
    int numer = scanner.nextInt();

    System.out.print("Podaj pojemność magazynu: ");
    int pojemnosc = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Podaj imię i nazwisko właściciela: ");
    String wlasciciel = scanner.nextLine();

    System.out.print("Podaj email: ");
    String email = scanner.nextLine();

    System.out.print("Podaj numer telefonu właściciela: ");
    String telefon = scanner.nextLine();

    Magazyn magazyn = new Magazyn(numer, pojemnosc, wlasciciel, email, telefon);
    int wybor;
    do {
        System.out.println("\n___MENU___");
        System.out.println("1. Dodaj towar");
        System.out.println("2. Usuń towar");
        System.out.println("3. Sprawdź zajętość");
        System.out.println("4. Zmień dane kontaktowe");
        System.out.println("5. Pokaż dane magazynu");
        System.out.println("6. Zakończ");
        System.out.print("Wybierz opcję: ");
        wybor = scanner.nextInt();
        scanner.nextLine();
        switch (wybor) {
            case 1:
                System.out.print("Podaj ilość towaru do dodania: ");
                int iloscDodania = scanner.nextInt();
                magazyn.dodajTowar(iloscDodania);
                break;
            case 2:
                System.out.print("Podaj ilość towaru do usunięcia: ");
                int iloscUsuniecia = scanner.nextInt();
                magazyn.usunTowar(iloscUsuniecia);
                break;
            case 3:
                magazyn.sprawdzZajetosc();
                break;
            case 4:
                System.out.print("Nowy email: ");
                String nowyEmail = scanner.nextLine();
                System.out.print("Nowy numer telefonu: ");
                String nowyTelefon = scanner.nextLine();
                magazyn.aktualizujKontakt(nowyEmail, nowyTelefon);
                break;
            case 5:
                System.out.println("Numer magazynu: " + magazyn.getNumerMagazynu());
                System.out.println("Pojemność magazynu: " + magazyn.getPojemnoscMagazynu());
                System.out.println("Zajęta przestrzeń: " + magazyn.getZajetaPrzestrzen());
                System.out.println("Właściciel: " + magazyn.getWlasciciel());
                System.out.println("Email: " + magazyn.getEmail());
                System.out.println("Telefon: " + magazyn.getTelefon());
                break;
            case 6:
                System.out.println("Zakończono program.");
                break;
            default:
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
        }
    } while (wybor != 6);

    scanner.close();
}}






