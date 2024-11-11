// import java.util.List;

public class LinkedList {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
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

    public void printll(){
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

    public void addinmiddle(int idx, int data){
        if(idx == 0){
            addfirst(data);
            return;
        }
        
        int i=0;
        Node temp = head;
        while(i < idx-1){   // go to previous of idx
            temp = temp.next;
            i++;
        }
        Node newnode = new Node(data);
        size++;
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void printsize(){
        if(size == 0){
            System.out.println("Linked list is empty");
        }else{
            System.out.println("Linked list size is: "+size);
        }
    }

    public void removefirst(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void removelast(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        if(size == 1){
            head = null;
            return;
        }
        
        Node temp = head;
        for (int i = 1; i < size-1; i++) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void itersearch(int key){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                System.out.println("key found at idx: "+i);
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Key not found");
    }
    

    public int helper(Node head, int key){
        // base case
        if(head ==  null){
            return -1;
        }

        if(head.data == key){   // found case
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){    // not found case
            return -1;
        }

        return 1 + idx;
    }
    public void recusearch(int key){
        helper(head, key);
    }


    public void reversell(){
        Node prev = null;
        Node curr = tail = head;
        Node next = curr.next;

        while(curr != null){
            next = curr.next;   // define next
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removefromlast(int n){   // nth node from last/tail
        // find size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        System.out.println("Size: "+sz);
        // go to sz-nth node
        int i = 1;
        int itoFind = sz-n;
        Node prev = head;
        while(i < itoFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }


    // TC => O(n^2)
    public void isPallindrome1(){
        Node start = head;
        Node end = tail;

        while(start.data == end.data){
            if(start == end){
                System.out.println("Pallindrome");
                return;
            }
            start = start.next;

            Node temp = head;
            while(temp.next != end){
                temp = temp.next;
            }
            end = temp;

            if(start.next == end && start.data == start.next.data){
                System.out.println("Pallindrome");
                return;
            }
        }
        System.out.println("Not Pallindrome");
    }
    

    // Slow fast Technique
    public Node findMid(Node head){
        Node slow = head;  // turtle
        Node fast = head;  // hare

        while(fast != null && fast.next != null){
            slow = slow.next;     // Turtle
            fast = fast.next.next;  // Hare
        }
        return slow;   // slow is at mid node
    }
    // TC => O(n)   SC => O(1)
    public void isPallindrome2(){
        if(head == null || head.next == null){
            System.out.println("Palindrome");
            return;
        }
        // find mid
        Node midnode = findMid(head);

        // reverse 2nd half LL
        Node prev = null;
        Node curr = midnode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // checking 
        Node left = head;
        Node right = tail;  // right = prev

        //     //   even case          odd case
        // while(right != null || (right != null && left != null)){
        //     if(right.data != left.data){
        //         System.out.println("Not palindrome");
        //         return;
        //     }
        // }
        // System.out.println("Palindrome");

        while(left.data == right.data){
            if(right.next == null){
                System.out.println("Palindrome");
                return;
            }
            right = right.next;
            left = left.next;
        }
        System.out.println("Not palindrome");
    }

    public boolean detectcycle(){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2
            if(slow == fast){
                System.out.println("Cycle exist");
                return true;
            }
        }
        System.out.println("Cycle dosen't exist");
        return false;
    }

    public void removecycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){    // after at some distance
                cycle = true;
                break;
            }
        }
        if(!cycle){
            System.out.println("Cycle dosen't exist");
            return;
        }

        // remove cycle
        slow = head;
        Node prev = null;

        while(slow != fast){
            slow = slow.next;
            prev = fast;   // tracking previous of fast
            fast = fast.next;
        }
        prev.next = null; // making last.next->null
        System.out.println("Cycle removed");
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        // List<Integer> ll = new java.util.LinkedList<Integer>();
        ll.printll();

        // ll.addfirst(1);
        // ll.addlast(2);
        // ll.addlast(4);
        // ll.addinmiddle(2, 3);
        // ll.addlast(5);
        // ll.printll();

        // ll.removefirst();
        // ll.removelast();
        // ll.printll();

        // ll.addlast(4);
        // ll.addlast(5);
        // ll.addfirst(1);
        
        // ll.printll();

        // ll.removefromlast(2);
        // ll.printll();


        // Pallindrome checking
        // ll.addfirst(1);
        // ll.addlast(2);
        // ll.addlast(4);
        // ll.addlast(5);
        // ll.addlast(5);
        // ll.addlast(6);
        // ll.addlast(2);
        // ll.addlast(1);
        // ll.isPallindrome2();

        // Cycle problem
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = head.next.next;
        // // 1->2->3->4->5->3
        // ll.detectcycle();
        // // ll.printll();     // infinite loop of cycle .....3->4->5->3......
        // ll.removecycle();
        // ll.detectcycle();
        // ll.printll();



    }
}
