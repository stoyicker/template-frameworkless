package quicksort;

public final class QuickSort {
    public static void intArray(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int left, int right) {
        int pivot = array[left + (right - left) / 2];
        int leftInternal = left;
        int rightInternal = right;
        while (leftInternal <= rightInternal) {
            while (leftInternal < array.length && pivot > array[leftInternal]) {
                leftInternal++;    
            }
            while (rightInternal >= 0 && pivot < array[rightInternal]) {
                rightInternal--;
            }
            if (leftInternal <= rightInternal) {
                // If they're the same index, no need to swap, but still gotta update the indexes
                swap(array, leftInternal, rightInternal);
                leftInternal++;
                rightInternal--;
            }
        }
        if (leftInternal < right) {
            quicksort(array, leftInternal, right);
        }
        if (rightInternal > left) {
            quicksort(array, left, rightInternal);
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
