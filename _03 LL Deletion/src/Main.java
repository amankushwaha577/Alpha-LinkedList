
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

    public void deleteFirst(){
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head= head.next;
    }

    public void deleteLast(){
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if(head.next ==null){ // may be the case if only 1 node is there
            head = null; // delete 1st node
            return;
        }
        // if execution is coming in this line it mean no of nodes > 1

        Node temp = head;

        // Traverse the list until the second-to-last node
        while (temp.next.next != null) { // null.next may be the case if only 1 node is there ( handled above )
            temp = temp.next;
        }
        // Nullify the connection from the second-to-last node to delete the last node
        temp.next = null;

//        Node secondLastNode = head;
//        Node lastNode = head.next;  // lastNode = null ( in case only 1 node )
//
//        while(lastNode.next != null){  // null.next may be the case if only 1 node is there ( handled above )
//            lastNode = lastNode.next;
//            secondLastNode = secondLastNode.next;
//        }
//
//        secondLastNode.next = null;

    }


    public void deleteByPosition(int k) {
        // Check if the list is empty
        if (head == null)
            return;

        // If k is 1, delete the first node
        if (k == 1) {
            head = head.next;
            return;
        }

        // Traverse the list to find the k-th node
        Node temp = head;
        Node prev = null;
        int cnt = 0;

        while (temp != null) {
            cnt++;
            // If the k-th node is found
            if (cnt == k) {
                // Adjust the pointers to skip the k-th node
                prev.next = prev.next.next;
                break;
            }
            // Move to the next node
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteByValue(int val) {
        // Check if the list is empty
        if (head == null)
            return;

        // If the first node has the target value, delete it
        if (head.data == val) {
            head = head.next;
            return;
        }

        // Traverse the list to find the node with the target value
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                // Adjust the pointers to skip the node with the target value
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }


}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        for (int i = 0; i < 9; i++) {
            list.addLast(i);
        }
        list.printList();

        System.out.println("-------------------------------------------");

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println("------------------------------------------------------");

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2

        list.deleteByValue(7);
        list.printList(); // After deleting the node with value 7


    }
}