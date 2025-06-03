package pl.pp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userDirectory = System.getProperty("user.dir");
        System.out.println("Bieżący katalog to:");
        System.out.println(userDirectory);

        Path inputFilePath;
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputPath = scanner.nextLine();
            inputFilePath = Paths.get(inputPath);
            if (Files.exists(inputFilePath) && Files.isRegularFile(inputFilePath)) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Podaj poprawną ścieżkę.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputPath = scanner.nextLine();
        Path outputFilePath = Paths.get(outputPath);

        if (Files.exists(outputFilePath)) {
            System.out.print("Plik wyjściowy już istnieje. Czy chcesz go nadpisać? (t/n): ");
            String decyzja = scanner.nextLine();
            if (!decyzja.equalsIgnoreCase("t")) {
                System.out.println("Zapis anulowany.");
                scanner.close();
                return;
            }
        }

        try {
            List<String> lines = Files.readAllLines(inputFilePath, StandardCharsets.UTF_8);
            int lineCount = lines.size();

            System.out.println("Liczba linii w pliku: " + lineCount);

            String output = "Plik: " + inputFilePath.getFileName() + "\nLiczba linii: " + lineCount;
            Files.write(outputFilePath, output.getBytes(StandardCharsets.UTF_8));

            System.out.println("Wynik zapisany do pliku: " + outputFilePath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas pracy z plikami: " + e.getMessage());
        }

        scanner.close();
    }
}





