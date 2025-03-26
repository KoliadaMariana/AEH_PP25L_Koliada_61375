package pl.pp;
import java.util.Scanner;
public class mojaDrugaAplikacja1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swój wiek w latach: ");
        int wiek = scanner.nextInt();
        long x = 365 * 24 * 60 * 60;
        scanner.close();
        System.out.println("Twój wiek w sekundach to: " + wiek * x);
    }
}