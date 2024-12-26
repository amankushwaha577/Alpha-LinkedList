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

    // Method to sort the linked list containing 0's, 1's, and 2's using the counter method
    public void sortList() {
        // If the list is empty or contains only one node, there's no need to sort it
        if (head == null || head.next == null) return;

        // Step 1: Count the occurrences of 0's, 1's, and 2's in the linked list
        int count0 = 0, count1 = 0, count2 = 0;
        Node current = head;

        // Traverse through the linked list to count the number of 0's, 1's, and 2's
        while (current != null) {
            // If the current node's data is 0, increment the count for 0
            if (current.data == 0) {
                count0++;
            }
            // If the current node's data is 1, increment the count for 1
            else if (current.data == 1) {
                count1++;
            }
            // If the current node's data is 2, increment the count for 2
            else if (current.data == 2) {
                count2++;
            }
            current = current.next; // Move to the next node in the list
        }

        // Step 2: Refill the list with the counted occurrences of 0's, 1's, and 2's
        current = head; // Start at the head of the list again

        // Traverse through the list and update the node values based on the counts
        while (current != null) {
            // If there are still 0's to place, set the current node's data to 0
            if (count0 > 0) {
                current.data = 0;
                count0--; // Decrement the count of 0's
            }
            // If there are still 1's to place, set the current node's data to 1
            else if (count1 > 0) {
                current.data = 1;
                count1--; // Decrement the count of 1's
            }
            // If there are still 2's to place, set the current node's data to 2
            else if (count2 > 0) {
                current.data = 2;
                count2--; // Decrement the count of 2's
            }
            current = current.next; // Move to the next node in the list
        }
    }
}

// Main class to test the Custom Linked List class and its methods
public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();

        // Adding sample nodes (0's, 1's, and 2's) to the linked list
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Sort the linked list using the sortList method
        list.sortList();

        // Print the sorted list
        System.out.println("Sorted List:");
        list.printList();
    }
}
