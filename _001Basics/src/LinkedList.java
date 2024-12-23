class Node {
    int data;         // Data stored in the node
    Node next;        // Reference to the next node in the linked list

    // Constructor
    public Node(int data1, Node next1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = next1;  // Initialize next with the
    }
    // Constructor
    public Node(int data1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = null;   // Initialize next as null since it's the end of the list
    }
}
public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        // Create a Node 'x' with the first element of the array
        Node x = new Node(arr[0]);
        // Printing the data stored in the Node
        System.out.println(x.data); // 2


        // Create a reference 'y' pointing to the same Node 'x'
        Node y = x;
        // Print the reference 'y', which represents the memory address of the Node 'x'
        System.out.println(y);  // @$@Address

        // Printing the data stored in the Node
        System.out.println(y.data);  // 2
    }
}