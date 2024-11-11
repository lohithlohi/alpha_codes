public class MerSortforstring {

    public static void printarray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergesort(String arr[], int si, int ei) {
        // base case
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;
        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        int i = si;
        int j = mid+1;
        int k = 0;
        String temp[] = new String[ei-si+1];

        while(i <= mid && j <= ei){
            if(lexorder(arr[i], arr[j])){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for (k=0, i=si ; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static Boolean lexorder(String str1, String str2) {
        if(str1.compareToIgnoreCase(str2) < 0){  // str1 < str2 a<b<c<....y<z
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // String arr[] = {"sun", "earth", "mars", "mercury"};
        String arr[] = {"surat", "aman", "vijay", "karan"};
        mergesort(arr, 0, arr.length-1);
        printarray(arr);
    }
}
