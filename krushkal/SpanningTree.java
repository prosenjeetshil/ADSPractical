import java.util.*;

//Class to represent an edge
class Edge implements Comparable<Edge> {
 int src, dest, weight;

 public Edge(int src, int dest, int weight) {
     this.src = src;
     this.dest = dest;
     this.weight = weight;
 }

 // Comparing edges based on their weights (for sorting edges in increasing order)
 @Override
 public int compareTo(Edge other) {
     return Integer.compare(this.weight, other.weight);
 }
}

//Class to represent a Disjoint Set (Union-Find) structure
class DisjointSet {
 int[] parent, rank;
 int n;

 // Constructor to initialize the disjoint set
 public DisjointSet(int n) {
     this.n = n;
     parent = new int[n];
     rank = new int[n];
     for (int i = 0; i < n; i++) {
         parent[i] = i;  // Each node is its own parent initially
         rank[i] = 0;    // Initially, all ranks are 0
     }
 }

 // Find the representative (or root) of a set containing 'x'
 public int find(int x) {
     if (parent[x] != x) {
         parent[x] = find(parent[x]);  // Path compression
     }
     return parent[x];
 }

 // Union of two subsets
 public void union(int x, int y) {
     int rootX = find(x);
     int rootY = find(y);

     if (rootX != rootY) {
         // Union by rank: attach smaller tree under the larger tree
         if (rank[rootX] < rank[rootY]) {
             parent[rootX] = rootY;
         } else if (rank[rootX] > rank[rootY]) {
             parent[rootY] = rootX;
         } else {
             parent[rootY] = rootX;
             rank[rootX]++;
         }
     }
 }
}

public class SpanningTree {
 private int V, E; // Number of vertices and edges
 private ArrayList<Edge> edges;

 // Constructor to initialize the graph
 public SpanningTree(int V, int E) {
     this.V = V;
     this.E = E;
     edges = new ArrayList<>();
 }

 // Add an edge to the graph
 public void addEdge(int src, int dest, int weight) {
     edges.add(new Edge(src, dest, weight));
 }

 // Function to perform Kruskal's Algorithm and find the MST
 public void kruskalMST() {
     // Step 1: Sort edges based on their weights
     Collections.sort(edges);

     // Step 2: Create a disjoint set to keep track of connected components
     DisjointSet ds = new DisjointSet(V);

     // Step 3: Iterate through the sorted edges and add them to the MST
     ArrayList<Edge> mstEdges = new ArrayList<>();
     int mstWeight = 0;

     for (Edge edge : edges) {
         int srcRoot = ds.find(edge.src);
         int destRoot = ds.find(edge.dest);

         // If adding this edge does not form a cycle, include it in the MST
         if (srcRoot != destRoot) {
             ds.union(srcRoot, destRoot);
             mstEdges.add(edge);
             mstWeight += edge.weight;
         }
     }

     // Display the MST
     System.out.println("Edges in the Minimum Spanning Tree:");
     for (Edge edge : mstEdges) {
         System.out.println("Edge: " + edge.src + " - " + edge.dest + " with weight " + edge.weight);
     }

     System.out.println("Total weight of MST: " + mstWeight);
 }

 public static void main(String[] args) {
     // Create a graph with 6 vertices (0 to 5)
	 SpanningTree graph = new SpanningTree(6, 9);

     // Add edges to the graph (src, dest, weight)
     graph.addEdge(0, 1, 4);
     graph.addEdge(0, 2, 3);
     graph.addEdge(1, 2, 1);
     graph.addEdge(1, 3, 2);
     graph.addEdge(2, 3, 4);
     graph.addEdge(3, 4, 6);
     graph.addEdge(2, 5, 5);
     graph.addEdge(4, 5, 7);
     graph.addEdge(3, 5, 8);

     // Find the Minimum Spanning Tree using Kruskal's algorithm
     graph.kruskalMST();
 }
}
