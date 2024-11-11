import java.util.List;

@SuppressWarnings("unused")

public class BasicTries {

    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    
    // TC => O(L)  "L" is length of largest word
    public static void insert(String word){
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {  // level wise traverse type
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];   // next level navigation
        }
        curr.eow = true;  // last node or end of word letter
    } 

    // TC => O(L)  "L" is length of largest word
    public static boolean searchIn(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            // atleast not null, has something
            curr = curr.children[idx];
        }
        return curr.eow;    // tells wheather it is full word or small part of the word
    }

    // word break problem TC => O(L) L -> largest word length
    public static boolean wordbreak(String key){
        // by default right part is true (only need to check left part)
        if(key.length()==0){
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String left = key.substring(0, i);
            String right = key.substring(i);
            if(searchIn(left) && wordbreak(right)){   // recursive operation for right part
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(searchIn("any"));

        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordbreak(key));
    }
}
