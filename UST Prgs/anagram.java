import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class anagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
          // Sort the characters of the string
          char[] charArray = str.toCharArray();
          Arrays.sort(charArray);
          String sortedString = new String(charArray);
          
          // Group anagrams under the sorted string as key
          if (!map.containsKey(sortedString)) {
            map.put(sortedString, new ArrayList<>());
          }
          map.get(sortedString).add(str);
        }
        
        // Convert the HashMap to a List of Lists
        return new ArrayList<>(map.values());
      }
    
      public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagrams(strs);
        
        System.out.println("Grouped Anagrams:");
        for (List<String> group : groups) {
          System.out.println(group);
        }
      }
}
