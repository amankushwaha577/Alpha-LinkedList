import java.util.HashSet;

class CustomLL4 {
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

    // Utility function to check presence of intersection between two linked lists
    static Node intersectionPresent(Node head1, Node head2) { // T:0(N1+N2) // any one pointer: suppose d1 pointer can traverse both lists if it reaches null of its list List1 than it will traverse List2 ( We are not doing 2(N1+N2) because d2 is also moving simultaneously with d1 )  || S: 0(1)
        // Check if either list is null
        if (head1 == null || head2 == null) {
            return null; // If either list is null, there's no intersection
        }
        Node d1 = head1;
        Node d2 = head2;

        // Traverse both lists simultaneously
        while (d1 != d2) {
            // Check if d1 is null
            if (d1 == null) {
                // If d1 is reach null, now restart from head2
                d1 = head2;
            } else {
                // Otherwise, move to the next node in list1
                d1 = d1.next;
            }

            // Check if d2 is null
            if (d2 == null) {
                // If d2 is null, now restart from head1
                d2 = head1;
            } else {
                // Otherwise, move to the next node in list2
                d2 = d2.next;
            }
        }

        // Always through this algorithm:
        // d1 and d2 will either meet at the intersection node, or both will be null if no intersection
        return d1;
    }

}

// Main class to test the CustomLL2 class and intersectionPresent method
public class Optimised {
    public static void main(String[] args) {
        // Create two linked lists
        CustomLL4 list1 = new CustomLL4();
        CustomLL4 list2 = new CustomLL4();

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
        CustomLL4.Node intersectionNode = CustomLL4.intersectionPresent(list1.head, list2.head);

        // Print the intersection result
        if (intersectionNode != null) {
            System.out.println("Intersection point at node with data: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
