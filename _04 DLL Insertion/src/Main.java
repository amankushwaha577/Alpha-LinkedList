class CustomDoublyLinkedList {
    Node head; // Head of the list

    // Inner class to define a Node in the doubly linked list
    class Node {
        int data;   // Data stored in the node
        Node prev;  // Reference to the previous node
        Node next;  // Reference to the next node

        public Node(int data1) {
            this.data = data1;  // Initialize data with the provided value
            this.prev = null;   // Initialize prev as null
            this.next = null;   // Initialize next as null
        }
    }

    /**
     * Adds a new node with the given data at the beginning of the list.
     * @param data The data for the new node.
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty, set the new node as the head
            head = newNode;
            return;
        }
        newNode.next = head; // Point new node's next to the current head
        head.prev = newNode; // Point current head's prev to the new node
        head = newNode;      // Update the head to the new node
    }

    /**
     * Adds a new node with the given data at the end of the list.
     * @param data The data for the new node.
     */
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty, set the new node as the head
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode;  // Point last node's next to the new node
        newNode.prev = currNode; // Point new node's prev to the last node
    }

    /**
     * Inserts a new node with the given data at a specific position in the list.
     * @param k   The position (1-based index) where the new node will be inserted.
     * @param val The data for the new node.
     */
    public void insertByPosition(int k, int val) {
        Node newNode = new Node(val);

        if (k == 1) { // If position is 1, insert at the beginning
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            return;
        }

        int cnt = 0;
        Node temp = head;

        // Traverse the list to find the (k-1)th node
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                newNode.next = temp.next; // Link new node to the next node
                if (temp.next != null) {
                    temp.next.prev = newNode; // Update prev of the next node
                }
                temp.next = newNode; // Link current node to the new node
                newNode.prev = temp; // Update new node's prev to the current node
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * Inserts a new node with the given data before the first occurrence of a node
     * with the specified value.
     * @param k   The value before which the new node will be inserted.
     * @param val The data for the new node.
     */
    public void insertBeforeValue(int k, int val) {
        Node newNode = new Node(val);

        if (head == null) { // If the list is empty, do nothing
            return;
        }

        if (head.data == k) { // If the value matches the head, insert at the beginning
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Node temp = head;

        // Traverse the list to find the node with the specified value
        while (temp != null) {
            if (temp.data == k) {
                newNode.prev = temp.prev; // Link new node to the previous node
                newNode.next = temp;     // Link new node to the current node
                temp.prev.next = newNode; // Update previous node's next to new node
                temp.prev = newNode;      // Update current node's prev to new node
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * Prints the elements of the doubly linked list in order.
     */
    public void printList() {
        if (head == null) { // If the list is empty, print a message
            System.out.println("List is Empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) { // Traverse the list and print each node's data
            System.out.print(currNode.data + " <-> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // Mark the end of the list
    }
}

public class Main {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();

        // Add elements to the beginning of the list
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.printList();

        // Add elements to the end of the list
        list.addLast(98);
        list.addLast(99);
        list.printList();

        System.out.println("------------------------------------------------------");

        // Insert an element at a specific position
        list.insertByPosition(2, 99999);
        list.printList();

        // Insert an element before a specific value
        list.insertBeforeValue(99999, 888);
        list.printList();
    }
}
