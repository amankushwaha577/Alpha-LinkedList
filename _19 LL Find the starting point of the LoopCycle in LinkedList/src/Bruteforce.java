import java.util.HashMap;
import java.util.Map;

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
        Map<Node, Integer> visitedNodes = new HashMap<>(); // Map to track visited nodes

        while (currNode != null) { // Traverse and print each node
            // Check if the current node has already been visited
            if (visitedNodes.containsKey(currNode)) {
                System.out.println("Loop detected. Stopping printing.");
                break; // Stop printing to avoid infinite loop
            }

            System.out.print(currNode.data + " -> ");
            visitedNodes.put(currNode, 1); // Mark the current node as visited
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // Method to detect a loop in the linked list
    public boolean detectLoop() { // T: O(N) | S: O(N)
        // T: 0(N x 2 Map operation (insert, find) cost maybe log/constant ) => 0(N) | lets take constant for that. || S : 0(N) To store all nodes

        // Step 1: Initialize a pointer 'temp' at the head of the linked list
        Node temp = head;

        // Step 2: Create a map to keep track of visited nodes
        // The key in the map is the node reference, and the value is a marker (e.g., integer 1)
        Map<Node, Integer> nodeMap = new HashMap<>();

        // Step 3: Traverse the linked list
        while (temp != null) {
            // Step 4: Check if the current node has already been visited
            if (nodeMap.containsKey(temp)) {
                // If the node is found in the map, it indicates a loop
                return true;
            }

            // Step 5: Add the current node to the map to mark it as visited
            nodeMap.put(temp, 1);

            // Step 6: Move to the next node in the linked list
            temp = temp.next;
        }

        // Step 7: If we reach the end of the list (null), no loop is detected
        return false;
    }

    // Function to detect a loop in a linked list and return the starting node of the loop
    public Node startNodeOfCycle() { // T: O(N) | S: O(N)
        // T: 0(N x 2 Map operation (insert, find) cost maybe log/constant ) => 0(N) | lets take constant for that. || S : 0(N) To store all nodes

        // Use temp to traverse the linked list
        Node temp = head;

        // HashMap to store all visited nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (nodeMap.containsKey(temp)) {
                // A loop is detected, hence return temp
                return temp;
            }

            // Store temp as visited
            nodeMap.put(temp, 1);

            // Iterate through the list
            temp = temp.next;
        }

        // If no loop is detected, return null
        return null;
    }
}

// Main class to test the CustomLL1 class
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

        // Creating a loop in the list by manually linking the last node to the second node
        CustomLL1.Node temp = list.head;
        CustomLL1.Node loopNode = null;
        int position = 2; // We want to create the loop starting at position 2 (second node)

        // Traverse the list and find the node at the specified position
        while (temp != null) {
            position--;
            if (position == 0) {
                loopNode = temp; // Mark the second node
            }
            temp = temp.next;
        }

        // Create a loop by linking the last node to the second node
        if (loopNode != null) {
            temp = list.head;
            while (temp != null && temp.next != null) { // reach last node using temp
                temp = temp.next;
            }
            // Link the last node's next to the loopNode (second node)
            temp.next = loopNode;
        }

        // Print the linked list (will cause an infinite loop, but we're checking for the loop)
        System.out.println("List (with loop):");
        list.printList();

        // Check for loop in the list
        boolean hasLoop = list.detectLoop(); // Using list.detectLoop() instead
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));

        // Detect and print the starting node of the cycle
        CustomLL1.Node cycleStartNode = list.startNodeOfCycle(); // Using list.startNodeOfCycle()
        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with data: " + cycleStartNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

/*
 * Linked List with a Loop:
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *      ^______________|
 *
 * The loop starts at node 2 and continues in the cycle 2 -> 3 -> 4 -> 5 -> 2 -> ...
 * This is achieved by connecting the last node (5) back to the second node (2).
 */
