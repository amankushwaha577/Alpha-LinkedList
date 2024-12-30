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
        // Traverse to the last node in the list
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); // If the list is empty, print a message
            return;
        }
        Node currNode = head;
        // Traverse and print each node until the end of the list
        while (currNode != null) {
            System.out.print(currNode.data + " -> "); // Print current node's data
            currNode = currNode.next; // Move to the next node
        }
        System.out.println("null"); // Indicate the end of the list
    }

    // Function to rotate the linked list by 'k' positions
    public void rotate(int k) {
        // 1. Check if the list is empty or if no rotation is needed (k == 0)
        if (head == null || k == 0) return;  // If list is empty or k is 0, no rotation is needed

        // 2. Find the length of the linked list
        Node temp = head;
        int length = 1;  // Start with length 1 because the head node is counted first
        // Traverse the list to calculate the total number of nodes
        while (temp.next != null) { // Traverse until the last node
            temp = temp.next;   // Move to the next node
            length++;           // Increment the length
        }

        // 3. Handle cases where k is larger than the length of the list
        k = k % length;  // If k is greater than the length, rotate only k % length times
        if (k == 0) return;  // If k % length results in 0, no rotation is needed

        // 4. Make the list circular by connecting the last node to the head
        temp.next = head;  // Connect the last node to the head, creating a circular list

        // 5. Find the new head after rotating k positions
        int newHeadPosition = length - k;  // New head should be at this position (from the end)
        Node newTail = head;  // Start from the head of the list
        // Traverse to the (length - k)th node, which will become the new tail
        for (int i = 1; i < newHeadPosition; i++) {
            newTail = newTail.next; // Move the newTail pointer forward
        }

        // 6. Update the head and break the circular link
        head = newTail.next;   // The new head is the next node of the current tail
        newTail.next = null;    // Break the circular link by setting the next pointer of the new tail to null
    }

}

public class Bruteforce {
    public static void main(String[] args) {
        CustomLL5 list = new CustomLL5(); // Create an instance of the linked list

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
        list.printList(); // Display the original list

        // Rotate the list by 3 positions
        list.rotate(3); // Perform the rotation operation

        // Print the modified list
        System.out.println("List after rotating by 3 positions:");
        list.printList(); // Display the list after rotation
    }
}
