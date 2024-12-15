import java.util.Scanner;

public class CircularDoublyLinkedList {

    Node head; // head of list

    // Linked list Node.
    static class Node {
        int data;
        Node next;
        Node prev;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    // Method to insert a new node in the circular doubly linked list
    public static CircularDoublyLinkedList insert(CircularDoublyLinkedList list, int data) {
        // Create a new node with the given data
        Node new_node = new Node(data);

        // If the list is empty, create a circular doubly linked list
        if (list.head == null) {
            list.head = new_node;
            new_node.next = list.head; // Point to itself (circular reference)
            new_node.prev = list.head; // Point to itself (circular reference)
        } else {
            // Traverse till the last node
            Node last = list.head;
            while (last.next != list.head) { // Loop until we reach the head
                last = last.next;
            }

            // Insert the new node at the end and adjust pointers for circular doubly linked list
            last.next = new_node;  // last node's next points to new node
            new_node.prev = last;  // new node's prev points to the last node
            new_node.next = list.head; // new node's next points to head to maintain circularity
            list.head.prev = new_node; // head's prev points to the new node to maintain circularity
        }

        // Return the list by head
        return list;
    }

    // Method to print the Circular Doubly Linked List
    public static void printList(CircularDoublyLinkedList list) {
        Node currNode = list.head;

        // If the list is empty, print nothing
        if (currNode == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Circular Doubly Linked List: ");

        // Traverse through the Circular Doubly Linked List
        do {
            // Print the data at the current node
            System.out.print(currNode.data + " ");

            // Go to the next node
            currNode = currNode.next;
        } while (currNode != list.head); // Stop when we return to the head

        System.out.println(); // Move to the next line after printing the list
    }

    // Driver code
    public static void main(String[] args) {
        // Create a new circular doubly linked list
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many values they want to enter
        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Loop to take 'n' inputs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();

            // Insert the value into the circular doubly linked list
            list = insert(list, value);
        }

        // Print the circular doubly linked list
        printList(list);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}