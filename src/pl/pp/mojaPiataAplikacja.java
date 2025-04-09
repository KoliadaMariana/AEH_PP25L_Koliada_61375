package pl.pp;

import java.util.Scanner;
public class mojaPiataAplikacja {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj dowolny znak: ");
        char x = input.next().charAt(0);
        System.out.println("Podaj liczbę znaków w wierszu: ");
        int y = input.nextInt();
        System.out.println("Podaj liczbę linii: ");
        int z = input.nextInt();

        tablica(x, y, z);
    }
    public static void tablica(char x, int a, int b){
        for(int i=0; i<b; i++){
            for(int j=0; j<a; j++){
                System.out.print(x);
            }
            System.out.println();
        }
    }
}




