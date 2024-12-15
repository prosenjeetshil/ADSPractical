import java.util.Scanner;

public class Stack {
    private int[] stack;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stack = new int[size];
        top = -1;  // Stack is empty initially
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to push an element into the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push.");
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value + " into the stack.");
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        } else {
            int value = stack[top--];
            return value;
        }
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking stack size as input
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        Stack stack = new Stack(size);

        // Taking input for operations
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Push
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case 2: // Pop
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped value: " + popped);
                    }
                    break;

                case 3: // Peek
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top value: " + topValue);
                    }
                    break;

                case 4: // Display
                    stack.display();
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
