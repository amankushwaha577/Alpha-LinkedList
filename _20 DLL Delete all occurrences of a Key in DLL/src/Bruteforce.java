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

    // Method to add a new node at the end of the list
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

    // Method to print the doubly linked list from head to tail
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

    // Method to delete all occurrences of a given key in the doubly linked list
    public void deleteAllOccurrences(int key) {
        // Initialize a pointer to traverse the list
        Node current = head;

        while (current != null) {
            // If the current node matches the key
            if (current.data == key) {
                // Update the next pointer of the previous node, if it exists
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // If current node is the head, move the head to the next node
                    head = current.next;
                }

                // Update the previous pointer of the next node, if it exists
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }

            // Move to the next node
            current = current.next;
        }
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.addLast(2);
        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);
        list.addLast(2);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nAfter deleting all occurrences of 2:");
        list.deleteAllOccurrences(2);
        list.printList();
    }
}
