class Stack {
    private double[] _stackArray;
    private int _sizeArray;
    private int _capacity;

    public Stack(int capacity) {
        _capacity = capacity;
        _stackArray = new double[capacity];
        _sizeArray = 0;
    }

    public boolean isFull() {
        return _sizeArray == _capacity;
    }

    public boolean isEmpty() {
        return _sizeArray == 0;
    }

    private void expandCapacity() {
        _capacity += 10;
        double[] newStack = new double[_capacity];
        System.arraycopy(_stackArray, 0, newStack, 0, _sizeArray);
        _stackArray = newStack;
        System.out.println("Розмір стека збільшено до " + _capacity);
    }

    public void Push(double element) {
        if (isFull()) {
            expandCapacity();
        }
        _stackArray[_sizeArray++] = element;
    }

    public double Pop() {
        if (isEmpty()) {
            System.out.println("Стек порожній!");
            throw new IllegalStateException("Неможливо видалити елемент зі стека, оскільки він порожній.");
        }
        return _stackArray[--_sizeArray];
    }

    public double Peek() {
        if (isEmpty()) {
            System.out.println("Стек порожній!");
            throw new IllegalStateException("Неможливо подивитись на елемент, оскільки стек порожній.");
        }
        return _stackArray[_sizeArray - 1];
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Стек порожній!");
        } else {
            System.out.print("Елементи стека: ");
            for (int i = 0; i < _sizeArray; i++) {
                System.out.print(_stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
