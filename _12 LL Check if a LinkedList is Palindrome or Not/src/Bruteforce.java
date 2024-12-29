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

    // Method to check if the linked list is a palindrome
    public boolean isPalindrome() {
        // Create an empty stack to temporarily store the values of the linked list
        Stack<Integer> st = new Stack<>();

        // Initialize a temporary pointer to traverse the linked list
        Node temp = head;

        // Step 1: Traverse the linked list and push all values onto the stack
        while (temp != null) {
            // Push the data from the current node onto the stack
            st.push(temp.data);

            // Move to the next node in the linked list
            temp = temp.next;
        }

        // Reset the temporary pointer back to the head of the linked list
        temp = head;

        // Step 2: Traverse the linked list again and compare values from the stack
        while (temp != null) {
            // Peek the top value of the stack and compare it with the current node's data
            if (temp.data != st.peek()) {
                // If the values don't match, the linked list is not a palindrome
                return false;
            }

            // Pop the top value from the stack as it matches the current node's data
            st.pop();

            // Move to the next node in the linked list
            temp = temp.next;
        }

        // If all values match during the comparison, the linked list is a palindrome
        return true;
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Check if the linked list is a palindrome
        if (list.isPalindrome()) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
