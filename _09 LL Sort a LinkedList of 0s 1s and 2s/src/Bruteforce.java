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
        if (head == null || head.next == null) return; // Empty or single-node list, no need to sort

        // Step 1: Count the occurrences of 0's, 1's, and 2's
        int count0 = 0, count1 = 0, count2 = 0;
        Node current = head;
        while (current != null) {
            if (current.data == 0) count0++;
            else if (current.data == 1) count1++;
            else if (current.data == 2) count2++;
            current = current.next;
        }

        // Step 2: Update the list based on the counts in a single loop
        current = head;
        while (current != null) {
            if (count0 > 0) {
                current.data = 0;
                count0--;
            } else if (count1 > 0) {
                current.data = 1;
                count1--;
            } else if (count2 > 0) {
                current.data = 2;
                count2--;
            }
            current = current.next;
        }
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);

        System.out.println("Original List:");
        list.printList();

        // Sort the linked list
        list.sortList();

        // Print the sorted list
        System.out.println("Sorted List:");
        list.printList();
    }
}
