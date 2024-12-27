// Custom Linked List class to represent a singly linked list with various operations
 class CustomL {
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

    // Method to delete the Nth node from the end of the linked list
    public void deleteNthNodeFromEnd(int N) {
        // Edge case: if the list is empty or N is non-positive
        if (head == null || N <= 0) {
            return;
        }

        // Create two pointers, fast and slow
        Node fast = head;
        Node slow = head;

        // Move the fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (fast == null) {
                return; // If N is greater than the length of the list, return without deletion
            }
            fast = fast.next;
        }

        // If fast is null, it means N is exactly the length of the list,
        // so we need to delete the head node
        if (fast == null) {
            head = head.next; // Make head point to the next node
            return;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the Nth node from the end
        slow.next = slow.next.next;
    }
}

// Main class to test the Custom Linked List class and its methods
public class Optimal {
    public static void main(String[] args) {
        // Create the linked list
        CustomL list = new CustomL();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Delete the 2nd node from the end of the list
        list.deleteNthNodeFromEnd(2);

        // Print the updated list after deletion
        System.out.println("Updated List after deleting 2nd node from the end:");
        list.printList();
    }
}
