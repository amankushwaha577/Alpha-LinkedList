// Class representing a Custom Linked List
class CustomLL6 {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        // Constructor to initialize a node with the given data
        public Node(int data1) {
            this.data = data1;  // Set the data for the node
            this.next = null;   // Initialize next as null
        }
    }

    // Method to add a node with the given data at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end of the list
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); // If the list is empty, print a message
            return;
        }
        Node currNode = head;
        while (currNode != null) { // Traverse and print each node in the list
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // End of the list
    }

    // Helper method to reverse the linked list using recursion
    public void reverseLinkedListUsingRecursion() {
        head = reverseRecursive(head); // Start the recursion with the head of the list
    }

    // Recursive method to reverse the linked list
    private Node reverseRecursive(Node current) {
        // Base case: If the list is empty or we've reached the last node, return it
        if (current == null || current.next == null) {
            return current;
        }

        // Recursively reverse the rest of the list
        Node newHead = reverseRecursive(current.next);

        // Reverse the current node's pointer
        current.next.next = current;
        current.next = null;

        // Return the new head of the reversed list
        return newHead;
    }
}

// Main class to test the Custom Linked List class and its methods
public class Optimal2_Recursion {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL6 list = new CustomLL6();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse the linked list using recursion
        list.reverseLinkedListUsingRecursion();

        // Print the reversed list
        System.out.println("Reversed List:");
        list.printList();
    }
}
