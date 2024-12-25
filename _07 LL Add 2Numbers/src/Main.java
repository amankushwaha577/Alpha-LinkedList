class CustomLinkedList {
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
        while (currNode != null) { // Traverse and print each node
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // End of the list
    }

    // Method to add two linked lists and return the result as a new list
    public CustomLinkedList addTwoNumbers(CustomLinkedList l1, CustomLinkedList l2) {
        Node p1 = l1.head; // Pointer for the first list
        Node p2 = l2.head; // Pointer for the second list

        Node dummy = new Node(0); // Dummy node to simplify list creation
        Node current = dummy;     // Pointer to track the result list

        int carry = 0;            // To store the carry value

        // Process both linked lists until one of them is fully traversed
        while (p1 != null || p2 != null) {
            int sum = carry; // Start with the carry value

            if (p1 != null) {
                sum += p1.data; // Add value from the first list
                p1 = p1.next;   // Move to the next node in the first list
            }

            if (p2 != null) {
                sum += p2.data; // Add value from the second list
                p2 = p2.next;   // Move to the next node in the second list
            }

            carry = sum / 10;  // Update the carry (1 if sum >= 10, else 0)
            current.next = new Node(sum % 10); // Add the last digit of the sum as a new node
            current = current.next;           // Move to the next node in the result list
        }

        // If there's a remaining carry after processing both lists, add it
        if (carry > 0) {
            current.next = new Node(carry);
        }

        // Create a result list and set its head to the dummy's next
        CustomLinkedList result = new CustomLinkedList();
        result.head = dummy.next; // Node(0); removed now

        return result; // Return the resultant list
    }
}

public class Main {
    public static void main(String[] args) {
        // Create the first linked list
        CustomLinkedList list1 = new CustomLinkedList();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(3);

        // Create the second linked list
        CustomLinkedList list2 = new CustomLinkedList();
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(4);

        // Print the first list
        System.out.println("List 1:");
        list1.printList();

        // Print the second list
        System.out.println("List 2:");
        list2.printList();

        // Add the two lists
        System.out.println("Result of Addition:");
        CustomLinkedList result = new CustomLinkedList();
        result = result.addTwoNumbers(list1, list2);
        result.printList();
    }
}


//    Node dummy = new Node(0); Why ?
//    Without a Dummy Node:
//    -------------------------------------------
//    1. If you don't use a dummy node, you'd need to separately track the head of the result list and make sure you don't lose the reference to it when adding new nodes.
//    2. As you add nodes, you have to take extra care to point the first node correctly, which introduces additional complexity (e.g., you need to initialize the head separately and make sure it's not lost).
//    3. "The dummy node is created with a default value (here, 0). This value is not important since the dummy node itself is never part of the final result list".
//       result.head = dummy.next; // Node(0); removed now