class CustomLL2 {
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

    // Method to add 1 to the number represented by the linked list
    public void addOne() { // T: o(3N)- 2 reverse+ 1 traverse for comparing, s: 0(1)
        // Reverse the linked list to make addition easier from least significant digit

        // head = reverseList(head);  <---- X no need to do it (its gpt code )
        // See : if we are reversing starting from head.
        // than only from head.next thing will change... keep it remember.
        // head will still point to the node that was head.
        // so no need to do head = reverseList(head);
        // so no need to touch head.
        // so no need to change head that was initially.
        Node newHead = reverseList(head);

        Node current = newHead;
        int carry = 1; // We are adding 1 to the number, so the initial carry is 1

        // Traverse the reversed list and add carry
        while (current != null) {
            int sum = current.data + carry; // Add carry to the current digit
            if(sum < 10){
                current.data = sum;
                carry = 0;  // If carry is 0, no need to continue the loop
                break; // Exit the loop early if no carry remains
            }else{
                current.data = 0;
                carry = 1;
            }
            current = current.next; // Move to the next node
        }

        // Reverse the list again to restore the original order
        newHead = reverseList(newHead); // newHead == head
        // actually there is no need of "newHead" variable.

        // head = reverseList(head); <---- X no need to do it
        //---------------------------------------------------
        // Remember => Node newHead = reverseList(head);
        // we have not changed original "head"
        // so after again reverse list came back in previous form
        // but beauty is that in complete process head pointed to the node that was initially head.
        // so we are back in original state but head is still same

        // If carry is left, we need to add a new node at front
        if (carry > 0) {
            Node newNode = new Node(carry); // Create a new node for the carry

            newNode.next = head; // Add it to the front of the list
            head = newNode; // make "newNode" as head
        }

    }

    // Method to reverse the linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // New head after reversal
    }
}

// Main class to test the CustomLL class and addOne method
public class Optimal_Recursion {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to represent a number (e.g., 1 -> 2 -> 3, which represents 123)
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Add 1 to the number represented by the linked list
        list.addOne();

        // Print the updated list
        System.out.println("List after adding 1:");
        list.printList();
    }
}
