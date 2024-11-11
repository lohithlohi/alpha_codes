import java.util.*;

public class Pushatbottom {

    public static void PushBottom(Stack<Integer> s, int data){
        // base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //work
        int top = s.pop();
        PushBottom(s, data);
        s.push(top);
    }

    public static void Printstack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        PushBottom(s, 4);
        Printstack(s);
        
    }
}
