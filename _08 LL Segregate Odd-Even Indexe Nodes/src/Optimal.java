class CustomLL {
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

    // Method to segregate odd and even indexed nodes in-place
    public void segregateOddEvenIndices() { // T: o(N/2)*2=o(N) S: o(1)
        if (head == null || head.next == null) return; // No segregation needed for empty or single-node list

        Node odd = head; // Points to the first node (odd-indexed node)
        Node even = head.next; // Points to the second node (even-indexed node)
        Node evenHead = head.next; // Keep the head of the even-indexed nodes for later connection

        // Traverse the list, segregating odd and even indexed nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Skip the even node
            odd = odd.next;       // Move to the next odd-indexed node

            even.next = even.next.next; // Skip the odd node
            even = even.next;     // Move to the next even-indexed node
        }

        // Connect the last odd node to the head of the even-indexed nodes
        odd.next = evenHead;
    }
}

public class Optimal {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        System.out.println("Original List:");
        list.printList();

        // Segregate odd and even indexed nodes
        list.segregateOddEvenIndices();

        // Print the modified list
        System.out.println("After Segregating Odd and Even Indexed Nodes:");
        list.printList();
    }
}
