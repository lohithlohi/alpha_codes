public class StkLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack{
        Node head = null;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newnode = new Node(data);
            if(isEmpty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack stak = new Stack();

        stak.push(1);
        stak.push(2);
        stak.push(3);
        stak.push(4);

        while (!stak.isEmpty()) {
            System.out.println(stak.peek());
            stak.pop();
        }
    }
}
