public class QueinArr {
    
    static class Queue{

        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty(){
            return rear == -1;
        }

        public void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // TC=>O(n)
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            // moving whole array left by 1
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
