package pl.pp;

/*public class mojaPiątaAplikacja {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.print("Enter lower and upper integer limit: ");
        int dolny = sc.nextInt();
        int gorny = sc.nextInt();
        int x = dolny, sum1 = dolny * dolny;
        while (dolny != gorny) {
            dolny += 1;
            sum1 += (dolny * dolny);
        }
        System.out.println("The sums of the squares from");
        System.out.println(x * x + " to " + gorny * gorny + " is " + sum1);
        break;
    }
    while(true){
System.out.println("Enter next set of limits: ");
    int dolny1 = sc.nextInt();
    int gorny1 = sc.nextInt();
    int sum2 = dolny1 * dolny1, y = dolny1;
    if (dolny1 == gorny1) {
        System.out.println("Done");
        break;
    }
    else {
        while (dolny1 != gorny1) {
        dolny1 += 1;
        sum2 += (dolny1 * dolny1);
        }
        System.out.println("The sums of the squares from");
        System.out.println( y * y + " to " + gorny1 * gorny1 + " is " + sum2);

    }
    sc.close();
    }*/

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prosze wybracz operacje ( lub -1, aby zalonczyć " + "\n" );
        while ( true) {
            System.out.println("dodawanie - 1" + "\n");
            System.out.println("odejmowanie - 2" + "\n");
            System.out.println("mnożemie - 3" + "\n");
            System.out.println("dzielenie - 4" + "\n");
            int a = sc.nextInt();
            if (a != 1 && a != 2 && a != 3 && a != 4) {
                break;
            }

            System.out.println(" Prosze podać dzwie liczby (lub -1, aby zakonczyć)");
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            if (a == 1) {
                System.out.println(l1 + l2);}
                else if (a == 2) {
                    System.out.println((l1 - l2) + " lub " + (l2 - l1));
                } else if (a == 3) {
                    System.out.println((l1 * l2));
                } if (a == 4) {
                    System.out.println((l1 / l2) + " lub " + (l2 / l1));
                }
                System.out.println("Prosze podać dwie liczby" + "\n");
            }
        }*/


public class mojaPiataAplikacja {
    public static void main(String[] args) {
        printCharacterGrid('*', 6, 4);
    }

    private static void printCharacterGrid(char symbol, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();  // Перехід на новий рядок
        }
    }}



