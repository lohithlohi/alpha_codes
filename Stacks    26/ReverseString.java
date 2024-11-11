import java.util.*;

public class ReverseString {

    public static String revstrg(String str){

        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }

        StringBuilder res = new StringBuilder("");

        while(!s.isEmpty()){
            res.append(s.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {

        String str = "lohith";
        String rstr = revstrg(str);
        System.out.println(rstr);

    }
}

