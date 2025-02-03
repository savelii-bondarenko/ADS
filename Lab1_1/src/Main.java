/*
//Мейн до 1 рівня
public class Main
{
    public static void main(String[] args) {
        final int CAPACITY = 5;

        Stack stack = new Stack(CAPACITY);  // створення стека місткістю 5 елементів

        stack.Push(10.5);
        stack.Push(20.3);
        stack.Push(30.1);
        stack.Push(40.7);
        stack.Push(50.8);

        stack.Display();

        System.out.println("Вершина стека: " + stack.Peek());

        stack.Pop();
        stack.Display();

        stack.Push(60.2);
        stack.Display();
    }
}
*/
/*
//Мейн до 2 рівня
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Додавання елементів у чергу
        queue.Enqueue(10);  // Octal 12
        queue.Enqueue(15);  // Octal 17
        queue.Enqueue(22);  // Octal 26

        // Виведення всіх елементів черги
        queue.Display();

        // Перегляд елемента на початку черги
        System.out.println("Перегляд першого елемента (peek): " + queue.Peek());

        // Видалення елементів з черги
        System.out.println("Видалений елемент: " + queue.Dequeue());
        queue.Display();

        System.out.println("Видалений елемент: " + queue.Dequeue());
        queue.Display();

        // Додавання нових елементів
        queue.Enqueue(30);  // Octal 36
        queue.Enqueue(45);  // Octal 55
        queue.Display();
    }
}
*/
/*
//Мейн до 3 рівня
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();


        final int CAPACITY = 10;
        Stack stack = new Stack(CAPACITY);  // створення стека місткістю 5 елементів

        queue.Enqueue(100);
        queue.Enqueue(300);
        queue.Enqueue(150);
        queue.Enqueue(50);
        queue.Enqueue(250);

        System.out.println("Початкова черга:");
        queue.Display();

        while (!queue.isEmpty()) {
            String octalValue = queue.Dequeue();
            int decimalValue = Integer.parseInt(octalValue, 8);

            if (decimalValue > 200) {
                decimalValue /= 2;
            } else {
                decimalValue *= 2;
            }

            stack.Push(decimalValue);
        }

        System.out.println("Стек після перетворення:");
        stack.Display();
    }
}
*/
