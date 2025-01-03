import java.util.*;

class CustomL {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    static class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        // Constructor to initialize a node
        public Node(int data) {
            this.data = data;  // Set the data
            this.next = null;  // Initialize next as null
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

    // Merge two sorted linked lists
    private Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        Node dummyNode = new Node(-1); // Dummy node as the start of the merged list
        Node temp = dummyNode;

        // Traverse both lists and merge them in sorted order
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // Move the temp pointer forward
        }

        // If elements remain in either list, append them
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next; // Return the merged list, starting from the next of dummy node
    }

    // Find the middle of the linked list
    private Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;

        // Node fast = head; <------------------------------Normal Case
        // According to Normal Tortoise hare Middle - :
        // 1-2-3-4   => mid : 3 ( middle 2 )
        // 1-2-3-4-5 => mid : 3

        // Slight Modification : Exceptional for MergeSort
        Node fast = head.next; // <------------------- fast is one step ahead
        // According to Normal Tortoise hare Middle :
        // 1-2-3-4   => mid : 2 ( middle 1 )
        // 1-2-3-4-5 => mid : 3

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow pointer is at the middle
    }



    // Function to perform merge sort on a linked list
    // -----------------------------------------------------------
    // Time Complexity : 0(NlogN)  | Space Complexity :  0(log(N))
    // -----------------------------------------------------------
    // S : height of Recursive stack = 0(log(N)) | N = no of nodes
    // T : Total Recursion Height * ( Total Inner Operations )
    //    =   0(logN)  * ( 0( findMiddle() ) + 0( mergeTwoSortedLinkedLists() ) )
    //    =   0(logN)  * (      0(N/2)       +             0(N)                 )

    // I think at 21:39 the Space Complexity won't be O(1),
    // the reason being that the recursion stack adds up to Space Complexity of O(log N).
    // But anyways there's no explicitly auxiliary space is being used, so the reasoning is always O(1).
    // Extra Space : O(1)
    // Recursive Space :   O(log N) | Its True.(Interview)
    public Node mergeSort(Node head) {
        // Base case: If the list has 0 or 1 node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Case 1: Find the middle of the list
        // Split the linked list into two halves
        Node middle = findMiddle(head);  // 0(N/2)
        Node left = head;         // Start of the first half
        Node right = middle.next; // Start of the second half
        middle.next = null;       // End the first half


        // Case 2: Recursively sort the left half
        left = mergeSort(left);

        // Case 3: Recursively sort the right half
        right = mergeSort(right);

        // Case 4: Merge the two sorted halves
        return mergeTwoSortedLinkedLists(left, right); // mergeTwoSortedLinkedLists() takes 0(N1+N2) ~ 0(N)

    }
    // A. 1-2-3-4   => mid : 2
    //    left = 1-2
    //    right = 3-4                 ( next of mid )
    // B. 1-2-3-4-5 => mid : 3
    //    left = 1-2-3
    //    right = 4-5                 ( next of mid )

    // Method to print the linked list
    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}

public class Optimal_MergeSort {
    public static void main(String[] args) {
        // Create a linked list and add some elements
        CustomL list = new CustomL();
        list.addLast(4);
        list.addLast(2);
        list.addLast(5);
        list.addLast(1);
        list.addLast(3);

        System.out.println("Original List:");
        list.printList(list.head);

        // Directly call mergeSort and update the head with the sorted list
        list.head = list.mergeSort(list.head);

        System.out.println("Sorted List:");
        list.printList(list.head);
    }
}
