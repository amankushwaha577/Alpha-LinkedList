
class CustomLinkedList {
    Node head; // head of list
    class Node {
        int data;         // Data stored in the node
        Node next;        // Reference to the next node in the linked list

        public Node(int data1) {
            this.data = data1;  // Initialize data with the provided value
            this.next = null;   // Initialize next as null since it's the end of the list
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head ==null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head= newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){ // reach last node
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void insertByPosition(int k, int val) {
        // Inserts a new node with the given data at a specific position.
        Node newNode = new Node(val);

        if (k == 1) { // Insert at the head.
            newNode.next = head;
            head = newNode;
            return;
        }

        int cnt = 0;
        Node temp = head;

        // Traverse the linked list to find the node at position k-1
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                // Insert the new node after the node at position k-1
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void insertBeforeValue(int k, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return;
        }

        // Insert at the beginning if the value matches the head's data
        if (head.data == k) {
            newNode.next = head;
            head = newNode;
            return;
        }


        Node temp = head;

        while (temp.next != null) {
            // Insert at the current position if the next node has the desired value
            if (temp.next.data == k) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("List Is Empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null){ // reach last node
            System.out.print(currNode.data +" -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }



}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.printList();

        list.addLast(98);
        list.addLast(99);
        list.printList();


        System.out.println("------------------------------------------------------");

        list.insertByPosition(2,99999);
        list.printList();

        list.insertBeforeValue(99999, 888);
        list.printList();


    }
}