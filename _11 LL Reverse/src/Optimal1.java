class CustomLL5 {
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

    // Method to reverse the linked list using iteration (reversing the next pointers)
    public void reverseLinkedListUsingIteration() {
        Node temp = head;  // Initialize 'temp' at the head of the linked list
        Node prev = null;  // Initialize pointer 'prev' to null

        // Traverse the list, continue until 'temp' reaches the end (null)
        while (temp != null) {
            Node front = temp.next;  // Store the next node to preserve the reference
            temp.next = prev;        // Reverse the direction of the current node's 'next' pointer
            prev = temp;             // Move 'prev' to the current node for the next iteration
            temp = front;            // Move 'temp' to the 'front' node, advancing the traversal
        }

        head = prev;  // Set the new head of the reversed list
    }
}

// Main class to test the Custom Linked List class and its methods
public class Optimal1 {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL5 list = new CustomLL5();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse the linked list using iteration
        list.reverseLinkedListUsingIteration(); // Directly call the method on the list object

        // Print the reversed list
        System.out.println("Reversed List:");
        list.printList();
    }
}
