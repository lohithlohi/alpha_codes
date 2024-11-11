public class ZigzagLL {
    
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

    public Node zigzag(){
        // find mid
        Node midnode = findmid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midnode.next;
        midnode.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // alternate join
        Node lhead = head;
        Node rhead = tail;
        Node lnext, rnext;

        while(lhead != null && rhead != null){
            // zigzag linking
            lnext = lhead.next;
            lhead.next = rhead;
            rnext = rhead.next;
            rhead.next = lnext;
            // updating
            lhead = lnext;
            rhead = rnext;
        }

        return head;
    }
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<>();
        ZigzagLL ll = new ZigzagLL();

        ll.addfirst(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        // ll.addlast(6);
        // ll.addlast(7);
        // ll.addlast(8);
        ll.printll(ll.head);

        ll.head = ll.zigzag();
        ll.printll(ll.head);
        
    }
}
