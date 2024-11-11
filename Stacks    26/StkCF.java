import java.util.*;

public class StkCF {

    public static void main(String[] args) {
        Stack<Integer> stak = new Stack<>();

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
