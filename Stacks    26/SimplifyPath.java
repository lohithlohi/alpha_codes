import java.util.Stack;

public class SimplifyPath {

    public static String simplify(String path){
        int plen = path.length();
        String res = "/";
        Stack<String> st = new Stack<>();
        for (int i = 0; i < plen; i++) {
            String dir = "";
            while(i<plen && path.charAt(i) == '/'){
                i++;   //skip '/'
            }
            while(i<plen && path.charAt(i) != '/'){      // i<plen is to tackle last directory
                dir += path.charAt(i);
                i++;
            }    // now directory ready

            if(dir.equals("..") == true){
                st.pop();
            }else if(dir.equals(".") == true){
                continue;
            }else if(dir.length() != 0){
                st.push(dir);
            }
        }
        // now stack of valid directories are ready
        
        Stack<String> st1 = new Stack<>();
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        while(!st1.isEmpty()){
            if(st1.size() != 1){
                res += st1.pop()+"/";
            }else{
                res += st1.pop();
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        // String path = "/apna/";
        // String path = "/a/..";
        String res = simplify(path);
        System.out.println(res);
    }
}
