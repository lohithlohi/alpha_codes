import java.util.*;

public class RevStack {

    public static void PushBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        PushBottom(s, data);
        s.push(top);
    }

    public static void revstk(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        revstk(s);       // process of removing all elements
        PushBottom(s,top);    // bottom push
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
        s.push(4);

        revstk(s);
        Printstack(s);
    }
}
