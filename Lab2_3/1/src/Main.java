import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість дисциплін у семестрі (n): ");
        int n = scanner.nextInt();

        System.out.print("Введіть кількість дисциплін на день (k): ");
        int k = scanner.nextInt();

        if (k > n) {
            System.out.println("Кількість занять не може перевищувати кількість дисциплін.");
            return;
        }

        int result = factorial(n) / factorial(n - k);

        System.out.println("Кількість варіантів розкладу: " + result);
    }

    public static int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
