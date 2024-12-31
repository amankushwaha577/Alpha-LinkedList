import java.util.ArrayList;
        import java.util.Map;
        import java.util.PriorityQueue;
        import java.util.AbstractMap;
        import java.util.Comparator;

class CustomL2 {
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

        // Constructor to initialize a node with data and next pointer
        public Node(int data, Node nextNode) {
            this.data = data;  // Set the data
            this.next = nextNode;   // Initialize next pointer
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

    // Function to merge K sorted linked lists
    // ---------------------------------------------------------
    // Time Complexity: O(N log K) | Space Complexity: O(K)
    // ---------------------------------------------------------
    // N = Total number of nodes across all K lists.
    // K = The number of lists.
    // 1. We are inserting K elements into the priority queue (heap), and
    //    each insertion operation takes O(log K).
    // 2. We do this for N nodes, so the overall time complexity becomes O(N log K).
    // 3. Space complexity is O(K) due to the space required for the priority queue.
    public static Node mergeKLists(ArrayList<Node> listArray) {
        // Priority queue to maintain sorted order based on node values
        // Pairs store node value and pointer to the node
        PriorityQueue<Map.Entry<Integer, Node>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));

        // Push the heads of all the linked lists into the priority queue
        for (Node node : listArray) {
            // Check if the current linked list exists
            if (node != null) {
                // Push the pair of node data and node pointer into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(node.data, node));
            }
        }

        // Create a dummy node to build the merged list
        Node dummyNode = new Node(-1, null);
        Node temp = dummyNode;

        // Merge the lists present in the priority queue
        while (!pq.isEmpty()) {
            // Get the top element (minimum node value) from the priority queue
            Map.Entry<Integer, Node> it = pq.poll();

            // Check if the current node has a next node
            if (it.getValue().next != null) {
                // Push the next node into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.data, it.getValue().next));
            }

            // Set the next pointer of the current node in the merged list
            temp.next = it.getValue();
            temp = temp.next;
        }

        // Return the merged linked list
        return dummyNode.next;
    }
}

public class Optimal2_MinHeap {
    public static void main(String[] args) {
        CustomL2 list1 = new CustomL2(); // Create the first linked list
        CustomL2 list2 = new CustomL2(); // Create the second linked list
        CustomL2 list3 = new CustomL2(); // Create the third linked list

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
        ArrayList<CustomL2.Node> listArray = new ArrayList<>();
        listArray.add(list1.head);
        listArray.add(list2.head);
        listArray.add(list3.head);

        CustomL2.Node mergedHead = CustomL2.mergeKLists(listArray);

        // Print the merged and sorted linked list
        System.out.println("Merged and Sorted List:");
        CustomL2.Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        // Check if original lists are changed
        System.out.println("-------------------------------------------");
        System.out.println("Original List 1:");
        list1.printList();
        System.out.println("Original List 2:");
        list2.printList();
        System.out.println("Original List 3:");
        list3.printList();

        // If You Need to Preserve the Original Lists:
        // 1. Implement a helper method to deep copy a linked list.
        // 2. Use these copies as inputs to the mergeKLists method.
    }
}
