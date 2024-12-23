
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
        }

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


}
public class LL {
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

       list.addFirst(50);
       list.printList();

       System.out.println("-------------------------------------------");

       list.deleteFirst();
       list.printList();

       list.deleteLast();
       list.printList();
    }
}