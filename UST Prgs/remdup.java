import java.util.ArrayList;

public class remdup {

    public static int removeDuplicates(ArrayList<Integer> nums) {
        if (nums.size() == 0) {
          return 0;
        }
        
        int i = 0;
        for (int j = 1; j < nums.size(); j++) {
          if (nums.get(i) != nums.get(j)) {
            // Move unique element to the next position
            i++;
            nums.set(i, nums.get(j));
          }
        }
        
        // Length is i + 1 (including the last element)
        return i + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);

        System.out.println("Length: "+removeDuplicates(list));
    }
}
