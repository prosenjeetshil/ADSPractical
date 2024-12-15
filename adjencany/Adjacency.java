public class Adjacency {
    private int[][] adjMatrix; // Adjacency matrix
    private int vertices; // Number of vertices in the graph

    // Constructor to initialize the graph with a given number of vertices
    public Adjacency(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // Initialize the matrix with 0s
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination) {
        if (source >= vertices || destination >= vertices) {
            System.out.println("Invalid vertices!");
            return;
        }
        adjMatrix[source][destination] = 1; // Mark an edge from source to destination
        adjMatrix[destination][source] = 1; // Since it's an undirected graph, mark an edge in the reverse direction
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int source, int destination) {
        if (source >= vertices || destination >= vertices) {
            System.out.println("Invalid vertices!");
            return;
        }
        adjMatrix[source][destination] = 0; // Remove edge from source to destination
        adjMatrix[destination][source] = 0; // Remove the reverse edge for undirected graph
    }

    // Method to display the adjacency matrix
    public void displayAdjMatrix() {
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if there's an edge between two vertices
    public boolean hasEdge(int source, int destination) {
        if (source >= vertices || destination >= vertices) {
            System.out.println("Invalid vertices!");
            return false;
        }
        return adjMatrix[source][destination] == 1;
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices (0 to 4)
    	Adjacency graph = new Adjacency(5);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        // Display the adjacency matrix
        graph.displayAdjMatrix();

        // Check if an edge exists
        System.out.println("Does edge between 0 and 1 exist? " + graph.hasEdge(0, 1));
        System.out.println("Does edge between 2 and 4 exist? " + graph.hasEdge(2, 4));

        // Remove an edge
        graph.removeEdge(0, 2);
        System.out.println("Adjacency Matrix after removing edge between 0 and 2:");
        graph.displayAdjMatrix();
    }
}
