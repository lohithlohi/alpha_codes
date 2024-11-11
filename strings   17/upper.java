public class upper {

    public static String touppercase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        // TC ==> O(n) linear
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i <= str.length()){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, i aM loHith";
        System.out.println(touppercase(str));

        String str1 = "lohith";
        // for (int i = 0; i < str1.length(); i++) {
        //     // if(i==0){
        //     //     str1 += Character.toUpperCase(str1.charAt(i));
        //     //     continue;
        //     // }
        //     str1 += str1.charAt(i);
        // }
        str1 = str1.substring(0, 1).toUpperCase()+str1.substring(1, str1.length());
        System.out.println("str1 = "+str1);
    }
}
