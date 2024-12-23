import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addFirst(7);
        list.addFirst(9);
        System.out.println(list);

        list.addLast(777);
        list.add(9999); // if we write "add" it means add at Last
        System.out.println(list);

        System.out.println(list.size());
    }
}