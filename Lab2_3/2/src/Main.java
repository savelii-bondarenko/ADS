public class Main {
    public static void main(String[] args) {
        int totalDigits = 9;

        int count1 = 2; // для цифри 1
        int count2 = 3; // для цифри 2
        int count3 = 4; // для цифри 3

        long result = factorial(totalDigits) /
                (factorial(count1) * factorial(count2) *
                        factorial(count3));

        System.out.println("Кількість дев’ятизначних чисел: " + result);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
