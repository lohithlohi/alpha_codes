import java.util.Stack;

public class DecodeString {

    public static String decodestrg(String str) {
        String res = "", temp = "";
        int mult = 0;

        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ']') {
                while(s1.peek() != '['){
                    temp = s1.pop() + temp;
                }
                // System.out.println(temp);
                s1.pop();
                char num = s1.pop();
                mult = num - '0';
                for (int j = 0; j < mult; j++) {
                    res += temp;
                }
            }
            else{
                s1.push(str.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "3[b2[v]]";
        // String str = "2[cv]";
        String res = decodestrg(str);
        System.out.println(res);
    }
}
