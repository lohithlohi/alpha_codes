public class StratsWithPrfx {
    
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

    public static boolean strtwith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {  // i-> levels
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        // no need to check eow for true, because only we are searching for prefix
        return true;   
    }

    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String prefix1 = "app";  // true
        String prefix2 = "moon";  // false
        

        System.out.println(strtwith(prefix1));
        System.out.println(strtwith(prefix2));
    }
}
