class CustomLL1 {
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

    // Function to find the middle node of a linked list
    public Node findMiddle() { // T: O(N1) for length check + O(N/2) for traverse up to mid || S: O(1)
        // If the list is empty or has
        // only one element, return the head as
        // it's the middle.
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int count = 0;

        // Count the number of nodes in the linked list.
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Calculate the position of the middle node.
        int mid = count / 2 + 1;  // if count = 5 => (5/2)+1 = 2+1 =3 Great || count = 6 => (6/2)+1 = 3+1 =4 Great ( Choose Right Middle )
        temp = head;

        while (temp != null) {
            mid--;

            // Check if the middle
            // position is reached.
            if (mid == 0) {
                // break out of the loop
                // to return temp
                break;
            }
            // Move temp ahead
            temp = temp.next;
        }

        // Return the middle node.
        return temp;
    }

    // Function to delete the middle node in the linked list
    public void deleteMiddle() { // T: O(N) for traversal to find length + O(N/2) for finding and deleting the middle node || S: O(1)
        // If the list is empty or has only one element, we return
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        int count = 0;

        // Count the number of nodes in the linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Calculate the index of the middle node
        int mid = count / 2;  // Middle node index (use the left middle if the list has even nodes)
        // In findMiddle  => if count = 5 => (5/2)+1 = 2+1 =3 Great || count = 6 => (6/2)+1 = 3+1 =4 Great ( Choose Right Middle )
        // In deleteMiddle=> if count = 5 => (5/2)   = 2   =2 Great || count = 6 => (6/2)   = 3   =3 Great ( Choose left Middle )

        temp = head;

        // Loop to find the node just before the middle node
        while (temp != null) {
            mid--;  // Decrement mid

            // Check if we have reached the node just before the middle node
            if (mid == 0) {
                // Skip the middle node by changing the pointer of the previous node
                temp.next = temp.next.next;
                break; // Exit the loop after deleting the middle node
            }

            // Move temp to the next node
            temp = temp.next;
        }
    }
}

// Main class to test the CustomLL1 class and deleteMiddle method
public class Bruteforce {
    public static void main(String[] args) {
        // Create a linked list
        CustomLL1 list = new CustomLL1();

        // Adding sample nodes to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the linked list
        System.out.println("List before deletion:");
        list.printList();

        // Find and print the middle node
        CustomLL1.Node middleNode = list.findMiddle(); // Using list.findMiddle()
        if (middleNode != null) {
            System.out.println("Middle node is: " + middleNode.data);
        } else {
            System.out.println("The list is empty.");
        }

        // Delete the middle node
        list.deleteMiddle(); // Using list.deleteMiddle() directly

        // Print the linked list after deleting the middle node
        System.out.println("List after deleting the middle node:");
        list.printList();
    }
}

/*
 * Linked List before deletion:
 * 1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * Middle node: 3
 *
 * Linked List after deletion:
 * 1 -> 2 -> 4 -> 5 -> null
 */
