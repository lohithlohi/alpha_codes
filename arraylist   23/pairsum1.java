import java.util.ArrayList;

// 2Pointer Approach   TC=> O(n);
public class pairsum1 {

    public static void findpair(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;
        boolean flag = false;

        while(lp < rp){   // while(lp != rp)

            int sum = list.get(lp) + list.get(rp);    // sum of pair

            if(sum == target){
                System.out.println("Pair is: "+list.get(lp)+","+list.get(rp));
                // lp++;
                rp--;
                flag=true;
            }
            
            if(sum > target){   // edit in higer side of list =>> left move ==> rp--
                rp--;
            }
            else if(sum < target){   // edit in lower side of list =>> right move ==> lp++
                lp++;
            }

            /*
             * logic:
             * if total sum < target go to bigger numbers ==> right move
             * if total sum > target go to smaller numbers ==> left move
             */
        }

        if(!flag){
            System.out.println("No Pairs found");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 5;

        for (int i = 1; i <= 6; i++) {
            list.add(i);
        }

        findpair(list, target);
    }
}
