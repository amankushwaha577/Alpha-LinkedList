class CustomDoublyLinkedList {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the list
        Node prev; // Reference to the previous node in the list

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Adds a new node at the beginning of the list.
     * @param data the value to be added at the beginning.
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    /**
     * Adds a new node at the end of the list.
     * @param data the value to be added at the end.
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
     * Inserts a new node with the given value before the tail of the list.
     * @param val the value to be inserted before the tail.
     */
    public void insertBeforeTail(int val) {
        // Edge case: If the list has only one element
        if (head == null || head.next == null) {
            addFirst(val); // Use the existing addFirst method for single-element or empty list
            return;
        }

        // Traverse to the tail node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Create a new node with the given value
        Node newNode = new Node(val);

        // Update pointers to insert the new node before the tail
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    /**
     * Inserts a new node with the given value at a specific position in the list.
     * @param k the position to insert the new node (1-based index).
     * @param val the value to be inserted at the specified position.
     */
    public void insertByPosition(int k, int val) {
        Node newNode = new Node(val);

        if (k == 1) { // If position is 1, insert at the beginning
            addFirst(val); // Use the existing addFirst method
            return;
        }

        int cnt = 1;
        Node temp = head;

        // Traverse the list to find the node at position k-1
        while (temp != null) {
            if (cnt == k - 1) {
                // Insert the new node after the node at position k-1
                newNode.next = temp.next;
                if (temp.next != null) temp.next.prev = newNode;
                temp.next = newNode;
                newNode.prev = temp;
                return;
            }
            temp = temp.next;
            cnt++;
        }
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
}

public class Main {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();

        // Add nodes at the beginning
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.printList(); // Prints the list after adding nodes at the beginning

        // Add nodes at the end
        list.addLast(98);
        list.addLast(99);
        list.printList(); // Prints the list after adding nodes at the end

        System.out.println("------------------------------------------------------");

        // Insert a node at a specific position
        list.insertByPosition(2, 99999);
        list.printList(); // Prints the list after inserting at position 2

        // Insert a node before the tail
        list.insertBeforeTail(888);
        list.printList(); // Prints the list after inserting before the tail
    }
}
