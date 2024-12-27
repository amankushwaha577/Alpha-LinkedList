// Custom Linked List class to represent a singly linked list with various operations
class CustomLL {
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

    /**
     * Method to delete the Nth node from the end of the linked list.
     *
     * @param N The position (from the end) of the node to be deleted.
     */
    public void deleteNthNodeFromEnd(int N) {
        // Special case: If the list is empty, there's nothing to delete
        if (head == null) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }

        // Step 1: Count the total number of nodes in the list
        int totalNodes = 0;
        Node temp = head;

        while (temp != null) { // Traverse the list to calculate its length
            totalNodes++;
            temp = temp.next;
        }

        // Step 2: Handle the case where the head node itself needs to be deleted
        if (totalNodes == N) {
            head = head.next; // Move the head pointer to the next node
            return;
        }

        // Step 3: Calculate the position of the node to be deleted from the start
        int positionFromStart = totalNodes - N;
        temp = head;

        // Traverse to the node just before the target node
        for (int i = 1; i < positionFromStart; i++) {
            temp = temp.next;
        }

        // Step 4: Update the pointers to skip the target node
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next; // Bypass the target node
        }
    }
}

// Main class to test the Custom Linked List class and its methods
public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();

        // Adding sample nodes to the linked list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Delete the 2nd node from the end
        list.deleteNthNodeFromEnd(2); // Deletes the 2nd node from the end
        System.out.println("After Deleting 2nd Node from End:");
        list.printList();
    }
}
