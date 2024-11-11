/*
 * Find First non-repeating letter in stream of characters
 * TC => O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

public class First_nonrep_letter {

    public static void firnonlett(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
            freq[str.charAt(i) - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";    //o/p => { a -1 b b b b x } 
        firnonlett(str);
    }
}
