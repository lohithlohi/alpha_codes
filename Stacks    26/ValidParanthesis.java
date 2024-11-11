import java.util.*;

public class ValidParanthesis {

    public static boolean valiparan(String par){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < par.length(); i++) {
            char ch = par.charAt(i);

            // opening case
            if(ch == '[' || ch == '(' || ch == '{'){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                // closing case
                if(s.peek() == '(' && ch == ')'
                    || s.peek() == '{' && ch == '}'
                    || s.peek() == '[' && ch == ']'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String par = "({[]}{}[()])";
        System.out.println(valiparan(par));
    }
}
