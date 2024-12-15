public class BinarySearchTree {
    
    // Node structure for the BST
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // Constructor for creating an empty BST
    public BinarySearchTree() {
        root = null;
    }

    // Insert a node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive function to insert a node
    private Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Delete a node from the BST
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Recursive function to delete a node
    private Node deleteRec(Node root, int data) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node to be deleted is found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find the smallest node in the BST (in the right subtree of the node to delete)
    public int minValue(Node root) {
        Node current = root;
        
        // loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Find the smallest node in the BST
    public int smallestNode() {
        return smallestNodeRec(root);
    }

    private int smallestNodeRec(Node root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return -1; // If tree is empty
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Find the largest node in the BST
    public int largestNode() {
        return largestNodeRec(root);
    }

    private int largestNodeRec(Node root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return -1; // If tree is empty
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Count the total number of nodes in the BST
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        } else {
            return countNodesRec(root.left) + countNodesRec(root.right) + 1;
        }
    }

    // Search for a node with a specific value
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        // Base case: root is null or data is present at the root
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        // Data is greater than root's data
        if (data > root.data) {
            return searchRec(root.right, data);
        }

        // Data is smaller than root's data
        return searchRec(root.left, data);
    }

    // Inorder Traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder Traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder Traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal: ");
        bst.inorder();  // Expected Output: 20 30 40 50 60 70 80

        System.out.println("\nPreorder Traversal: ");
        bst.preorder();  // Expected Output: 50 30 20 40 70 60 80

        System.out.println("\nPostorder Traversal: ");
        bst.postorder();  // Expected Output: 20 40 30 60 80 70 50

        // Smallest and largest nodes
        System.out.println("\nSmallest Node: " + bst.smallestNode());  // Expected Output: 20
        System.out.println("Largest Node: " + bst.largestNode());  // Expected Output: 80

        // Count nodes in the tree
        System.out.println("Total Number of Nodes: " + bst.countNodes());  // Expected Output: 7

        // Search for a node
        System.out.println("Search for 40: " + bst.search(40));  // Expected Output: true
        System.out.println("Search for 25: " + bst.search(25));  // Expected Output: false

        // Delete node
        bst.delete(20);
        System.out.println("\nInorder Traversal after deleting 20: ");
        bst.inorder();  // Expected Output: 30 40 50 60 70 80
    }
}
