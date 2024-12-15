class PriorityQueue {
    private class Node {
        int data, priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node front;

    public PriorityQueue() {
        front = null;
    }

    // Enqueue an element with a given priority
    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);
        if (front == null || front.priority > priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println(data + " with priority " + priority + " enqueued to priority queue");
    }

    // Dequeue the highest priority element
    public int dequeue() {
        if (front == null) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        int dequeued = front.data;
        front = front.next;
        return dequeued;
    }

    // Peek the front element
    public int peek() {
        if (front == null) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
    	PriorityQueue pq = new PriorityQueue();
        pq.enqueue(10, 2);
        pq.enqueue(20, 1);
        pq.enqueue(30, 3);
        System.out.println(pq.dequeue() + " dequeued from priority queue");
        System.out.println("Front element is " + pq.peek());
    }
}