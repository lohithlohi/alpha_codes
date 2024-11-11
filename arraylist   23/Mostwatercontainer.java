import java.util.ArrayList;

public class Mostwatercontainer {

    //Brute Force  TC => O(n^2)
    public static int maxwatervol1(ArrayList<Integer> height){
        int maxvol = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int wtrhgt = Math.min(height.get(i), height.get(j));
                int wtrwdth = j-i;
                int currvol = wtrhgt * wtrwdth;
                maxvol = Math.max(maxvol, currvol);
            }
        }

        return maxvol;
    }

    // 2Pointer Approach   TC=> O(n);
    public static int maxwatervol2(ArrayList<Integer> height){
        int lp = 0;
        int rp = height.size()-1;
        int maxvol = 0;

        while(lp < rp){
            // find area
            int wtrhgt = Math.min(height.get(lp), height.get(rp));
            int wtrwdth = rp - lp;
            int currvol = wtrhgt * wtrwdth;
            maxvol = Math.max(maxvol, currvol);

            // pointer update
            if(height.get(lp) < height.get(rp)){
                lp++;    // go right
            }else{
                rp--;    // go left
            }
        }

        return maxvol;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);    // height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println("Input : "+height);

        System.out.println("BruteForce:: Max vol: "+maxwatervol1(height));
        System.out.println("2Pointer:: Max vol: "+maxwatervol2(height));
        
    }
}
