public class compression {

    // TC==> O(n) linear
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        Integer counter = 1;
        
        // for abc ==> a1b1c1 but it's decompression
        // for (int i = 0; i < str.length(); i++) {
        //     if(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
        //         counter++;
        //         continue;
        //     }
        //     sb.append(str.charAt(i));
        //     sb.append(counter.toString());
        //     counter = 1;
        // }

        // for abc ==> abc it's not decompression
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            counter=1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                counter++;
                i++;
            }
            if(counter > 1){
                sb.append(counter.toString());
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "aaabbcccdd";
        // String str = "aaabcd";
        System.out.println(compress(str));
    }
}
