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
        // Start from the head of the list
        Node current = head;

        // Traverse the list until the end
        while (current != null) {
            // Check if the current node contains the key to be deleted
            if (current.data == key) {
                // Case 1: If the node to be deleted is the head of the list
                if (current == head) {
                    // Move the head pointer to the next node
                    head = current.next;

                    // If the new head is not null, update its prev pointer to null
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // Case 2: If the node to be deleted is not the head
                    Node nextNode = current.next; // Reference to the next node
                    Node prevNode = current.prev; // Reference to the previous node

                    // If the next node is not null, update its prev pointer to skip the current node
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }

                    // If the previous node is not null, update its next pointer to skip the current node
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                }
            }

            // Move to the next node in the list for further checks
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
