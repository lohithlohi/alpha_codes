
public class Subsets {

    public static void findsubsets(String str, String ans, int i) { // "i" is a level couter/ character of str counter
        // base case
        if(i == str.length()){
            if(ans.length() == 0){   // ans == ""
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }

        //work
        // Yes choice
        findsubsets(str, ans+str.charAt(i), i+1);   // 1st character added to "ans" then sent to next level

        // No choice
        findsubsets(str, ans, i+1);   // character isn't added but sent to next level  //backtracking step

        /*
         * "ans" is a string so it is "pass by value" so NO Need to delete added character
         * if StringBuilder is used it is "pass by reference" so Need to delete the added character
         */

    }
    public static void main(String[] args) {
        String str = "abc";
        findsubsets(str, "", 0);
    }
}
