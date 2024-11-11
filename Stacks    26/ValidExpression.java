import java.util.Stack;

public class ValidExpression {
    public static boolean valiparan(String par){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < par.length(); i++) {
            char ch = par.charAt(i);

            // closing case
            if(ch == ')' || ch == ']' || ch == '}'){
                if(s.isEmpty()){
                    return false;
                }
                // closing case
                while((s.peek() != '(' && ch == ')'   // not a pair
                    || s.peek() != '{' && ch == '}'
                    || s.peek() != '[' && ch == ']') && !s.isEmpty()){
                    s.pop();
                }
                s.pop();   // popping opening brackets (, {, [ .
            }
            else{   // opening case
                s.push(ch);
            }
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        // String par1 = "({[]}{}[()])";
        // String par2 = "(a+b)";
        // String par3 = "((a+B-c))";
        String par4 = "((a+B-c)+{b-c}*[a])";
        System.out.println(valiparan(par4));
    }
}
