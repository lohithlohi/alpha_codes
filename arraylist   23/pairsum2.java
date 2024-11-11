import java.util.ArrayList;

// 2Pointer Approach   TC=> O(n);
public class pairsum2 {

    public static void findpair(ArrayList<Integer> list, int target){
        // find pivotpoint
        int piv=0;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                piv = i;
                break;
            }
        }
        System.out.println("Break point: "+piv);

        int lp = piv+1;  //smallet
        int rp = piv;    //largest
        int n = list.size();
        boolean flag=false;

        while(lp != rp){
            int sum = list.get(lp) + list.get(rp);
            if(sum == target){
                System.out.println("Pair is: "+list.get(lp)+","+list.get(rp));
                flag=true;
                break;
            }

            if(sum > target){
                rp = (n + rp - 1) % n;    // Anticlock wise rotation of rp
            }
            else if(sum < target){       // Clock wise rotation of lp
                lp = (lp + 1) % n;
            }
        }

        if(!flag){
            System.out.println("Pair not found");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 16;
        // list = [11, 15, 6, 8, 9, 10] -- sorted and rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        
        findpair(list, target);
    }
}
