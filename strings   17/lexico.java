public class lexico {

    // TC ==> O(x*N)   x-length of largest string , N size of string array
    public static void main(String[] args) {
        String fruits[] = {"apple" , "mango", "grapes", "banana"};

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if(largest.compareTo(fruits[i]) < 0){   // largest < fruits[i]
                largest = fruits[i];
            }
        }
        // largest.compareToIgnoreCase(fruits[i]);  to avoid case sensitive problems
        System.out.println(largest);
        
    }
}
