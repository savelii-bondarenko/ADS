import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("/Users/saveliibondarenko/Documents/ADS/Lab2_2/3/src/input.txt")));
            String[] words = content.split("[()]+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    boolean valid = checkWord(word);
                    System.out.println(word + " → " + (valid ? "правильне" : "неправильне"));
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public static boolean checkWord(String word) {
        Automaton automaton = new Automaton();
        return automaton.checkWord(word);
    }
}
