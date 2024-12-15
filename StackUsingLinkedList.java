import java.util.Scanner;

// Node class to represent each element in the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using a linked list
public class StackUsingLinkedList {
    private Node top;

    public StackUsingLinkedList() {
        this.top = null;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to push an element into the stack
    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushed " + value + " into the stack.");
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return top.data;
        }
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackUsingLinkedList stack = new StackUsingLinkedList();

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
