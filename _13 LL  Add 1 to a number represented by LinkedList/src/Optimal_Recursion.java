class CustomLL2 {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        // Constructor to initialize a node
        public Node(int data1) {
            this.data = data1;  // Set the data
            this.next = null;   // Initialize next as null
        }
    }

    // Method to add a node with the given data at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) { // Traverse and print each node
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // End of the list
    }

    // Method to add 1 to the number represented by the linked list using backtracking
    public void addOne() {  // T:0(N) s:0(N)
        // Start recursive backtracking from the head node
        if (addOneRecursive(head) == 1) {
            // If carry is left after adding 1 to the most significant digit
            Node newNode = new Node(1);  // Create a new node with data 1
            newNode.next = head;  // Add it at the front of the list
            head = newNode;  // Set new node as the head
        }
    }

    // Recursive method to add 1 and propagate the carry back
    private int addOneRecursive(Node node) {
        // Base case: if we reach the end of the list
        if (node == null) {
            return 1;  // Return carry 1 to propagate back
        }

        // Recursively call the next node
        int carry = addOneRecursive(node.next);

        // If carry is 1, add it to the current node's data
        int sum = node.data + carry;

        // If the sum exceeds 9, set the data to 0 and propagate the carry
        if (sum >= 10) {
            node.data = 0;
            return 1;  // Propagate carry 1
        } else {
            node.data = sum;
            return 0;  // No carry, return 0
        }
    }
}

// Main class to test the CustomLL2 class and addOne method
public class Optimal_Recursion {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to represent a number (e.g., 1 -> 2 -> 3, which represents 123)
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Add 1 to the number represented by the linked list using backtracking
        list.addOne();

        // Print the updated list
        System.out.println("List after adding 1:");
        list.printList();
    }
}
