import java.util.Arrays;
import java.util.Random;

public class ShellSortOrderComparison {
    static final double TO_MILLIS = 1_000_000;

    public static void shellSortClassic(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            Sort(array, n, gap);
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

    public static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }


    public static long measureAverageTime(int[] originalArray, int repeats, boolean useKnuth) {
        long totalTime = 0;
        for (int i = 0; i < repeats; i++) {
            int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            long start;
            long end;
            if (useKnuth) {
                start = System.nanoTime();
                shellSortKnuth(arrayToSort);
                end = System.nanoTime();
            } else {
                start = System.nanoTime();
                shellSortClassic(arrayToSort);
                end = System.nanoTime();
            }

            totalTime += (end - start);
        }
        return totalTime / repeats;
    }

    public static void main(String[] args) {
        final int N = 1_000_000;
        final int REPEATS = 5;
        Random random = new Random(1);

        int[] bestArray = generateSortedArray(N);
        int[] worstArray = generateReverseSortedArray(N);
        int[] averageArray = generateRandomArray(N, random);

        long timeBestClassic = measureAverageTime(bestArray, REPEATS, false);
        long timeWorstClassic = measureAverageTime(worstArray, REPEATS, false);
        long timeAverageClassic = measureAverageTime(averageArray, REPEATS, false);

        long timeBestKnuth = measureAverageTime(bestArray, REPEATS, true);
        long timeWorstKnuth = measureAverageTime(worstArray, REPEATS, true);
        long timeAverageKnuth = measureAverageTime(averageArray, REPEATS, true);

        System.out.println("Порядок | Класичний (мс) | Кнут (мс)");
        System.out.printf("Найкращий | %.3f | %.3f%n", timeBestClassic / TO_MILLIS, timeBestKnuth / TO_MILLIS);
        System.out.printf("Найгірший | %.3f | %.3f%n", timeWorstClassic / TO_MILLIS, timeWorstKnuth / TO_MILLIS);
        System.out.printf("Середній  | %.3f | %.3f%n", timeAverageClassic / TO_MILLIS, timeAverageKnuth / TO_MILLIS);

    }
}
