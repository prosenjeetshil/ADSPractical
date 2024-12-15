class DoubleEnded {
    private class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private Node front, rear;

    public DoubleEnded() {
        front = rear = null;
    }

    // Add an element to the front of the deque
    public void addFront(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        System.out.println(data + " added to the front of deque");
    }

    // Add an element to the rear of the deque
    public void addRear(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " added to the rear of deque");
    }

    // Remove an element from the front of the deque
    public int removeFront() {
        if (front == null) {
            System.out.println("Deque is empty");
            return -1;
        }
        int removed = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        return removed;
    }

    // Remove an element from the rear of the deque
    public int removeRear() {
        if (rear == null) {
            System.out.println("Deque is empty");
            return -1;
        }
        int removed = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        return removed;
    }

    // Peek the front element of the deque
    public int peekFront() {
        if (front == null) {
            System.out.println("Deque is empty");
            return -1;
        }
        return front.data;
    }

    // Peek the rear element of the deque
    public int peekRear() {
        if (rear == null) {
            System.out.println("Deque is empty");
            return -1;
        }
        return rear.data;
    }

    public static void main(String[] args) {
    	DoubleEnded deque = new DoubleEnded();
        deque.addFront(10);
        deque.addRear(20);
        deque.addFront(5);
        System.out.println(deque.removeFront() + " removed from front of deque");
        System.out.println(deque.removeRear() + " removed from rear of deque");
        System.out.println("Front element is " + deque.peekFront());
        System.out.println("Rear element is " + deque.peekRear());
    }
}
