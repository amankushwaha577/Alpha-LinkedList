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
            if (fast == null) { // if fast reaches null it means LL is over : and N is out of range
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
        while (fast.next != null) { // We stop the loop one step before fast becomes null because once fast points to the last node, the slow pointer will be at the node just before the one we want to delete.
            fast = fast.next;
            slow = slow.next;
        }
        // The reason for using while (fast.next != null) is to ensure that the fast pointer reaches the last node of the linked list while the slow pointer follows behind it
        // the goal is to find the node just before the Nth node from the end.
        // We already moved the fast pointer N steps ahead.
        // By moving both the fast and slow pointers at the same time, we ensure that when the fast pointer reaches the end of the list, the slow pointer will be pointing to the node just before the target node to be deleted.

        // If fast is N steps ahead, when fast reaches the end of the list, slow will be pointing to the node just before the Nth node from the end. This allows us to delete the Nth node from the end.

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
