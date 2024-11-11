import java.util.ArrayList;

public class StkAL {

    public static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
        }
    }

    public static void main(String[] args) {
        Stack stk = new Stack();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        while (!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }

    }
}
