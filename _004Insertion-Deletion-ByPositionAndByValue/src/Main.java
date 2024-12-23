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


    public void insertByPosition(int k, int val) {
        // Inserts a new node with the given data at a specific position.
        Node newNode = new Node(val);

        if (k == 1) { // Insert at the head.
            newNode.next = head;
            head = newNode;
            return;
        }

        int cnt = 0;
        Node temp = head;

        // Traverse the linked list to find the node at position k-1
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                // Insert the new node after the node at position k-1
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

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

    public void deleteByValue(int val) {
        // Check if the list is empty
        if (head == null)
            return;

        // If the first node has the target value, delete it
        if (head.data == val) {
            head = head.next;
            return;
        }

        // Traverse the list to find the node with the target value
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                // Adjust the pointers to skip the node with the target value
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        for (int i = 0; i < 9; i++) {
            list.addLast(i);
        }

        list.printList(); // Original list

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2

        list.deleteByValue(7);
        list.printList(); // After deleting the node with value 7

        System.out.println("------------------------------------------------------");

        list.insertByPosition(2,99999);
        list.printList();

    }
}