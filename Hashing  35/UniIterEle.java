import java.util.HashSet;

public class UniIterEle {

    public static void UandI(int arr1[], int arr2[]){
        HashSet<Integer> st = new HashSet<>();

        //UNION
        for (int i = 0; i < arr1.length; i++) {
            st.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            st.add(arr2[i]);
        }
        System.out.println("Union_Size: "+st.size());
        System.out.println("UNION: "+st);

        st.clear();

        // INTERSECION
        
        for (int i = 0; i < arr1.length; i++) {
            st.add(arr1[i]);
        }
        int count = 0;
        System.out.print("INTERSECTION: ");
        for (int i = 0; i < arr2.length; i++) {
            if(st.contains(arr2[i])){
                count++;
                System.out.print(arr2[i]+" "); // to avoid duplicate count
                st.remove(arr2[i]);
            }
        }
        System.out.println("\nIntersection_Size: "+count);
    }
    
    public static void main(String[] args) {
        int arr1[] = {7,3,9, 9};
        int arr2[] = {6,3,9,2,9,4};
        UandI(arr1, arr2);
    }
}
