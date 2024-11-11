import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static boolean anagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        // Add 's' 1st
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }

        // remove 't' one by one
        for (int i = 0; i < t.length(); i++) {
            char k = t.charAt(i);
            if(hm.containsKey(k)){
                if(hm.get(k) == 1){
                    hm.remove(k);
                }else{
                    hm.put(k, hm.get(k) - 1);
                }
            }else{
                return false;
            }
        }

        return hm.isEmpty();  //true => all elements are removed
    }
    
    public static boolean valAna(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        char s1[] = s.toCharArray();
        char s2[] = t.toCharArray();

        Arrays.sort(s1); Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    public static void main(String[] args) {
        // String s = "tulip";
        // String t = "lipid";

        String s = "race";
        String t = "care";
        int x = 12345;
        StringBuilder y = new StringBuilder();
        y.append(String.valueOf(x));
        y.reverse();
        x = Integer.parseInt(y.toString());
        System.out.println(x);
        
        // System.out.println(anagram(s, t));
        // System.out.println(valAna(s, t));
    }
}
