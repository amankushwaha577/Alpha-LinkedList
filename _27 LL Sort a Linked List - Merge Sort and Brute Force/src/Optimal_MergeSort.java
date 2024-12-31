
import java.util.ArrayList;
        import java.util.Collections;

class CustomL {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    static class Node {
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

        // Traverse to the last node in the list
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode; // Attach the new node at the end
    }

    // Function to sort a linked list using the Brute Force approach
    // T : 0(N) +  NlogN + 0(N)
    // S : 0(N)
    public void sortLL() {
        // Create a list to store node values
        ArrayList<Integer> arr = new ArrayList<>();

        // Temporary pointer to traverse the linked list
        Node temp = head;

        // Traverse the linked list and store node values in the list
        while (temp != null) { // 0(N)
            arr.add(temp.data);
            temp = temp.next;
        }

        // Sort the list containing node values
        Collections.sort(arr); // NlogN

        // Reassign sorted values to the linked list nodes
        temp = head;
        for (int i = 0; i < arr.size(); i++) { // 0(N)
            temp.data = arr.get(i);
            temp = temp.next;
        }
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

public class Optimal_MergeSort {
    public static void main(String[] args) {
        // Create a linked list and add some elements
        CustomL list = new CustomL();
        list.addLast(4);
        list.addLast(2);
        list.addLast(5);
        list.addLast(1);
        list.addLast(3);

        System.out.println("Original List:");
        list.printList();

        // Sort the linked list using Brute Force
        list.sortLL();

        System.out.println("Sorted List:");
        list.printList();
    }
}
