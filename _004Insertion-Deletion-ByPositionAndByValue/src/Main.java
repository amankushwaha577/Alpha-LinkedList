class CustomLinkedList {
    Node head; // head of list

    class Node {
        int data;         // Data stored in the node
        Node next;        // Reference to the next node in the linked list

        public Node(int data1) {
            this.data = data1;  // Initialize data with the provided value
            this.next = null;   // Initialize next as null since it's the end of the list
        }
    }

    public void addFirst(int data) {
        // Adds a new node with the given data at the beginning of the list.
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        // Adds a new node with the given data at the end of the list.
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node.
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        // Prints all elements in the list.
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) { // Traverse and print each node.
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void deleteFirst() {
        // Deletes the first node in the list.
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        // Deletes the last node in the list.
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.next == null) { // If only one node exists.
            head = null;
            return;
        }

        Node temp = head;

        // Traverse the list until the second-to-last node.
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; // Disconnect the last node.
    }

    public void insertByPosition(int position, int data) {
        // Inserts a new node with the given data at a specific position.
        Node newNode = new Node(data);

        if (position == 0) { // Insert at the head.
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        int count = 0;

        // Traverse to the node just before the desired position.
        while (currNode != null && count < position - 1) {
            currNode = currNode.next;
            count++;
        }

        if (currNode == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = currNode.next; // Re-link to insert the new node.
        currNode.next = newNode;
    }

    public void deleteByPosition(int k) {
        // Check if the list is empty
        if (head == null)
            return;

        // If k is 1, delete the first node
        if (k == 1) {
            head = head.next;
            return;
        }

        // Traverse the list to find the k-th node
        Node temp = head;
        Node prev = null;
        int cnt = 0;

        while (temp != null) {
            cnt++;
            // If the k-th node is found
            if (cnt == k) {
                // Adjust the pointers to skip the k-th node
                prev.next = prev.next.next;
                break;
            }
            // Move to the next node
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteByValue(int value) {
        // Deletes the first node that contains the specified value.
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.data == value) { // If the head node contains the value.
            head = head.next;
            return;
        }

        Node currNode = head;

        // Traverse to find the node just before the one with the target value.
        while (currNode.next != null && currNode.next.data != value) {
            currNode = currNode.next;
        }

        if (currNode.next == null) {
            System.out.println("Value not found in the list");
            return;
        }

        currNode.next = currNode.next.next; // Remove the node.
    }
}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }

        list.printList(); // Original list
//
//        list.insertByPosition(2, 99);
//        list.printList(); // After inserting 99 at position 2

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2

//        list.deleteByValue(3);
//        list.printList(); // After deleting the node with value 3
//
//        list.deleteByValue(10); // Attempt to delete a value not in the list


    }
}