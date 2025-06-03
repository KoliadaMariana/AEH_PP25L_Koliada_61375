package pl.pp;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class mojaTrzynastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path inputPath;

        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            inputPath = Paths.get(scanner.nextLine());
            if (Files.exists(inputPath) && Files.isRegularFile(inputPath)) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Spróbuj ponownie.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        Path outputPath = Paths.get(scanner.nextLine());
        Map<String, Integer> wordCounts = new HashMap<>();
        int totalWords = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]", " ")
                        .toLowerCase().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
            return;
        }

        System.out.println("Liczba słów: " + totalWords);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write("Nazwa pliku wejściowego: " + inputPath.getFileName());
            writer.newLine();
            writer.write("Liczba słów: " + totalWords);
            writer.newLine();
            writer.write("Statystyka słów:");
            writer.newLine();
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
        }
    }
}




