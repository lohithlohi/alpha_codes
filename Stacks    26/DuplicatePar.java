import java.util.*;

public class DuplicatePar {

    public static boolean dupparan(String par) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < par.length(); i++) {
            char ch = par.charAt(i);

            if (ch != ']' && ch != ')' && ch != '}') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {  // optional
                    return false;
                }
                if (ch == ')' || ch == '}' || ch == ']') {
                    int count = 0;
                    // something extra in between paranthesis present => Duplicate not there now
                    while (((s.peek() != '(' && ch == ')')
                            || (s.peek() != '{' && ch == '}')
                            || (s.peek() != '[' && ch == ']')) && !s.isEmpty()) {   // isEmpty is optional

                        s.pop();
                        count++;
                    }

                    s.pop();
                    if (count <= 0) { // Duplicate exists
                        return true;
                    }
                }
            }
        }

        return false; // whole string covered and Duplicate not exists
    }

    // for one type of bracket => '()'
    public static boolean isDuplicate(String par){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < par.length(); i++) {
            char ch = par.charAt(i);

            // closing case
            if(ch == ')'){
                int count = 0;

                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count<=0){     // Duplicate exists
                    return true;
                }
                s.pop();   //poping '('
            }
            else{
                s.push(ch);
            }
        }
        return false;    // Duplicate not exists
    }

    public static void main(String[] args) {

        //Valid Paranthesis strings are taken

        // String par = "({[]}{}[()])";
        // String par = "{(a+b)*[(a)={b}]}";

        String par1 = "{(a+b)}";  //true => duplicate paranthesis exists
        String par2 = "(a+b)";  //false => duplicate paranthesis not exists
        String par3 = "((a+b))";   //true => duplicate paranthesis exists
        
        System.out.println(dupparan(par1));

        System.out.println(isDuplicate(par2));
        System.out.println(isDuplicate(par3));
    }
}
