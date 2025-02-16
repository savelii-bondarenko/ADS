import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запит на розмір хеш-таблиці
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();

        // Запит на кількість елементів
        System.out.print("Enter the number of elements you want to add: ");
        int numsOfElements = scanner.nextInt();

        // Перевірка, щоб кількість елементів не перевищувала розмір хеш-таблиці
        if (numsOfElements > size) {
            System.out.println("Warning: The number of elements exceeds the hash table size. Some elements may not be inserted.");
        }

        // Створення хеш-таблиці з розміром, введеним користувачем
        HashTable hashTable = new HashTable(size);
        Random random = new Random();

        // Вставка випадкових елементів
        for (int i = 0; i < numsOfElements; i++) {
            // Генерація випадкових координат для відрізка
            double x1 = random.nextDouble() * 10;
            double y1 = random.nextDouble() * 10;
            double x2 = random.nextDouble() * 10;
            double y2 = random.nextDouble() * 10;

            // Створення нового відрізка
            Segment segment = new Segment(x1, y1, x2, y2);

            // Вставка відрізка в хеш-таблицю
            boolean inserted = hashTable.insert(segment);

            if (inserted) {
                System.out.println("Inserted: " + segment);
            } else {
                System.out.println("Failed to insert: " + segment);
            }
        }

        // Виведення вмісту хеш-таблиці
        System.out.println("\nHashTable Content:");
        hashTable.display();
    }
}
