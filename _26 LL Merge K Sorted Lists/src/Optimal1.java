import java.util.ArrayList;

class CustomL {
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
    // Time Complexity: O(N1 + N2) | Space Complexity: O(1)
    // ------------------------------------------
    // Suppose list1 = 5 elm, list2 = 9 elm
    // A. The loop will run for 5 elements of list1, and after the loop exits,
    //    possibly in this time a few nodes(lets say 2) of list2 also attached,
    //    now 7 remains in list2-
    //    ----->
    //    now this 7-element chain will be added directly at the end of the newly merged list.
    //    Thus, time = 5 (for list1) + 2 (for list2) = O(N1 + N2) ~= 0(N1) almost

    // B. In the worst case, list1 and list2 will be fully traversed.
    //    Thus, time = 9 (for list2) + 5 (for list1, maybe one or two less) = O(N1 + N2)

    public static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Case 1: Create a dummy node to initialize the merged linked list
        Node dummyNode = new Node(-1); // Dummy node acts as a placeholder to simplify list construction
        Node temp = dummyNode;         // Temporary pointer to build the merged list

        // Case 2: Traverse both lists simultaneously and compare elements
        while (list1 != null && list2 != null) { // O(N1 + N2)
            // Compare the current nodes of both lists
            if (list1.data <= list2.data) {
                temp.next = list1;    // Link the smaller node from list1
                temp = list1;         // Move the temporary pointer forward or- temp = temp.next;
                list1 = list1.next;   // Move to the next node in list1
            } else {
                temp.next = list2;    // Link the smaller node from list2
                temp = list2;         // Move the temporary pointer forward or- temp = temp.next;
                list2 = list2.next;   // Move to the next node in list2
            }
        }

        // Case 3: If any list has remaining elements, append them to the merged list
        if (list1 != null) { // If list1 has remaining nodes
            temp.next = list1;
        }
        if (list2 != null) { // If list2 has remaining nodes
            temp.next = list2;
        }

        // Case 4: Return the merged list starting from the next of the dummy node
        return dummyNode.next; // Skip the dummy node and return the actual head of the merged list
    }

    // Function to merge K sorted linked lists
    // -----------------------------------------------------------
    // Time Complexity for merging two list of size N1, N2 : O(N1 + N2)
    // -----------------------------------------------------------
    // Time Complexity for merging K list each of size N   : N* [ ( K * (K+1))/2 ]
    // -----------------------------------------------------------
    // Suppose we are having size of listArray  = k
    // It means No of Heads = k = No of Lists
    // Suppose size of each list = N
    // ------->
    // Fist Merge,      i=1 =  N1+ N2                        = 2N
    // Second Merge     i=2 = (N1+ N2) + N3                  = 3N
    // Third/last Merge i=3 = (N1+ N2 + N3) + N4  (let k =4) = 4N
    // Total Time = 2N + 3N + 4N + ....KN  (K= No Of Lists)
    //            = N( 1+2+3+..K)
    //            = N* [ ( K * (K+1))/2 ]

    public static Node mergeKLists(ArrayList<Node> listArray) {
        // Consider the first linked list
        // as the starting point for merging
        Node head = listArray.get(0);

        // Loop through the remaining
        // linked lists in the 'listArray'
        for (int i = 1; i < listArray.size(); i++) {
            // Merge the current 'head' linked
            // list with the next linked list
            head = mergeTwoSortedLinkedLists(head, listArray.get(i));
        }
        // Return the head of
        // the merged linked lists
        return head;
    }
}

public class Optimal1 {
    public static void main(String[] args) {
        CustomL list1 = new CustomL(); // Create the first linked list
        CustomL list2 = new CustomL(); // Create the second linked list
        CustomL list3 = new CustomL(); // Create the third linked list

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

        // Adding sample nodes to the third linked list
        list3.addLast(0);
        list3.addLast(7);
        list3.addLast(8);
        list3.addLast(10);
        list3.addLast(15);

        // Print the original lists
        System.out.println("Original List 1:");
        list1.printList();
        System.out.println("Original List 2:");
        list2.printList();
        System.out.println("Original List 3:");
        list3.printList();

        // Merge and sort the three linked lists
        ArrayList<CustomL.Node> listArray = new ArrayList<>();
        listArray.add(list1.head);
        listArray.add(list2.head);
        listArray.add(list3.head);

        CustomL.Node mergedHead = CustomL.mergeKLists(listArray);

        // Print the merged and sorted linked list
        System.out.println("Merged and Sorted List:");
        CustomL.Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        // Check if original lists are changed
        // -----------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("Original List 1:");
        list1.printList();
        System.out.println("Original List 2:");
        list2.printList();
        System.out.println("Original List 3:");
        list3.printList();

        // If You Need to Preserve the Original Lists:
        // -------------------------------------------
        // 1. Implement a helper method to deep copy a linked list.
        // 2. Use these copies as inputs to the mergeKLists method.
    }
}
