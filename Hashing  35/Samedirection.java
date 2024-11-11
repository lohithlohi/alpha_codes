import java.util.HashMap;

public class Samedirection {

    public static int majdir(String str){
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            
            // if(hm.containsKey(key)){
            //     hm.put(key, hm.get(key)+1);
            // }else{
            //     hm.put(key, 1);
            // }
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }

        int max=0;
        // Set<Character> ks = hm.keySet();
        // for (char k : ks) {
        for(char k : hm.keySet()){
            max = Math.max(max, hm.get(k));
        }

        return str.length()-max;
    }
    
    public static void main(String[] args) {
        String str = "^VV<V";
        // String str = "V>>>VV";
        // String str = "<<<";
        
        System.out.println(majdir(str));
    }
}
