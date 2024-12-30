class CustomDoublyLinkedList2 {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        // Constructor to create a new node with the given data
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse to the last node of the list
        while (currNode.next != null) {
            currNode = currNode.next; // Move to the next node
        }
        currNode.next = newNode; // Link the last node to the new node
        newNode.prev = currNode; // Set the previous pointer of the new node to the last node
    }

    // Method to print the doubly linked list from head to tail
    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); // Print if the list is empty
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse and print each node's data
        while (currNode != null) {
            System.out.print(currNode.data + " <-> "); // Print data of current node
            currNode = currNode.next; // Move to the next node
        }
        System.out.println("null"); // End of the list
    }

    // Method to remove duplicates from a sorted doubly linked list
    public void removeDuplicatesFromSortedDLL() {
        // Case 1: Check if the list is empty
        if (head == null) {
            System.out.println("List is empty"); // If the list is empty, print a message and return
            return;
        }

        Node currNode = head; // Start from the head of the list

        // Traverse the list
        while (currNode != null && currNode.next != null) {
            // Case 2: If the current node's data is equal to the next node's data
            if (currNode.data == currNode.next.data) {
                Node duplicateNode = currNode.next; // Store the duplicate node
                currNode.next = duplicateNode.next; // Link current node to the node after the duplicate
                if (duplicateNode.next != null) {
                    duplicateNode.next.prev = currNode; // Update the previous pointer of the next node
                }
            } else {
                currNode = currNode.next; // Move to the next node
            }
        }
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        CustomDoublyLinkedList2 list = new CustomDoublyLinkedList2();
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original List:");
        list.printList(); // Print the list before removing duplicates

        list.removeDuplicatesFromSortedDLL(); // Remove duplicates

        System.out.println("\nList after removing duplicates:");
        list.printList(); // Print the list after removing duplicates
    }
}
