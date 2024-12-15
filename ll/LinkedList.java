import java.util.Scanner;

public class LinkedList {

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

    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at the last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at the current node
            System.out.print(currNode.data + " ");

            // Go to the next node
            currNode = currNode.next;
        }

        System.out.println(); // Move to the next line after printing the list
    }

    // Driver code
    public static void main(String[] args) {
        // Create a new linked list
        LinkedList list = new LinkedList();

        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many values they want to enter
        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Loop to take 'n' inputs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();

            // Insert the value into the linked list
            list = insert(list, value);
        }

        // Print the linked list
        printList(list);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}