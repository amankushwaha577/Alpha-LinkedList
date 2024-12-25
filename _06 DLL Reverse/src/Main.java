import java.util.Stack;
class CustomDoublyLinkedList {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Adds a new node at the end of the list.
     * @param data the value to be added.
     */
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
        newNode.prev = currNode;
    }

    /**
     * Prints the doubly linked list from head to tail.
     */
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " <-> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void reverseDLL() {  // Time : O(2N)- 2 Pass Solution Space : 0(N) - Stack
        // Initialise a stack st
        Stack<Integer> st = new Stack<>();

        // Initialise the node pointer temp at head
        Node temp = head;

        // Traverse the doubly linked list via the temp pointer
        while(temp!=null){
            // insert the data of the current node into the stack
            st.push(temp.data);
            // traverse further
            temp = temp.next;
        }

        // Reinitialise temp to head
        temp = head;

        // Second iteration of the DLL to replace the values
        while(temp!=null){
            // Replace the value pointed via temp with
            // the value from the top of the stack and pop it
            temp.data = st.pop();

            // Traverse further
            temp = temp.next;
        }
    }


    public void reverseDLL2() { // Time : O(N)- 1 Pass Solution Space : 0(1)
        // Check if the list is empty
        // or has only one node
        if (head == null || head.next == null) {
            // No change is needed;
            // return the current head
            return;
        }

        // Initialize a pointer to the previous node
        Node prev = null;

        // Initialize a pointer to the current node
        Node current = head;

        // Traverse the linked list
        while (current != null) {

            // Store a reference to the previous node
            prev = current.prev;

            // Swap the previous and
            // next pointers
            current.prev = current.next;

            // This step reverses the links
            current.next = prev;

            // Move to the next node
            // in the orignal list

            current = current.prev;
        }
        // At the last iteration of the loop,
        // prev = current.prev;
        // here, prev points to the second-to-last node of the original list. (which becomes the second node of the reversed list).

        head = prev.prev;
        //Therefore, setting head = prev.prev; ensures that head now points to the correct first node of the reversed doubly linked list.


    }

}

public class Main {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        for (int i = 0; i < 9; i++) {
            list.addLast(i);
        }
        list.printList();

        System.out.println("-------------------------------------------");

        list.reverseDLL();
        list.printList();

        list.reverseDLL2();
        list.printList();
    }
}
