/*
 * Delete N Nodes After M Nodes of a Linked List We have a linkedlist 
 * and two integers M and N.
 * Traverse the linkedlist such that you retain M nodes then delete next N nodes, 
 * continue the same till end of the linkedlist. 
 * Difficulty Level:Rookie.
 * 
 * Sample Input 1: M=2 N=2    LL: 1->2->3->4->5->6->7->8
 * Sample Output 1: 1->2->5->6
 * 
 * Sample Input 2: M=3 N=2    LL: 1->2->3->4->5->6->7->8->9->10
 * Sample Output 2: 1->2->3->6->7->8
 */

public class Q2 {

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public static Node tail;
    public static int size;

    // ****************************** //

    public void addfirst(int data){
        Node newnode = new Node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }
    public void addlast(int data){
        if(head == null){
            addfirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        tail.next = newnode;
        tail = newnode;
    }

    // ****************************** //

    public void printll(Node head){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

   // ****************************** //

    public Node func(int m, int n, Node head){
        Node temp = head;

        while(temp != null){

            for (int i = 1; i < m; i++) {
                if(temp != null)
                    temp = temp.next;
            }
            if(temp == null){    // imp
                return head;
            }

            Node del = temp.next;

            for (int i = 1; i < n; i++) {
                if(del != null)
                    del = del.next;
            }

            temp.next = del.next;
            temp = temp.next;
        }

        return head;
    }

    // ****************************** //

    public static void main(String[] args) {
        Q2 ll = new Q2();

        ll.addfirst(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.addlast(7);
        // ll.addlast(8);
        // ll.addlast(9);
        // ll.addlast(10);
        ll.printll(ll.head);

        int m = 3, n = 2;
        ll.head = ll.func(m, n,ll.head);
        ll.printll(ll.head);
    }
    
}
