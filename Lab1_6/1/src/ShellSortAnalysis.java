import java.util.Arrays;
import java.util.Random;

public class ShellSortAnalysis {
    static final double TO_MILLES = 1_000_000.0;
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    public static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static long measureAverageTime(int[] originalArray, int repeats) {
        long totalTime = 0;
        for (int i = 0; i < repeats; i++) {
            int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            long start = System.nanoTime();
            shellSort(arrayToSort);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return totalTime / repeats;
    }

    public static void main(String[] args) {
        final int N = 100;
        final int[] sizes = {N, N * N, N * N * N};
        final int REPEATS = 5;
        Random random = new Random();

        System.out.println("Розмір масиву | Середній час виконання (мс)");
        for (int size : sizes) {
            int[] data = generateRandomArray(size, random);
            long averageTime = measureAverageTime(data, REPEATS);
            double millsec = averageTime / TO_MILLES;

            System.out.printf("%13d | %28.3f%n", size, millsec);
        }
    }

}
