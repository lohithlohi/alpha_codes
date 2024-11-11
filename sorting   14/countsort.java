// original use for positive number and range is short

public class countsort {

    public static void countsrt(int arr[]) {

        // find largest for count range
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(arr[i],largest);
        }

        int count[] = new int [largest+1];   // +1 because 0th index

        // find frequency of elements
        for(int i=0; i< arr.length; i++){
            count[arr[i]]++;
        }

        // travesing along count array and sorting
        int x=0;
        for (int i = 0; i < count.length; i++) {         // for ascending
        // for (int i = count.length-1; i >= 0; i--) {   // for descening
            while(count[i] != 0){
                arr[x++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 2, 1};
        countsrt(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
