/*
 * Swapping Nodes in a Linked List We have a linkedlist and two keys in it,swap nodes 
 * for two given keys.Nodes should be swapped by changing links.
 * Swapping data of nodes may be expensive in many situations when data contains many fields.
 * It may be assumed that all keys in the linked list are distinct.
 * 
 * Sample Input 1: 1->2->3->4,  x = 2, y = 4
 * Sample Output 1: 1->4->3->2
 */

public class Q3 {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public static Node tail;
    public static int size;

    // ****************************** //

    public void addfirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addlast(int data) {
        if (head == null) {
            addfirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        tail.next = newnode;
        tail = newnode;
    }

    // ****************************** //

    public void printll(Node head) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ****************************** //

    public void swapfunc(Node head, int x, int y){
        if(x == y){
            return;
        }

        Node xcurr = head;
        Node xprev = null;
        while(xcurr != null && xcurr.data != x){
            xprev = xcurr;
            xcurr = xcurr.next;
        }

        Node ycurr = head;
        Node yprev = null;
        while(ycurr != null && ycurr.data != y){
            yprev = ycurr;
            ycurr = ycurr.next;
        }

        if(xcurr == null || ycurr == null){  // key not found case
            return;
        }

        if(xprev == null){
            head = ycurr;
        }else{
            xprev.next = ycurr;
        }

        if(yprev == null){
            head = xcurr;
        }else{
            yprev.next = xcurr;
        }

        Node xcontu = xcurr.next;
        xcurr.next = ycurr.next;
        ycurr.next = xcontu;

        return;
    }

    public static void main(String[] args) {
        Q3 ll = new Q3();

        ll.addfirst(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.addlast(7);
        ll.addlast(8);
        ll.addlast(9);
        ll.addlast(10);
        ll.printll(ll.head);

        int k1 = 1, k2 = 10;
        ll.swapfunc(ll.head, k1, k2);
        ll.printll(ll.head);
    }
}
