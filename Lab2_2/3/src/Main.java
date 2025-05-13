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
        int state = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            switch (state) {
                case 0:
                    if (c == '<') state = 1;
                    else return false;
                    break;

                case 1:
                    if (c == '+' || c == '-') state = 2;
                    else if (c >= 'P' && c <= 'Z') state = 4;
                    else return false;
                    break;

                case 2:
                    if (c >= '0' && c <= '5') state = 3;
                    else return false;
                    break;

                case 3:
                    if (c >= '0' && c <= '5') {
                    } else if (c == '>') {
                        state = 6;
                    } else return false;
                    break;

                case 4:
                    if (c >= 'P' && c <= 'Z') {
                    } else if (c == '>') {
                        state = 6;
                    } else return false;
                    break;

                default:
                    return false;
            }
        }

        return state == 6;
    }
}
