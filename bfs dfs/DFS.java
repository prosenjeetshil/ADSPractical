import java.util.*;

public class DFS {

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

        // DFS algorithm using recursion
        public void dfs(int start) {
            // Array to keep track of visited vertices
            boolean[] visited = new boolean[vertices];

            System.out.println("Depth-First Search starting from node " + start + ":");
            dfsRecursive(start, visited);
            System.out.println(); // Move to the next line after printing DFS result
        }

        // Helper method for DFS recursion
        private void dfsRecursive(int vertex, boolean[] visited) {
            // Mark the current vertex as visited
            visited[vertex] = true;
            System.out.print(vertex + " "); // Print the current vertex

            // Recurse for all the adjacent vertices of the current vertex
            for (Integer neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    dfsRecursive(neighbor, visited);
                }
            }
        }

        // DFS using an explicit stack (iterative version)
        public void dfsIterative(int start) {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            
            stack.push(start);
            visited[start] = true;
            
            System.out.println("Iterative DFS starting from node " + start + ":");
            
            while (!stack.isEmpty()) {
                int vertex = stack.pop();
                System.out.print(vertex + " ");
                
                // Explore all unvisited adjacent vertices
                for (Integer neighbor : adjList[vertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                }
            }
            System.out.println(); // Move to the next line after printing DFS result
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

        // Perform DFS (recursive)
        graph.dfs(0);

        // Perform DFS (iterative)
        graph.dfsIterative(0);

        // You can test DFS with different starting points
        // graph.dfs(1); // Uncomment this to run DFS from vertex 1
        // graph.dfsIterative(3); // Uncomment this to run Iterative DFS from vertex 3
    }
}
