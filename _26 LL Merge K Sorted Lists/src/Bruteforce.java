import java.util.ArrayList;
import java.util.Collections;

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

    // Static method to convert an ArrayList to a linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through the array and create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            temp.next = new Node(arr.get(i));
            temp = temp.next;
        }
        return dummyNode.next;
    }

    // Function to merge K sorted linked lists
    //--------------------------------------------
    // let no of list Head = k, elements in each list = N
    //   Add in array          Sort           create new list
    //   0(K * N) +     (K * N)log(K * N) +       (K * N)
    // ---------------------------------------------
    // S:0(K * N) for array + 0(K * N) for new List
    static Node mergeKLists(ArrayList<Node> listArray) {
        // Create an ArrayList to store all the elements from all the linked lists
        ArrayList<Integer> arr = new ArrayList<>();

        // Traverse each linked list in the listArray
        for (Node headNode : listArray) { // runs 0(K)
            Node temp = headNode; // Start from the head of each linked list

            // Traverse the current linked list and add each node's data to the array
            while (temp != null) { // runs 0(N) for each  K
                arr.add(temp.data);  // Add the data of the current node to the array
                temp = temp.next;    // Move to the next node in the linked list
            }
        }

        // Sort the array containing elements from all linked lists
        Collections.sort(arr); // (K * N)log(K * N)

        // Convert the sorted array back into a linked list and return the head of the merged list
        Node newlyListHead = convertArrToLinkedList(arr); // (K * N)
        return newlyListHead;
    }


    // Method to print the linked list
    public void printList() {
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

public class Bruteforce {
    public static void main(String[] args) {
        // Create five linked lists with different sizes
        CustomLL list1 = new CustomLL();
        list1.addLast(1);
        list1.addLast(4);
        list1.addLast(5);

        CustomLL list2 = new CustomLL();
        list2.addLast(2);
        list2.addLast(3);

        CustomLL list3 = new CustomLL();
        list3.addLast(6);

        CustomLL list4 = new CustomLL();
        list4.addLast(0);
        list4.addLast(7);
        list4.addLast(8);
        list4.addLast(9);

        CustomLL list5 = new CustomLL();
        list5.addLast(10);

        System.out.println("List 1,2,3,4 -");
        list1.printList();
        list2.printList();
        list3.printList();
        list4.printList();


        // Add the linked lists to an ArrayList
        ArrayList<CustomLL.Node> listArray = new ArrayList<>();
        listArray.add(list1.head);
        listArray.add(list2.head);
        listArray.add(list3.head);
        listArray.add(list4.head);
        listArray.add(list5.head);

        // Merge all K linked lists
        CustomLL.Node mergedHead = CustomLL.mergeKLists(listArray);

        // Print the merged and sorted linked list
        System.out.println("Merged and Sorted List:");
        CustomLL.Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
