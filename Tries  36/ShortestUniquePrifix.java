import java.util.ArrayList;

public class ShortestUniquePrifix {
    
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();  // root node
    
    // TC => O(L)  "L" is length of largest word
    public static void insert(String word){
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {  // level wise traverse type
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];   // next level navigation
        }
        curr.eow = true;  // last node or end of word letter
    }
    
    // METHOD 1: O(L)
    static ArrayList<String> list = new ArrayList<>();
    /* find shortest unique prefix of each word in list */
    public static void shoruprefix(String word){
        Node curr = root;
        String ans = "";
        for (int level = 0; level < word.length(); level++) {  // level wise traverse type
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx].freq == 1) {
                ans += word.charAt(level);
                list.add(ans);
                break;
            }
            ans += word.charAt(level);
            curr = curr.children[idx];   // next level navigation
        }
    }

    // METHOD 2: O(L)
    // traversing like binary tree !!
    public static void findprifx(Node root, String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            list.add(ans);
            return;
        }

        for(int i = 0; i < root.children.length; i++){ // 0 to 25
            if(root.children[i] != null){
                findprifx(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"zebra", "dog", "duck", "dove"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        root.freq = -1;

        // for (int i = 0; i < words.length; i++) {
        //     shoruprefix(words[i]);
        // }
        
        findprifx(root, "");
        System.out.println(list);
    }
}
