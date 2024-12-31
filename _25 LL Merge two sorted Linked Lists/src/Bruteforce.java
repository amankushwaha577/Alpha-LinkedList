import java.util.ArrayList;
import java.util.Collections;

class CustomLL5 {
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

    // Static method to convert an ArrayList to a linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through the array and create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the array element
            temp.next = new Node(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting from the next of the dummy node
        return dummyNode.next;
    }

    // Function to merge two sorted linked lists
    static Node sortTwoLinkedLists(Node list1, Node list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = list1;
        Node temp2 = list2;

        // Case 1: Traverse the first linked list and add its elements to the array
        while (temp1 != null) {
            arr.add(temp1.data); // Add the current node's data to the array
            temp1 = temp1.next;  // Move to the next node in the first linked list
        }

        // Case 2: Traverse the second linked list and add its elements to the array
        while (temp2 != null) {
            arr.add(temp2.data); // Add the current node's data to the array
            temp2 = temp2.next;  // Move to the next node in the second linked list
        }

        // Case 3: Sort the combined array in ascending order
        Collections.sort(arr);

        // Case 4: Convert the sorted array back into a "new" linked list
        Node head = convertArrToLinkedList(arr);

        // Case 5: Return the head of the newly created sorted linked list
        return head;
    }

}

public class Bruteforce {
    public static void main(String[] args) {
        CustomLL5 list1 = new CustomLL5(); // Create the first linked list
        CustomLL5 list2 = new CustomLL5(); // Create the second linked list

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
        CustomLL5.Node mergedHead = CustomLL5.sortTwoLinkedLists(list1.head, list2.head);

        // Print the merged and sorted linked list
        System.out.println("Merged and Sorted List:");
        CustomLL5.Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
