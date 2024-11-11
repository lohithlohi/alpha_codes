public class CountUniqeSubstr {
    
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

    // recurcive function like binary tree
    public static int countnodes(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;

        // return cnt(left) + cnt(right) + 1   (in binary tree)
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count += countnodes(root.children[i]);
            }
        }
        return count + 1;  // 1 for selfnode
    } 

    public static int finsubstr(String str){
        
        /*
         * 1. get all suffix
         * 2. build tries from suffixs
         * 3. count total nodes => unique/distinct prefixes/substrings
         */

        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i);
            insert(substr);
        }
        int total_nodes = countnodes(root);
        return total_nodes;
    }

    public static void main(String[] args) {
        String word1 = "ababa";  // 10
        String word2 = "apple";  // 15

        System.out.println(finsubstr(word1));
        System.out.println(finsubstr(word2));
    } 
}
