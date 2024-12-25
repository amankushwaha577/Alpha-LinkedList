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

    /**
     * Deletes the first node of the list.
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // Only one node
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;

    }

    /**
     * Deletes the last node of the list.
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // Only one node
            head = null;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.prev.next = null;
    }

    /**
     * Deletes a node by its position (1-based index).
     * @param k the position of the node to be deleted.
     */
    public void deleteByPosition(int k) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (k == 1) { // Delete the first node
            deleteFirst();
            return;
        }
        Node currNode = head;
        int count = 0;
        while (currNode != null ) {
            count++;
            if(count == k){
                break;
            }
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("Position out of bounds");
            return;
        }
        if (currNode.next != null) {  // tail case1
            currNode.next.prev = currNode.prev;
        }
        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        }
    }

    /**
     * Deletes a node by its value.
     * @param val the value of the node to be deleted.
     */
    public void deleteByValue(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == val) { // Delete the first node
            deleteFirst();
            return;
        }
        Node currNode = head;
        while (currNode != null && currNode.data != val) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            System.out.println("Value not found in the list");
            return;
        }
        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        }
        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        }
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

        list.deleteFirst();
        list.printList(); // After deleting the first node

        list.deleteLast();
        list.printList(); // After deleting the last node

        System.out.println("------------------------------------------------------");

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2

        list.deleteByValue(7);
        list.printList(); // After deleting the node with value 7
    }
}
