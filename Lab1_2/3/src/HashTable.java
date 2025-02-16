class HashTable {
    private final Segment[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        table = new Segment[size];
    }

    // Множення для обчислення хешу
    private int hash(double length) {
        double A = (Math.sqrt(5) - 1) / 2; // Константа множення
        return (int) (size * ((length * A) % 1));
    }

    // Метод вставки елемента з використанням квадратичного зонування
    public boolean insert(Segment segment) {
        double length = segment.length();
        int index = hash(length);

        // Перевірка на колізії з квадратичним зонуванням
        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null) {
                table[newIndex] = segment; // Вставка елемента
                return true;
            }
        }

        return false; // Якщо не вдалося вставити після всіх спроб
    }

    // Метод видалення елементів за критерієм кута
    public void removeByAngle(double threshold) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i].calculateAngle() > threshold) {
                System.out.println("Removing element: " + table[i]);
                table[i] = null; // Видалення елемента
            }
        }
    }

    // Метод виведення хеш-таблиці
    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.printf("Position %d: Key %.2f, Element: %s\n", i, table[i].length(), table[i]);
            } else {
                System.out.printf("Position %d: Empty\n", i);
            }
        }
    }
}

/*
class HashTable {
    private Segment[] table;
    private int size;
    private int count;

    public HashTable(int size) {
        this.size = size;
        this.table = new Segment[size];
        this.count = 0;
    }

    // Множення для обчислення хешу
    private int hash(double length) {
        double A = (Math.sqrt(5) - 1) / 2; // Константа множення
        return (int) (size * ((length * A) % 1));
    }

    // Метод для перевірки заповненості та розширення таблиці
    private void resize() {
        // Якщо кількість елементів більше 80% від розміру таблиці, збільшуємо таблицю вдвічі
        if ((double) count / size >= 0.8) {
            int newSize = size * 2;
            Segment[] newTable = new Segment[newSize];

            // Перехешовка всіх елементів у нову таблицю
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    double length = table[i].length();
                    int newIndex = hash(length);

                    // Обробка колізій для нової таблиці
                    for (int j = 0; j < newSize; j++) {
                        int newPos = (newIndex + j * j) % newSize;
                        if (newTable[newPos] == null) {
                            newTable[newPos] = table[i];
                            break;
                        }
                    }
                }
            }
            table = newTable; // Оновлюємо таблицю
            size = newSize;   // Оновлюємо розмір таблиці
            System.out.println("Table resized to new size: " + newSize);
        }
    }

    // Метод вставки елемента з використанням квадратичного зонування
    public boolean insert(Segment segment) {
        resize();  // Перевірка на заповненість перед вставкою
        double length = segment.length();
        int index = hash(length);

        // Перевірка на колізії з квадратичним зонуванням
        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null) {
                table[newIndex] = segment; // Вставка елемента
                count++;
                return true;
            }
        }

        return false; // Якщо не вдалося вставити після всіх спроб
    }

    // Метод видалення елементів за критерієм кута
    public void removeByAngle(double threshold) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i].calculateAngle() > threshold) {
                System.out.println("Removing element: " + table[i]);
                table[i] = null; // Видалення елемента
                count--;
            }
        }
    }

    // Метод виведення хеш-таблиці
    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.printf("Position %d: Key %.2f, Element: %s\n", i, table[i].length(), table[i]);
            } else {
                System.out.printf("Position %d: Empty\n", i);
            }
        }
    }
}

 */