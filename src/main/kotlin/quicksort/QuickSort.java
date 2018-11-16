package quicksort;

public final class QuickSort {
    public static void intArray(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int leftIndex, int rightIndex) {
        int pivot = array[(rightIndex + leftIndex) / 2];
        int leftIndexInternal = leftIndex;
        int rightIndexInternal = rightIndex;
        while (leftIndexInternal <= rightIndexInternal) {
            while (array[leftIndexInternal] <= pivot) {
                leftIndexInternal++;
            }
            while (array[rightIndexInternal] >= pivot) {
                rightIndexInternal++;
            }
            if (leftIndexInternal <= rightIndexInternal) {
                swap(array, leftIndexInternal, rightIndexInternal);
                leftIndexInternal++;
                rightIndexInternal++;
            }
        }
        if (leftIndex < rightIndexInternal) {
            quicksort(array, leftIndex, rightIndexInternal);
        }
        if (rightIndex > leftIndexInternal) {
            quicksort(array, leftIndexInternal, rightIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
