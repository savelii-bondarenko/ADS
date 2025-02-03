class Queue {
    private Node _front, _rear;

    public Queue() {
        _front = _rear = null;
    }

    public boolean isEmpty() {
        return _front == null;
    }

    public void Enqueue(int value) {
        String octalValue = Integer.toOctalString(value);
        Node newNode = new Node(octalValue);

        if (_rear == null) {
            _front = _rear = newNode;
        } else {
            _rear.next = newNode;
            _rear = newNode;
        }
    }

    public String Dequeue() {
        if (isEmpty()) {
            System.out.println("Черга порожня!");
            return null;
        }
        String value = _front.data;
        _front = _front.next;
        if (_front == null) {
            _rear = null;
        }
        return value;
    }

    public String Peek() {
        if (isEmpty()) {
            System.out.println("Черга порожня!");
            return null;
        }
        return _front.data;
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Черга порожня!");
        } else {
            Node current = _front;
            System.out.print("Елементи черги: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
