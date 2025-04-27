import java.util.Scanner;

public class Tablica {
    public static void main(String[ ] args) {
        int[] tab1 = new int[6];
        int[] tab2 = new int[6];
        wczytaj(tab1);
        wczytaj(tab2);

        wypisz(tab1);
        wypisz(tab2);

        zawiera(tab1, tab2);
    }
    public static void wczytaj(int[] t) {
        Scanner input = new Scanner(System.in);
        for (int i=0; i<t.length; i++) {
            System.out.print("Podaj " + (i + 1) + "-ty element tablicy z przedziału 1-49: ");
            t[i] = input.nextInt();
            while (t[i]<1 || t[i]>49) {
                System.out.print("Liczba musi być z przedziału 1-49. Podaj ponownie: ");
                t[i] = input.nextInt();
            }
        }
    }


    public static void wypisz(int[] t){
        for(int i=0; i<t.length-1; i++){
            System.out.print(t[i]+" ");
        }
        System.out.println(t[t.length-1]);
    }

    public static void zawiera(int[] t1, int[] t2) {
        int ans=0;
        for (int i=0; i<t1.length; i++) {
            for (int j=0; j<t2.length; j++) {
                if (t1[i] == t2[j]) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println("Liczba wspólnych liczb: " + ans);
    }
}



