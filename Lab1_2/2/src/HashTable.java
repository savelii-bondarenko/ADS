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

        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i].equals(segment)) {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null) {
                table[newIndex] = segment;
                return true;
            }
        }
        return false;
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

    private int hash(double length) {
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) (size * ((length * A) % 1));
    }

    private void resize() {
        if ((double) count / size >= 0.8) {
            int newSize = size * 2;
            Segment[] newTable = new Segment[newSize];

            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    double length = table[i].length();
                    int newIndex = (int) (newSize * ((length * (Math.sqrt(5) - 1) / 2) % 1));
                    while (newTable[newIndex] != null) {
                        newIndex = (newIndex + 1) % newSize;
                    }
                    newTable[newIndex] = table[i];
                }
            }
            table = newTable;
            size = newSize;
        }
    }

    public boolean insert(Segment segment) {
        resize();

        double length = segment.length();
        int index = hash(length);

        int i = 0;
        while (table[index] != null) {
            index = (index + (i * i)) % size;
            i++;
        }

        table[index] = segment;
        count++;
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

 */