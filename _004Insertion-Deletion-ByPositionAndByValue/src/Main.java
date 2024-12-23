
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
    }


}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        for(int i = 0; i<9; i++){
            list.addLast(i);
        }
        list.printList();


    }
}