class CustomDoublyLinkedList2 {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        // Constructor to create a new node with the given data
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse to the last node of the list
        while (currNode.next != null) {
            currNode = currNode.next; // Move to the next node
        }
        currNode.next = newNode; // Link the last node to the new node
        newNode.prev = currNode; // Set the previous pointer of the new node to the last node
    }

    // Method to print the doubly linked list from head to tail
    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); // Print if the list is empty
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse and print each node's data
        while (currNode != null) {
            System.out.print(currNode.data + " <-> "); // Print data of current node
            currNode = currNode.next; // Move to the next node
        }
        System.out.println("null"); // End of the list
    }

    // Optimized method using the two-pointer technique to find pairs with the given sum
    public void findAllPairsWithSum(int targetSum) { // O(n)
        // Case 1: Check if the list is empty
        if (head == null) {
            System.out.println("List is empty"); // If the list is empty, print message and return
            return;
        }

        // Case 2: Initialize two pointers
        Node left = head; // Left pointer starts at the head of the list
        Node right = head; // Right pointer starts at the head of the list

        // Move the right pointer to the last node
        while (right.next != null) {
            right = right.next; // Keep moving right pointer to the next node until it reaches the last node
        }

        boolean found = false; // Flag to track if any pair with the target sum is found

        // Step 2: Use the two-pointer technique
        // The loop continues while the left pointer is still to the left of the right pointer
        while (left.data < right.data) {
            int sum = left.data + right.data; // Calculate the sum of the data at left and right pointers

            // Case 3: If sum of left and right pointers equals the target sum
            if (sum == targetSum) {
                System.out.println("(" + left.data + ", " + right.data + ")"); // Print the pair
                found = true; // Mark that a pair was found
                left = left.next;  // Move left pointer right to explore other potential pairs
                right = right.prev;  // Move right pointer left to explore other potential pairs
            }
            // Case 4: If sum is less than target, move left pointer to the right
            else if (sum < targetSum) {
                left = left.next; // Move left pointer to the right to increase the sum
            }
            // Case 5: If sum is greater than target, move right pointer to the left
            else {
                right = right.prev; // Move right pointer to the left to decrease the sum
            }

            // Pause: At this point, the loop checks and adjusts the pointers based on the sum comparison.
            // Continue moving left or right pointers and rechecking until a pair is found or the pointers meet.
        }

        // Case 6: If no pair with the target sum was found, print a message indicating that
        if (!found) {
            System.out.println("No pairs found with the given sum."); // If no pairs were found, print this message
        }
    }
}

public class Optimal_TwoPointerApproach {
    public static void main(String[] args) {
        CustomDoublyLinkedList2 list = new CustomDoublyLinkedList2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(8);

        System.out.println("Original List:");
        list.printList(); // Print the list before searching for pairs

        System.out.println("\nPairs with sum 10:");
        list.findAllPairsWithSum(10);  // Looking for pairs that sum to 10
    }
}
