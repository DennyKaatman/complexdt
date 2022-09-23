package Assignment1.Sort;

public class BubbleSort {
    /**
     * bubbleSort function.
     * Sorts the array in
     * @param arr unsorted array
     * Copied from: https://www.javatpoint.com/bubble-sort-in-java
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    /**
     * @param arr sorted array
     * @return true if array is sorted otherwise false
     */
    public static boolean isSorted(int[] arr) {
        for(int i =1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) return false;
        }
        return true;
    }

}
