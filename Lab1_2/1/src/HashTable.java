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

    // Метод вставки елемента
    public boolean insert(Segment segment) {
        double length = segment.length();
        int index = hash(length);

        // Якщо місце вже зайняте
        if (table[index] != null) {
            return false; // Не вдається вставити, місце вже зайняте
        }

        table[index] = segment; // Вставка елемента
        return true;
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