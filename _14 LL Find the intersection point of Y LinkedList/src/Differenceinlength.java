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
    static int getDifference(Node head1, Node head2) { // T: 0(N1 +N2)
        int len1 = 0, len2 = 0;

        // Calculate the length of the first linked list
        while (head1 != null) {
            ++len1;
            head1 = head1.next;
        }

        // Calculate the length of the second linked list
        while (head2 != null) {
            ++len2;
            head2 = head2.next;
        }

        return len1 - len2; // Return the difference in lengths
    }

    // Utility function to check for intersection between two linked lists
    static Node intersectionPresent(Node head1, Node head2) { // T:  0(N1 +N2) + 0(N1-N2) + 0(N2) => 0(2N1 + N2)  | S: 0(1)
        // Check if either list is null
        if (head1 == null || head2 == null) {
            return null; // If either list is null, there's no intersection
        }
        // Step 1: Calculate the length difference between the two linked lists
        int diff = getDifference(head1, head2); // The difference in lengths is computed using getDifference()
        // if diff>0 => l1 is bigger
        // if diff<0 => l2 is bigger

        // Step 2: Align the starting points of the two linked lists
        if (diff > 0) { // T : 0(N1-N2) Assuming L1 is bigger
            // If the first list is longer, move its pointer ahead by 'diff' nodes
            // This ensures both lists start at the same relative position
            // for further comparison.
            while (diff != 0) {
                head1 = head1.next; // Move the pointer in the first list
                diff--; // Decrement diff towards 0
            }
        } else if (diff < 0) {
            // If the second list is longer, move its pointer ahead by 'diff' nodes
            // This aligns the second list to the same relative position as the first list.
            while (diff != 0) {
                head2 = head2.next; // Move the pointer in the second list
                diff++; // Increment diff towards 0
            }
        }

        // Step 3: Traverse both linked lists simultaneously
        while (head1 != null && head2 != null) {  // T: 0(N2), We moved 'diff' movements already for L1 if L1 is bigger so now rest movements will be size of L2 (which is small list)
            // Check if the current nodes of both lists are the same
            if (head1 == head2) {
                // Intersection found, return the intersecting node
                return head1;
            }
            // Move both pointers to the next nodes in their respective lists
            head1 = head1.next;
            head2 = head2.next;
        }

        // Step 4: If no intersection is found, return null
        return null;
    }
}

// Main class to test the CustomLL3 class and intersectionPresent method
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
