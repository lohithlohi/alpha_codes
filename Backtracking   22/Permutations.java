public class Permutations {

    public static void findpermutations(String str, String ans) {
        // base case
        if(str.length() == 0){  // whent "str" is empty => "ans" is one of a permutation
            System.out.println(ans);
            return;
        }
        
        //recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);  // Deletion of i'th character from string
            findpermutations(newstr, ans+curr);  // adding i'th char to "ans"
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findpermutations(str, "");
    }
}
