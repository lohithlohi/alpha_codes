import java.util.ArrayList;
import java.util.Collections;

public class basics {
    public static void main(String[] args) {
         
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(6);
        list.add(8);
        list.add(2);

        System.out.println(list.get(2));

        System.out.println(list);
        
        Collections.sort(list);
        System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        System.out.println(list.contains(8));

        System.out.println("Size: "+list.size());

        list.set(2, 10);   // updating
        System.out.println(list);

        list.add(1,15);   // inserting
        System.out.println(list);

        //Swapping
        int idx1=1, idx2=3;
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
        System.out.println(list);



        // 2D arrayList
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>(), list3 = new ArrayList<>();
        
        for (int i = 1; i < 5; i++) {
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        
        mainlist.add(list1);
        mainlist.add(list2);
        mainlist.add(list3);
        System.out.println(mainlist);

        //traversal
        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> currlist = mainlist.get(i);
            for (int j = 0; j < currlist.size(); j++) {
                System.out.print(currlist.get(j)+" ");
            }
            System.out.println();
        }
        
        
    }
}
