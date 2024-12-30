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

    // Brute-force method to find all pairs with a given sum in the doubly linked list
    public void findAllPairsWithSum(int targetSum) { // T: O(n^2) Near about, Not exactly
        // Case 1: Check if the list is empty
        if (head == null) {
            System.out.println("List is empty"); // If the list is empty, print message and return
            return;
        }

        // Case 2: Start with the head node
        Node currentNode = head;
        boolean found = false; // Flag to track if any pair with the target sum is found

        // Outer loop to pick each node in the list (starting from the head)
        while (currentNode != null) {
            // Case 3: For each node in the outer loop, start checking pairs with the next nodes
            Node innerNode = currentNode.next; // Inner loop starts from the node after the current node

            // Inner loop to check each subsequent node for a pair with the target sum
            while (innerNode != null && currentNode.data + innerNode.data <= targetSum) {
                // When currentNode.data + innerNode.data > targetSum loop stops
                // because its sorted list further elements will always give bigger result only.

                // Case 4: Check if the sum of currentNode's data and innerNode's data equals the target sum
                if (currentNode.data + innerNode.data == targetSum) {
                    // If they sum to the target, print the pair
                    System.out.println("(" + currentNode.data + ", " + innerNode.data + ")");
                    found = true; // Mark that a pair was found
                }
                // Move to the next node in the inner loop
                innerNode = innerNode.next;
            }

            // Move to the next node in the outer loop
            currentNode = currentNode.next;
        }

        // Case 5: If no pair with the target sum was found, print a message indicating that
        if (!found) {
            System.out.println("No pairs found with the given sum.");
        }
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(8);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nPairs with sum 10:");
        list.findAllPairsWithSum(10);  // Looking for pairs that sum to 10
    }
}
