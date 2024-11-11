/*
 *  Given an array nums of size n, return the majority element. (MEDIUM)
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
    that the majority element always exists in the array.
    
    Sample Input 1 : nums = [3,2,3]
    Sample Output 1 : 3
    Sample Input 2 : nums = [2,2,1,1,1,2,2]
    Sample Output 2 : 2

    Constraints (extra Conditions):
    ● n == nums.length
    ● 1 <= n <= 5 * 104
    ● -109 <= nums[i] <= 109
 */
public class majoritynum {

    // TC => O(n^2)
    public static int findmaj(int arr[]) {
        int majnum = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count >= majnum) {
                return arr[i];
            }
        }
        return -1;
    }

    // TC => O(nlogn)
    public static int findmajority(int arr[], int si, int ei) {
        // base case
        if (si == ei) {
            return arr[si];
        }

        int mid = si + (ei - si) / 2;
        int leftmaj = findmajority(arr, si, mid);
        int rightmaj = findmajority(arr, mid + 1, ei);

        int leftcount = countrange(arr, leftmaj, si, ei);
        int rightcount = countrange(arr, rightmaj, si, ei);

        return (leftcount >= rightcount) ? leftmaj : rightmaj;
    }

    public static int countrange(int arr[], int num, int si, int ei) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[] = {2,2,1,1,1,2,2};
        int arr[] = { 3, 2, 2, 3 };

        System.out.println(findmaj(arr)); // Brutforce

        System.out.println(findmajority(arr, 0, arr.length - 1)); // Divide and conquer
    }
}
