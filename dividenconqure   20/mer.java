// package dividenconqure;

public class mer {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];
        
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        
        for (int i = mid; i < arr.length; i++) {
            rightArr[i - mid] = arr[i];
        }
        
        sort(leftArr);
        sort(rightArr);
        merge(arr, leftArr, rightArr);
    }
    
    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
