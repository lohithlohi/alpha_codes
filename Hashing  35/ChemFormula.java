import java.util.Stack;
import java.util.TreeMap;

public class ChemFormula {

    public static String giveAtoms(String s){
        TreeMap<String, Integer> currmap = new TreeMap<>();
        Stack<TreeMap<String, Integer>> stk = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            
            if(Character.isUpperCase(ch)){
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                i++;

                while (i < s.length() && Character.isLowerCase(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                String atom = sb.toString();
                int count = 0;
                if(i < s.length() && Character.isDigit(s.charAt(i))){
                    count = (s.charAt(i) - '0');
                    i++;
                }
                if(count == 0){
                    count = 1;
                }

                currmap.put(atom, currmap.getOrDefault(atom, 0) + count);
            }
            else if(ch == '('){
                stk.push(currmap);
                // new group start
                currmap = new TreeMap<>();
                i++;
            }
            else if(ch == ')'){
                i++;
                int count = 0;
                if(i < s.length() && Character.isDigit(s.charAt(i))){
                    count = (s.charAt(i) - '0');
                    i++;
                }
                if(count == 0){
                    count = 1;
                }

                // multiply to currmap (current group)
                for(String atom : currmap.keySet()){
                    currmap.put(atom, currmap.get(atom) * count);
                }

                // merge with prev group if exists
                if(!stk.isEmpty()){
                    TreeMap<String, Integer> prevmap = stk.pop();
                    for(String atom : currmap.keySet()){
                        prevmap.put(atom, prevmap.getOrDefault(atom, 0) + currmap.get(atom));
                    }
                    currmap = prevmap;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(String atom : currmap.keySet()){
            res.append(atom);
            if(currmap.get(atom) > 1){
                res.append(currmap.get(atom));
            }
        }
        return res.toString();
    }
    

    public static void main(String[] args) {
        // String formula = "K4(ON(SO3)2)2";
        String formula = "Mg(OH)2";
        // String formula = "H2O";

        System.out.println(giveAtoms(formula));
    }
}
