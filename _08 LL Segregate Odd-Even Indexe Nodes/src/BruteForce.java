import java.util.ArrayList;
import java.util.List;

class CustomLinkedList {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    // Method to segregate odd and even indexed nodes using arrays
    public void segregateOddEvenIndices() { // T : o(2N) S: o(n)
        if (head == null || head.next == null) {
            return; // No segregation needed for empty or single-node list
        }

        // Step 1: Store data of odd and even indexed nodes in separate arrays
        List<Integer> oddIndexData = new ArrayList<>();
        List<Integer> evenIndexData = new ArrayList<>();
        Node current = head;

        int index = 0; // Start index from 0 (0-based indexing)
        while (current != null) {
            if (index % 2 == 0) { // Even index (0, 2, 4,...) corresponds to even-indexed positions
                evenIndexData.add(current.data); // Add to even-indexed list
            } else { // Odd index (1, 3, 5,...) corresponds to odd-indexed positions
                oddIndexData.add(current.data); // Add to odd-indexed list
            }
            current = current.next; // Move to the next node
            index++;
        }

        // Step 2: Reconstruct the linked list with segregated order
        current = head; // Start from the head
        for (int data : oddIndexData) {
            current.data = data; // Replace with odd-indexed data
            current = current.next;
        }
        for (int data : evenIndexData) {
            current.data = data; // Replace with even-indexed data
            current = current.next;
        }
    }

    // Method to add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}

public class BruteForce {
    public static void main(String[] args) {
        // Create a linked list
        CustomLinkedList list = new CustomLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(50);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Segregate odd and even indexed nodes
        list.segregateOddEvenIndices();

        // Print the modified list
        System.out.println("After Segregating Odd and Even Indexed Nodes: ( indexes only )");
        list.printList();
    }
}
