// import java.util.LinkedList;

public class MergeSortLL {

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

    public Node findmid(Node head){
        Node slow = head;
        Node fast = head.next;  // to get last node of 1st half
        while(fast != null && fast.next != null){
            slow = slow.next;  // +1
            fast = fast.next.next;  // +2
        }
        return slow;
    }

    public Node Merge(Node head, Node rhead){
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head != null && rhead != null){
            if(head.data <= rhead.data){
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }else{
                temp.next = rhead;
                rhead = rhead.next;
                temp = temp.next;
            }
        }
        while(head != null){
            temp.next = head;
            head = head.next;
            temp = temp.next;
        }
        while(rhead != null){
            temp.next = rhead;
            rhead = rhead.next;
            temp = temp.next;
        }

        return mergedll.next;  // neglecting -1 node
    }

    public Node Mergesort(Node head){
        // base case
        if(head == null || head.next == null){
            return head;
        }

        // find mid
        Node midnode = findmid(head);

        // divide
        Node rhead = midnode.next;
        midnode.next = null;
        Node srLhead = Mergesort(head);
        Node srRhead = Mergesort(rhead);

        // merge
        return Merge(srLhead, srRhead);
    }

    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<>();
        MergeSortLL ll = new MergeSortLL();

        ll.addfirst(1);
        ll.addlast(4);
        ll.addlast(2);
        ll.addlast(9);
        ll.addlast(6);
        ll.addlast(8);
        ll.addlast(3);
        ll.addlast(5);

        ll.printll(ll.head);

        ll.head = ll.Mergesort(ll.head);
        
        ll.printll(ll.head);
        
    }
}
