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
    // Recursive method to reverse the linked list
    private Node reverseRecursive(Node current) { // T:o(n) s:o(n)
        // Base case:
        // If the current node is null (empty list) or the last node (reversal completed),
        // simply return the current node as the new head of the reversed list.
        if (current == null || current.next == null) {
            // make last node as new head here
            return current; // Return the last node as the new head of the reversed list
        }

        // Recursive step:
        // Reverse the rest of the linked list starting from the next node.
        Node newHead = reverseRecursive(current.next); // Recurse to find the new head

        // Adjust pointers to reverse the current node's link:
        // - 'current.next' points to the next node in the original list.
        // - 'current.next.next' is now set to point back to 'current', reversing the link.
        current.next.next = current; // Make the next node point back to the current node

        // Break the forward link of the current node to avoid cycles in the reversed list:
        // This ensures that the current node no longer points to the next node.
        current.next = null; // Disconnect the original forward link

        // Return the new head of the reversed list:
        // The recursive calls eventually propagate the new head back to the caller.
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
