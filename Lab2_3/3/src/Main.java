import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] items = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int k = 3;

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[items.length];

        Arrays.sort(items);
        generatePermutations(items, used, new ArrayList<>(), result, k);

        String filename = "output.txt";
        try (BufferedWriter writer = new BufferedWriter
                (new FileWriter(filename))) {
            for (String line : result) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл \"" + filename + "\" створено. " +
                    "Всього варіантів: " + result.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generatePermutations(String[] items, boolean[] used, List<String> current, List<String> result, int k) {
        if (current.size() == k) {
            result.add(String.join("", current));
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(items[i]);
                generatePermutations(items, used, current, result, k);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
