import java.util.ArrayList;

public class Heapbasicfun {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data){
            list.add(data);
            int x = list.size()-1;   // child index
            int par = (x-1)/2;   // parent index

            while (list.get(x) < list.get(par)) {   //O(logn)
                // swap
                int temp = list.get(x);
                list.set(x, list.get(par));   //(where, what)
                list.set(par, temp);

                x = par;   // update child index
                par = (x-1)/2;   // update parent index
            }
        }

        
        public int peek(){
            return list.get(0);
        }


        public void display(){
            System.out.println(list);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minidx = i;   // assume

            if(left < list.size() && list.get(minidx) > list.get(left)){
                minidx = left;
            }

            if(right < list.size() && list.get(minidx) > list.get(right)){
                minidx = right;
            }

            if(minidx != i){
                // swap i and minidx
                int temp = list.get(i);
                list.set(i, list.get(minidx));
                list.set(minidx, temp);

                heapify(minidx);
            }
        }

        public int remove(){
            int data = list.get(0);

            // 1. swap root and last
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1, temp);

            // 2. delete last node
            list.remove(list.size()-1);

            // Modify for correctness
            heapify(0);    // O(logn)
            
            return data;
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        
        hp.display();

        hp.add(6);
        hp.display();

        while (!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
