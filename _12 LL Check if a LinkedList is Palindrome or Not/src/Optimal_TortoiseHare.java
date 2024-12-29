class CustomLL2 {
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

    // Method to reverse a linked list starting from a given node
    private Node reverse(Node head) {
        Node prev = null;   // Initialize previous pointer as null
        Node current = head; // Start from the given head node
        while (current != null) {
            Node nextNode = current.next; // Temporarily store the next node
            current.next = prev;          // Reverse the current node's pointer
            prev = current;               // Move the previous pointer forward
            current = nextNode;           // Move the current pointer forward
        }
        return prev; // Return the new head of the reversed list
    }

    // Method to check if the linked list is a palindrome
    public boolean isPalindrome() { // T: 0(2N) S:0(1)
        // Step 1: Handle edge cases - An empty or single-node list is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 2: Use slow and fast pointers to find the middle of the list
        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head; // Fast pointer moves two steps at a time
        while (fast != null && fast.next != null) { // 0(n/2)=>fast is moving double only
            // Purpose: The `fast` pointer traverses the list twice as fast as `slow`.
            // This ensures that when `fast` reaches the end of the list, `slow` will be
            // at the midpoint.
            // If the list has an odd number of nodes, `slow` points to the exact middle node.
            // If even, it points to the start of the second half.
            slow = slow.next;       // Move slow pointer forward by one node
            fast = fast.next.next; // Move fast pointer forward by two nodes
        }

        System.out.println("Middle Node " + slow.data); // For rNd we are in middle

        // Step 3: Reverse the second half of the list // 0(n/2) => reversing only 2nd half
        Node secondHalf = reverse(slow); // Reverse the list starting from the middle
        Node firstHalf = head;          // Keep a pointer to the first half

        // Save a copy of the reversed half to restore the original list later
        Node secondHalfCopy = secondHalf;

        // Step 4: Compare the first and second halves of the list
        boolean isPalindrome = true; // Assume the list is a palindrome initially

        while (secondHalf != null) { // 0(n/2)=> traversing only 2nd half
            System.out.println(firstHalf.data+" "+ secondHalf.data);
            // For rNd : comparing 1st half & reversed 2nd half => What we got => In odd list middle node will be used in comparison in both reveres 2nd half + 1st half
            // 5 elements there => 2nd list stated from 3, so when 2nd list will be traverse because of 3 node in this 3 node of 1st list will be traverse.

            if (firstHalf.data != secondHalf.data) {
                // If any corresponding values differ, the list is not a palindrome
                isPalindrome = false;
                break;
            }
            // Move both pointers forward
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 5: Restore the original list structure //  0(n/2) => reversing again only 2nd half
        reverse(secondHalfCopy); // Reverse the second half again to its original order

        // Step 6: Return the result
        return isPalindrome; // Return true if the list is a palindrome, otherwise false
    }
}

// Main class to test the CustomLL2 class and isPalindrome method
public class Optimal_TortoiseHare {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Check if the linked list is a palindrome
        boolean result = list.isPalindrome();

        // Print the result
        System.out.println("Is the list a palindrome? " + result);

        // Print the list again to ensure it is unchanged
        System.out.println("List after palindrome check:");
        list.printList();
    }
}
