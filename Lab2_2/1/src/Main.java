import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "/Users/saveliibondarenko/Documents/ADS/Lab2_2/1/src/text";
        String regex = "^<([-+][0-5]+|[-+][P-Z]+)>$";

        System.out.println("Знайдені слова:");
        try {
            Files.lines(Paths.get(fileName))
                    .filter(line -> line.matches(regex))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Помилка при читанні з файлу: " + e.getMessage());
        }
    }
}
