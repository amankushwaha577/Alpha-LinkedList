import java.util.HashMap;
import java.util.Map;

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

    // Method to detect a loop in the linked list using Tortoise and Hare algorithm
    public boolean detectLoop() { // T: O(N) | S: O(1)
        // Step 1: Initialize two pointers, slow and fast, at the head
        Node slow = head;
        Node fast = head;

        // Step 2: Traverse the linked list with the slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow one step
            fast = fast.next.next;  // Move fast two steps

            // Step 3: Check if slow and fast pointers meet
            if (slow == fast) {
                return true; // Loop detected
            }
        }

        // If fast reaches last node(in case of odd list)
        // If fast reaches null (in case of even list)
        // while loop will break : It means list is linear data structure.

        // If fast reaches the end of the list, there is no loop
        return false;
    }

    // Method to detect and return the starting node of the cycle
    public Node startNodeOfCycle() {  // T: O(N)+O(N)=O(N) || S:0(1)
        // Initialize slow and fast pointers to the head of the list
        Node slow = head;
        Node fast = head;

        // Phase 1: Detect the loop using the Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps

            // If slow and fast pointers meet, a loop is detected
            if (slow == fast) {
                // Phase 2: Find the first node of the loop

                // Reset the slow pointer to the head of the list
                // but fast is at remain at first collided place currently
                slow = head;

                // Now move both slow and fast one step at a time. The point at which they meet again
                // will be the starting node of the loop.
                while (slow != fast) {
                    slow = slow.next; // Move slow pointer one step
                    fast = fast.next; // Move fast pointer one step
                }

                // When slow and fast meet again, it means slow is at the start of the loop
                return slow;
            }
        }

        // If no loop is found, return null
        return null;
    }
}

    // Main class to test the CustomLL2 class
public class Optimal_TortoiseNHare {
    public static void main(String[] args) {
        // Create a linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Creating a loop in the list by manually linking the last node to the second node
        CustomLL2.Node temp = list.head;
        CustomLL2.Node loopNode = null;
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
        CustomLL2.Node cycleStartNode = list.startNodeOfCycle(); // Using list.startNodeOfCycle()
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

//
//Phase 1: Loop Detection
//        1. The Tortoise and Hare algorithm uses two pointers:
//              slow moves one step at a time.
//              fast moves two steps at a time.
//        2. In the worst case, the fast pointer traverses the entire list until it either finds the loop or reaches the end of the list.
//        3. If there is a loop, slow and fast will meet after traversing a portion of the loop.
//             This takes O(N) time because the fast pointer effectively skips one node per iteration.
//        4. If there is no loop, the while loop terminates after O(N) steps.

//Phase 2: Finding the Start of the Cycle
//        1. Once a loop is detected, the slow pointer is reset to the head of the list, and both slow and fast pointers move one step at a time.
//        2. The distance traveled in this phase is at most the size of the loop or the distance from the head to the start of the loop, which is also O(N) in the worst case.

//        Overall Time Complexity :
//        Both Phase 1 and Phase 2 are linear operations.
//        Therefore, the overall time complexity is:
//        ----------------------------------------------
//        O(N)+O(N)=O(N)