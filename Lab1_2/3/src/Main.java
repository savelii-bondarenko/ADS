import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();

        System.out.print("Enter the number of elements you want to add: ");
        int numsOfElements = scanner.nextInt();

        if (numsOfElements > size) {
            System.out.println("Warning: The number of elements exceeds the hash table size. Some elements may not be inserted.");
        }

        HashTable hashTable = new HashTable(size);
        Random random = new Random();

        for (int i = 0; i < numsOfElements; i++) {
            double x1 = random.nextDouble() * 10;
            double y1 = random.nextDouble() * 10;
            double x2 = random.nextDouble() * 10;
            double y2 = random.nextDouble() * 10;

            Segment segment = new Segment(x1, y1, x2, y2);

            boolean inserted = hashTable.insert(segment);

            if (inserted) {
                System.out.println("Inserted: " + segment);
            } else {
                System.out.println("Failed to insert: " + segment);
            }
        }

        System.out.println("\nHashTable Content:");
        hashTable.display();

        System.out.print("\nEnter the angle threshold for removal (in degrees): ");
        double threshold = scanner.nextDouble();

        hashTable.removeByAngle(threshold);

        System.out.println("\nHashTable Content after removal: ");
        hashTable.display();
    }
}
