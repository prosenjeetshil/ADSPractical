import java.util.*;

public class BFS {
    
    // Graph representation using adjacency list
    static class Graph {
        private int vertices; // Number of vertices
        private LinkedList<Integer>[] adjList; // Adjacency list

        // Constructor to initialize graph with a given number of vertices
        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            // Initialize each adjacency list for each vertex
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        // Method to add an edge between two vertices
        public void addEdge(int source, int destination) {
            adjList[source].add(destination); // Add destination to source's adjacency list
            adjList[destination].add(source); // Since it's an undirected graph, add source to destination's adjacency list
        }

        // BFS algorithm to traverse the graph starting from a given source node
        public void bfs(int start) {
            // Array to keep track of visited vertices
            boolean[] visited = new boolean[vertices];
            
            // Queue to store the vertices to visit
            Queue<Integer> queue = new LinkedList<>();

            // Start by visiting the starting node
            visited[start] = true;
            queue.add(start);

            System.out.println("Breadth-First Search starting from node " + start + ":");

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                // Visit all the adjacent vertices of the current vertex
                for (Integer neighbor : adjList[vertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println(); // Move to the next line after printing BFS result
        }
    }

    public static void main(String[] args) {
        // Create a graph with 6 vertices (0 to 5)
        Graph graph = new Graph(6);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform BFS starting from vertex 0
        graph.bfs(0);

        // You can test BFS with different starting points
        // graph.bfs(1); // Uncomment this to run BFS from vertex 1
    }
}
