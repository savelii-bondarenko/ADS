import java.util.Scanner;

public class FiniteAutomatonParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();

        boolean isValid = checkString(input);
        if (isValid) {
            System.out.println("Рядок правильний.");
        } else {
            System.out.println("Рядок неправильний.");
        }
    }

    public static boolean checkString(String input) {
        int state = 0;
        int i = 0;
        char c;

        while (i < input.length()) {
            c = input.charAt(i);

            switch (state) {
                case 0:
                    if (c == '<') {
                        state = 1;
                    } else {
                        return false;
                    }
                    break;

                case 1:
                    if (c == '+' || c == '-') {
                        state = 2;
                    } else if (c >= 'P' && c <= 'Z') {
                        state = 4;
                    } else {
                        return false;
                    }
                    break;

                case 2:
                    if (c >= '0' && c <= '5') {
                        state = 3;
                    } else {
                        return false;
                    }
                    break;

                case 3:
                    if (c >= '0' && c <= '5') {
                    } else if (c == '>') {
                        state = 6;  // Завершуємо, якщо зустріли >
                    } else {
                        return false;
                    }
                    break;

                case 4:
                    if (c >= 'P' && c <= 'Z') {
                        state = 4;
                    } else if (c == '>') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;

                case 6:
                    return false;

                default:
                    return false;
            }

            i++;
        }

        return state == 6;
    }
}
