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
        // Create a new node with the given value
        Node newNode = new Node(val);

        // Edge case: If the list is empty /  has only one element
        if (head == null || head.next == null) {
            addFirst(val); // Use the existing addFirst method for single-element or empty list
            return;
        }

        // Traverse to the tail node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

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

        // K = 1 means node has to be insert before the head
        if (k == 1) {
            addFirst(val);
            return;
        }

        int cnt = 0;  // count so that the Kth element can be reached
        Node temp = head;

        while (temp != null) {
            cnt++;
            // On reaching the Kth position, break out of the loop
            if (cnt == k) {
                break;
            }
            temp = temp.next;  // keep moving temp forward till count != K
        }

        // take the node which is before the Kth node
        Node prev = temp.prev;

        //join the new node in between prev and temp
        prev.next = newNode;
        temp.prev = newNode;

        // Set newNode's pointers to prev and temp
        newNode.next = temp;
        newNode.prev = prev;

    }


    public void insertBeforeGivenValue(int k, int val) {
        Node newNode = new Node(val);

        // If the list is empty, we cannot insert
        if (head == null) {
            System.out.println("List is empty. Cannot insert before " + k);
            return;
        }

        Node temp = head;

        while (temp != null) {
            // On reaching the data=k position, break out of the loop
            if (temp.data == k) {
                break;
            }
            temp = temp.next;  // keep moving temp forward till temp.data != k
        }

        // If k is not found
        if (temp == null) {
            System.out.println("Value " + k + " not found in the list.");
            return;
        }

        // If inserting before the head node
        if (temp == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Normal case: inserting before a middle or last node =>
        // take the node which is before the Kth node
        Node prev = temp.prev;

        // join the new node in between prev and temp
        prev.next = newNode;
        temp.prev = newNode;

        // Set newNode's pointers to prev and temp
        newNode.next = temp;
        newNode.prev = prev;

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

        System.out.println("------------------------------------------------------");

        list.insertBeforeGivenValue(1,1111);
        list.printList();
    }
}
