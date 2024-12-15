import java.util.Scanner;

public class CircularLinkedList {

    Node head; // head of list

    // Linked list Node.
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node in the circular linked list
    public static CircularLinkedList insert(CircularLinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty, create a circular list
        if (list.head == null) {
            list.head = new_node;
            new_node.next = list.head; // Point to itself (circular reference)
        } else {
            // Traverse till the last node
            Node last = list.head;
            while (last.next != list.head) { // Loop until we reach the head
                last = last.next;
            }

            // Insert the new node at the end and point it back to the head
            last.next = new_node;
            new_node.next = list.head;
        }

        // Return the list by head
        return list;
    }

    // Method to print the Circular LinkedList.
    public static void printList(CircularLinkedList list) {
        Node currNode = list.head;

        // If the list is empty, print nothing
        if (currNode == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Circular LinkedList: ");

        // Traverse through the Circular LinkedList
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
        // Create a new circular linked list
        CircularLinkedList list = new CircularLinkedList();

        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many values they want to enter
        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Loop to take 'n' inputs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();

            // Insert the value into the circular linked list
            list = insert(list, value);
        }

        // Print the circular linked list
        printList(list);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}