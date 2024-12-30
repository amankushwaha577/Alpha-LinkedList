class CustomLL5 {
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

    // Function to reverse a linked list using 3-pointer approach
    public Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Function to get the Kth node from a given position in the linked list
    static Node getKthNode(Node node, int k) {
        int count = 1; // Initialize the count to 1
        while (node != null && count < k) {
            node = node.next; // Move to the next node
            count++; // Increment the count
        }
        return node; // Return the Kth node or null if not found
    }

    // Function to reverse nodes in groups of K
    public Node kReverse(Node head, int k) {
        Node temp = head;
        Node prevLast = null;

        while (temp != null) {
            Node kThNode = getKthNode(temp, k);

            if (kThNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            Node nextNode = kThNode.next;
            kThNode.next = null;

            Node newHead = reverseLinkedList(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomLL5 list = new CustomLL5();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse nodes in groups of 3
        list.head = list.kReverse(list.head, 3);

        // Print the modified list
        System.out.println("List after reversing in groups of 3:");
        list.printList();
    }
}
