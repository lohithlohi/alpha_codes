import java.util.ArrayList;

public class Q2lLonelynum {

    public static ArrayList<Integer> find_lonely(ArrayList<Integer> list) {
        ArrayList<Integer> outpt = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.contains(list.get(i) - 1) || list.contains(list.get(i) + 1)) {
                continue;
            } else if (outpt.contains(list.get(i))) {  // if "duplicate"
                outpt.remove(list.get(i));
            } else {
                outpt.add(list.get(i));
            }
        }

        return outpt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);

        // list.add(1);
        // list.add(3);
        // list.add(5);
        // list.add(3);

        System.out.println(find_lonely(list));
    }
}
