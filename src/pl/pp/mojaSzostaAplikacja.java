package pl.pp;
import java.util.Scanner;
public class mojaSzostaAplikacja {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj liczbę N:");
        int n = input.nextInt();

        long startIter = System.nanoTime();
        long wynikIter = silniaIteracyjna(n);
        long koniecIter = System.nanoTime();
        long czasIter = koniecIter - startIter;

        long startRek = System.nanoTime();
        long wynikRek = silniaRekurencyjna(n);
        long koniecRek = System.nanoTime();
        long czasRek = koniecRek - startRek;

        System.out.println("Silnia (iteracyjnie): " + wynikIter);
        System.out.println("Czas wykonania (iteracyjnie): " + czasIter + " ns");
        System.out.println("Silnia (rekurencyjnie): " + wynikRek);
        System.out.println("Czas wykonania (rekurencyjnie): " + czasRek + " ns");

        input.close();
    }
    public static long silniaIteracyjna(int n) {
        long wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }
    public static long silniaRekurencyjna(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * silniaRekurencyjna(n - 1);
    }
}





