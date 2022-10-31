package Case.Sort;


public class QuickSort {
    private static void QuickSort(int[] array, int left, int right){
        int index = partition(array, left, right);

        if(left < index - 1){
            QuickSort(array, left, index - 1);
        }
        if(index < right){
            QuickSort(array, index, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }
        return  left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 5 , 15, 20, 129, 204, 4};
        QuickSort(array, 0, array.length -1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
