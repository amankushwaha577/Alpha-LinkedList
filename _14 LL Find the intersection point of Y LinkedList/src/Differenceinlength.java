class CustomLL3 {
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

    // Utility function to calculate the length difference between two linked lists
    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;

        // Traverse both linked lists to calculate their lengths
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                ++len1;
                head1 = head1.next; // Move to the next node in the first list
            }
            if (head2 != null) {
                ++len2;
                head2 = head2.next; // Move to the next node in the second list
            }
        }

        return len1 - len2; // Return the difference in lengths
    }

    // Utility function to check for intersection between two linked lists
    static Node intersectionPresent(Node head1, Node head2) {
        int diff = getDifference(head1, head2); // Calculate the length difference

        // Align the starting points of the two lists
        if (diff < 0) {
            while (diff++ != 0) {
                head2 = head2.next; // Move the pointer in the second list
            }
        } else {
            while (diff-- != 0) {
                head1 = head1.next; // Move the pointer in the first list
            }
        }

        // Traverse both lists and find the intersection point
        while (head1 != null) {
            if (head1 == head2) { // Check if the nodes are the same
                return head1;  // Intersection point found
            }
            head1 = head1.next; // Move to the next node in the first list
            head2 = head2.next; // Move to the next node in the second list
        }

        return null; // No intersection found
    }
}

// Main class to test the CustomLL2 class and intersectionPresent method
public class Differenceinlength {
    public static void main(String[] args) {
        // Create two linked lists
        CustomLL3 list1 = new CustomLL3();
        CustomLL3 list2 = new CustomLL3();

        // Adding sample nodes to list1 (e.g., 1 -> 2 -> 3)
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        // Adding sample nodes to list2 (e.g., 4 -> 5) and then create an intersection at node 2
        list2.addLast(4);
        list2.addLast(5);
        list2.head.next.next = list1.head.next; // Creating intersection at node 2

        // Print both linked lists
        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        // Find the intersection point
        CustomLL3.Node intersectionNode = CustomLL3.intersectionPresent(list1.head, list2.head);

        // Print the intersection result
        if (intersectionNode != null) {
            System.out.println("Intersection point at node with data: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
