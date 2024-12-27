import java.util.Stack;

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

    // Method to reverse the linked list
    public void reverseLinkedList() { // T:o(2N)  s:o(N)
        // Create a temporary pointer to traverse the linked list
        Node temp = head;

        // Create a stack to temporarily store the data values
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push the values of the linked list onto the stack
        while (temp != null) {
            stack.push(temp.data);  // Push the current node's data onto the stack
            temp = temp.next;       // Move to the next node in the linked list
        }

        // Reset the temporary pointer to the head of the linked list
        temp = head;

        // Step 2: Pop values from the stack and update the linked list
        while (temp != null) {
            temp.data = stack.pop();  // Set the current node's data to the value at the top of the stack
            temp = temp.next;         // Move to the next node in the linked list
        }
    }
}

// Main class to test the Custom Linked List class and its methods
public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse the linked list
        list.reverseLinkedList(); // Directly call the method on the list object

        // Print the reversed list
        System.out.println("Reversed List:");
        list.printList();
    }
}
