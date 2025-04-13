import java.util.Arrays;
import java.util.Random;

public class ShellSortComparison {
    static final double TO_MILLIS = 1_000_000.0;
    public static void shellSortClassic(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            Sort(array, n, gap);
        }
    }

    private static void Sort(int[] array, int n, int gap) {
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

    public static void shellSortKnuth(int[] array) {
        int n = array.length;
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            Sort(array, n, gap);
            gap /= 3;
        }
    }

    public static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static long measureAverageTime(int[] originalArray, int repeats, boolean useKnuth) {
        long totalTime = 0;
        for (int i = 0; i < repeats; i++) {
            int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            long start = System.nanoTime();
            if (useKnuth) {
                shellSortKnuth(arrayToSort);
            } else {
                shellSortClassic(arrayToSort);
            }
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return totalTime / repeats;
    }

    public static void main(String[] args) {
        final int N = 100;
        final int[] sizes = {N, N * N, N * N * N};
        final int REPEATS = 5;
        Random random = new Random(42);

        System.out.println("Розмір | Час (мс) - Класичний | Час (мс) - Кнут");
        for (int size : sizes) {
            int[] data = generateRandomArray(size, random);
            long timeClassic = measureAverageTime(data, REPEATS, false);
            long timeKnuth = measureAverageTime(data, REPEATS, true);

            double msClassic = timeClassic / TO_MILLIS;
            double msKnuth = timeKnuth / TO_MILLIS;

            System.out.printf("%6d | %20.3f | %15.3f%n", size, msClassic, msKnuth);
        }
    }
}
