/*

 * Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.

 

Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

 */

import java.util.Stack;
import java.util.TreeMap;

public class Chemicalsformula {
    public static String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stk = new Stack<>();
        TreeMap<String, Integer> currentMap = new TreeMap<>();

        int i = 0;
        while (i < formula.length()) {
            char ch = formula.charAt(i);

            if (Character.isUpperCase(ch)) {
                // Start of an atom (could be followed by lowercase letters)
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                i++;

                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    atomName.append(formula.charAt(i));
                    i++;
                }

                String atom = atomName.toString();

                // Read the count for this atom
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }

                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);
            } else if (ch == '(') {
                // Start of a new group
                stk.push(currentMap);
                currentMap = new TreeMap<>();
                i++;
            } else if (ch == ')') {
                // End of current group
                i++;
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }

                // Multiply counts in currentMap by the count
                for (String atom : currentMap.keySet()) {
                    int originalCount = currentMap.get(atom);
                    currentMap.put(atom, originalCount * count);
                }

                // Merge currentMap into the previous map from stack
                if (!stk.isEmpty()) {
                    TreeMap<String, Integer> prevMap = stk.pop();
                    for (String atom : currentMap.keySet()) {
                        prevMap.put(atom, prevMap.getOrDefault(atom, 0) + currentMap.get(atom));
                    }
                    currentMap = prevMap;
                }
            }
        }

        // Convert TreeMap to desired output format
        StringBuilder sb = new StringBuilder();
        for (String atom : currentMap.keySet()) {
            sb.append(atom);
            if (currentMap.get(atom) > 1) {
                sb.append(currentMap.get(atom));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // String formula = "K4(ON(SO3)2)2";
        String formula = "Mg(OH)2";
        // String formula = "H2O";

        System.out.println(countOfAtoms(formula));
    }
}




/*
 * 
 * To correctly parse and evaluate chemical formulas as described, we need to handle nested structures (parentheses), multi-digit counts for atoms, and ensure the output is sorted alphabetically. Let's correct and improve your code step by step:

### Corrections and Improvements:

1. **Handling Multi-Digit Numbers:**
   - When encountering digits after an atom name, we need to parse the entire number, not just the first digit. This requires iterating through consecutive digits to form the complete number.

2. **Using Stack for Parentheses:**
   - Utilize a stack (`stk`) to manage scopes when encountering parentheses (`(` and `)`). This helps in correctly applying multipliers to elements within parentheses.

3. **Updating Count in TreeMap:**
   - Use `hm.put(atom, count)` to update counts in the `TreeMap`. Ensure that counts are multiplied when applying multipliers from parentheses.

4. **Output Formatting:**
   - Construct the final result by iterating over the `TreeMap` in alphabetical order and appending each atom name with its count.

Here's the corrected and improved code:

```java
class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> hm = new TreeMap<>();
        Stack<TreeMap<String, Integer>> stk = new Stack<>();
        TreeMap<String, Integer> currentMap = new TreeMap<>();

        int i = 0;
        while (i < formula.length()) {
            char ch = formula.charAt(i);

            if (Character.isUpperCase(ch)) {
                // Start of an atom (could be followed by lowercase letters)
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                i++;

                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    atomName.append(formula.charAt(i));
                    i++;
                }

                String atom = atomName.toString();

                // Read the count for this atom
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }

                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);
            } else if (ch == '(') {
                // Start of a new group
                stk.push(currentMap);
                currentMap = new TreeMap<>();
                i++;
            } else if (ch == ')') {
                // End of current group
                i++;
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }

                // Multiply counts in currentMap by the count
                for (String atom : currentMap.keySet()) {
                    int originalCount = currentMap.get(atom);
                    currentMap.put(atom, originalCount * count);
                }

                // Merge currentMap into the previous map from stack
                if (!stk.isEmpty()) {
                    TreeMap<String, Integer> prevMap = stk.pop();
                    for (String atom : currentMap.keySet()) {
                        prevMap.put(atom, prevMap.getOrDefault(atom, 0) + currentMap.get(atom));
                    }
                    currentMap = prevMap;
                }
            }
        }

        // Convert TreeMap to desired output format
        StringBuilder sb = new StringBuilder();
        for (String atom : currentMap.keySet()) {
            sb.append(atom);
            if (currentMap.get(atom) > 1) {
                sb.append(currentMap.get(atom));
            }
        }

        return sb.toString();
    }
}
```

### Explanation of Changes:

- **Using `currentMap` and `stk`:** `currentMap` holds the current counts of atoms at the current level of parsing. `stk` is used to handle nested structures by pushing and popping `TreeMap<String, Integer>`.

- **Parsing Atom Names and Counts:** When encountering uppercase letters, concatenate with subsequent lowercase letters to form atom names. Accumulate digits immediately following an atom name to form the count.

- **Handling Parentheses:** 
  - When encountering `(`, push the current `currentMap` onto the stack and reset `currentMap`.
  - When encountering `)`, multiply counts in `currentMap` by the following count (if any) and merge it into the map popped from the stack.

- **Output Construction:** After parsing, iterate through `currentMap` in alphabetical order and construct the output string accordingly, appending counts only when they are greater than `1`.

This approach ensures that all specified cases (nested parentheses, multi-digit counts, etc.) are handled correctly, producing the desired output format.
 */