import java.util.ArrayList;

class CustomLL {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    static class Node {
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

    // Function to merge two sorted linked lists
    // ------------------------------------------
    // Time Complexity: O(N1 + N2)
    // Space Complexity: O(1)
    // ------------------------------------------
    static Node sortTwoLinkedLists(Node list1, Node list2) {
        // Case 1: Create a dummy node to initialize the merged linked list
        Node dummyNode = new Node(-1); // Dummy node acts as a placeholder to simplify list construction
        Node temp = dummyNode;         // Temporary pointer to build the merged list

        // Case 2: Traverse both lists simultaneously and compare elements
        while (list1 != null && list2 != null) { // O(N1 + N2)
            // Compare the current nodes of both lists
            if (list1.data <= list2.data) {
                temp.next = list1;    // Link the smaller node from list1
                temp = temp.next;         // Move the temporary pointer forward
                list1 = list1.next;  // Move to the next node in list1
            } else {
                temp.next = list2;    // Link the smaller node from list2
                temp = temp.next;         // Move the temporary pointer forward
                list2 = list2.next;  // Move to the next node in list2
            }

        }

        // Case 3: If any list has remaining elements, append them to the merged list
        if (list1 != null) { // If list1 has remaining nodes
            temp.next = list1;
        } else {             // If list2 has remaining nodes
            temp.next = list2;
        }

        // Case 4: Return the merged list starting from the next of the dummy node
        return dummyNode.next; // Skip the dummy node and return the actual head of the merged list
    }
}

public class Optimal {
    public static void main(String[] args) {
        CustomLL list1 = new CustomLL(); // Create the first linked list
        CustomLL list2 = new CustomLL(); // Create the second linked list

        // Adding sample nodes to the first linked list
        list1.addLast(1);
        list1.addLast(4);
        list1.addLast(5);

        // Adding sample nodes to the second linked list
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(6);
        list2.addLast(11);
        list2.addLast(19);

        // Print the original lists
        System.out.println("Original List 1:");
        list1.printList();
        System.out.println("Original List 2:");
        list2.printList();

        // Merge and sort the two linked lists
        CustomLL.Node mergedHead = CustomLL.sortTwoLinkedLists(list1.head, list2.head);

        // Print the merged and sorted linked list
        System.out.println("Merged and Sorted List:");
        CustomLL.Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        // Yes, the sortTwoLinkedLists method modifies the original lists
        // by re-linking their nodes during the merge process.
        // After the function completes, the original linked lists (list1 and list2) lose their independent structures and become part of the merged list.
        // Print the original lists
        System.out.println("Original List 1:");
        list1.printList();
        System.out.println("Original List 2:");
        list2.printList();
    }
}
