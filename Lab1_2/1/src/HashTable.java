class HashTable {
    private final Segment[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        table = new Segment[size];
    }

    private int hash(double length) {
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) (size * ((length * A) % 1));
    }

    public boolean insert(Segment segment) {
        double length = segment.length();
        int index = hash(length);

        if (table[index] != null) {
            return false;
        }

        table[index] = segment;
        return true;
    }

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